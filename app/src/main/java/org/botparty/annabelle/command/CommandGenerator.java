package org.botparty.annabelle.command;


import javax.inject.Inject;


/**
 * Created by brandon on 2/20/2017.
 */


public class CommandGenerator {

    private final CommandReference _lookup;

   // public CommandGenerator () {_lookup = new CommandLookup();}

    @Inject
    public CommandGenerator (CommandReference lookup) {
        _lookup = lookup;
    }
    public  ChatCommand generate(String verb, String... parameters) throws Exception {


        ChatCommand commandToRun = ((CommandLookup) _lookup).getCommandObject(verb.toLowerCase());
        return new CommandInvoker(commandToRun, parameters);
      //    Class cmdClass =  _lookup.getCommand(verb.toLowerCase());
       // if (cmdClass == null) throw new Exception("Unknown command");
       // Constructor<?> ctor = cmdClass.getConstructor();

        //return (ChatCommand) ctor.newInstance((Object[]) parameters);
    }
}

