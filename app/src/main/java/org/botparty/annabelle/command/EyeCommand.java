package org.botparty.annabelle.command;

import org.botparty.annabelle.api.ViewController;

import javax.inject.Inject;

/**
 * Created by brandon on 3/8/2017.
 */
@Command(commandText="eye", parameterList="faceType:String")
public class EyeCommand extends ChatCommandBase {
    private ViewController _controller;
    @Inject
    public EyeCommand(ViewController controller) {
        _controller = controller;
    }

    @Override
    public void execute(String... parameters) {
        _controller.setEyeState(parameters[0].toUpperCase());
    }
}