package org.botparty.annabelle.command;

import org.botparty.annabelle.api.SpeechController;

import javax.inject.Inject;

/**
 * Created by brandon on 2/20/2017.
 */

@Command(commandText = "say",parameterList={"text:String"})
public class SayCommand extends ChatCommandBase {

    private SpeechController _controller;

    @Inject
    public SayCommand(SpeechController controller) {
        _controller = controller;
    }

    @Override
    public void execute(String... parameters) {
        _controller.speak(parameters[0]);
    }
}
