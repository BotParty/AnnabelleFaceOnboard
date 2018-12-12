package org.botparty.annabelle.api;

/**
 * Created by brandon on 2/12/2017.
 */

public interface ConnectionController {


    void connect();
    void reconnect();
    void reconnect(String host, int port);
}
