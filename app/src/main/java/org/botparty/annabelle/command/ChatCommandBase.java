package org.botparty.annabelle.command;
import java.security.InvalidParameterException;

/**
 * Created by brandon on 2/20/2017.
 */

public abstract class ChatCommandBase implements ChatCommand {

    public final String getCommand() {

        Command anno = getCommandAnnotation(this.getClass());
        if (anno != null) {
            return anno.commandText();
        }

        return getConventionalCommandName(this.getClass());
    }

    public final String[] getParameterList() {
        Command anno = getCommandAnnotation(this.getClass());
        if (anno != null) {
            return anno.parameterList();
        }

        return new String[]{};
    }


    public static String getConventionalCommandName(Class type) {
        return type
                   .getSimpleName()
                   .toLowerCase()
                   .replace("command","");
    }
    public abstract void execute(String... parameters);

    public static Command getCommandAnnotation(Class type) {
        if (!ChatCommand.class.isAssignableFrom(type)) {
            throw new InvalidParameterException("Only types that inherit from ChatCommand can have associated Command info");
        }
        if (type.isAnnotationPresent(Command.class)) {
            return (Command) type.getAnnotation(Command.class);
        }

        return null;
    }
}
