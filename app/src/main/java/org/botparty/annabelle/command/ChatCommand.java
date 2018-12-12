package org.botparty.annabelle.command;

/**
 * Created by brandon on 2/20/2017.
 */

public interface ChatCommand {
   String getCommand();
   String[] getParameterList();

   void execute(String... parameters);
}
