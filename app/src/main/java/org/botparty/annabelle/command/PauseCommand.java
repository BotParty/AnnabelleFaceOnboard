package org.botparty.annabelle.command;

/**
 * Created by brandon on 2/25/2017.
 */

@Command(commandText="pause",parameterList={"timeMs:int"})
public class PauseCommand extends ChatCommandBase {

    public void execute(String... parameters) {
        try {
            int time = Integer.parseInt(parameters[0]);
            //putting this in to prevent oopsies
            if (time < 20000) {
                Thread.sleep(time);
            }
        }
        catch (Exception e){}
    }
}
