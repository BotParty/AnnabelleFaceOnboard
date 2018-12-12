package org.botparty.annabelle.command;

/**
 * Created by brandon on 2/21/2017.
 */
public interface CommandReference {
    Class getCommand(String cmd);
}
