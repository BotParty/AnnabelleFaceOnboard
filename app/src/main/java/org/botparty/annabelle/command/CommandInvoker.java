package org.botparty.annabelle.command;


/**
 * Created by brandon on 2/26/2017.
 */

public class CommandInvoker extends ChatCommandBase {

    private ChatCommand commandToExecute;
    private String[] params;
    public CommandInvoker(ChatCommand wrapped, String... params) {
        commandToExecute = wrapped;
        this.params = params;

    }

    @Override
    //passed parameters override if present...
    public void execute(String... parameters) {
        String[] actualParams = params;
        if (parameters.length != 0) {
            params = actualParams;
        }
        commandToExecute.execute(actualParams);
    }
}
