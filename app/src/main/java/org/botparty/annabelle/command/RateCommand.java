package org.botparty.annabelle.command;

import org.botparty.annabelle.api.SpeechController;

import javax.inject.Inject;

@Command(commandText="rate",parameterList="rate:float")
public class RateCommand extends ChatCommandBase {

    private SpeechController _controller;

    @Inject
    public RateCommand(SpeechController controller) {
        _controller = controller;
    }

    public void execute(String... parameters) {
        try {
            float pitch = Float.parseFloat(parameters[0]);
            _controller.setSpeechRate(pitch);
        }
        catch (Exception e){}
    }
}
