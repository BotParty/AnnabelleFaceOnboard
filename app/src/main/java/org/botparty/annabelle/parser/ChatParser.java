package org.botparty.annabelle.parser;

import org.botparty.annabelle.command.ChatCommand;
import org.botparty.annabelle.command.CommandGenerator;
import org.botparty.annabelle.parser.antlr4.BellechatBaseVisitor;
import org.botparty.annabelle.parser.antlr4.BellechatLexer;
import org.botparty.annabelle.parser.antlr4.BellechatParser;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.BailErrorStrategy;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.apache.commons.lang3.StringUtils;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.inject.Inject;


/**
 * Created by brandon on 2/20/2017.
 */

public class ChatParser {
    private CommandGenerator _generator;
    @Inject
    public ChatParser(CommandGenerator generator) {
        _generator = generator;
    }
    public List<ChatCommand> parse(String text) throws Throwable {

        try {
            InputStream input = new ByteArrayInputStream(text.getBytes());
            CharStream stream = new ANTLRInputStream(input);
            BellechatLexer lexer = new BellechatLexer(stream);
            CommonTokenStream ctr = new CommonTokenStream(lexer);
            BellechatParser parser = new BellechatParser(ctr);
            parser.setErrorHandler(new BailErrorStrategy());

            return Arrays.asList(itemVisitor.visitChat(parser.chat()));

        } catch (IOException ioex) {
            ioex.getCause();
        }
        catch (ParseCancellationException pcex) {
            throw pcex.getCause();
        }
        return null;
    }


    private BellechatBaseVisitor<ChatCommand[]> itemVisitor = new BellechatBaseVisitor<ChatCommand[]>() {

          @Override
          public ChatCommand[] visitChat(BellechatParser.ChatContext context) {
              ChatCommand[] commands = new ChatCommand[context.getChildCount()];
              for (int i = 0; i < context.getChildCount(); i++) {
                  commands[i] = commandVisitor.visitItem(context.getChild(BellechatParser.ItemContext.class, i));
              }
              return commands;
          }
    };

    private BellechatBaseVisitor<ChatCommand> commandVisitor = new BellechatBaseVisitor<ChatCommand>() {


        @Override
        public ChatCommand visitItem(BellechatParser.ItemContext context) {
            try {
                if (context.expr() != null) {
                    return generateExprCommand(context.expr());
                }
                return generateTextblockCommand(context.textblock());
            }
            catch (Exception ex) {
                //TODO fix this
            }
            return null;
        }

        private ChatCommand generateExprCommand(BellechatParser.ExprContext context) throws Exception {
            String verb = "none";
            String[] parms = new String[]{};

            if (context.nullary() != null) {
                verb = context.nullary().getChild(0).getText();
            }
            if (context.unary() != null) {
                verb = context.unary().getChild(0).getText();
                parms = new String[] {context.unary().parm().getText()};
            }
            if (context.binary() != null) {
                verb = context.binary().getChild(0).getText();
                parms = new String[] {context.binary().parm(0).getText(),
                        context.binary().parm(1).getText()};
            }
            if (context.ternary() != null) {
                verb = context.ternary().getChild(0).getText();
                parms = new String[] {context.ternary().parm(0).getText(),
                        context.binary().parm(1).getText(),
                        context.binary().parm(2).getText()};
            }
            for(int i=0;i<parms.length;i++) {
                parms[0] = parms[0].replaceAll("^\"|\"$", "");
            }
            return _generator.generate(verb.replace("\\",""),parms);
        }

        private ChatCommand generateTextblockCommand(final BellechatParser.TextblockContext context) throws Exception{
            String verb = "say";

            Iterator<String> phonemeIterator = new Iterator<String>() {
                int iter = 0;
                int count = context.getChildCount();
                @Override
                public String next() {
                   return context.getChild(BellechatParser.PhonemeContext.class,iter++).STRING().getText();
                }

                public boolean hasNext() {
                    return iter<count;
                }
            };

            String text = StringUtils.join(phonemeIterator, " ");

            return _generator.generate(verb, text);

        }
    };



}
