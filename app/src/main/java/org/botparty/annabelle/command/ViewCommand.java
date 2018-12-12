package org.botparty.annabelle.command;

import org.botparty.annabelle.api.ViewController;

import javax.inject.Inject;

/**
 * Created by brandon on 3/5/2017.
 */

@Command(commandText="view", parameterList="faceType:String")
public class ViewCommand extends ChatCommandBase {
    private ViewController _controller;
    @Inject
    public ViewCommand(ViewController controller) {
        _controller = controller;
    }

    @Override
    public void execute(String... parameters) {
        _controller.setUri(parameters[0]);
    }
}
