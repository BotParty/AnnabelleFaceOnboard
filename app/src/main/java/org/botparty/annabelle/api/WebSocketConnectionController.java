package org.botparty.annabelle.api;


/**
 * Created by brandon on 2/12/2017.
 */

public class WebSocketConnectionController implements ConnectionController {
    String _host;
    int _port;

    public WebSocketConnectionController(String host, int port) {
        _host = host;
        _port = port;
    }


    @Override
    public void connect() {

    }

    @Override
    public void reconnect() {

    }

    @Override
    public void reconnect(String host, int port) {

    }
}
