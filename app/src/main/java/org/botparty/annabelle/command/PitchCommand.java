package org.botparty.annabelle.command;

import org.botparty.annabelle.api.SpeechController;

import javax.inject.Inject;

/**
 * Created by brandon on 2/20/2017.
 */

@Command(commandText="pitch",parameterList="pitch:float")
public class PitchCommand extends ChatCommandBase {

    private SpeechController _controller;

    @Inject
    public PitchCommand(SpeechController controller) {
        _controller = controller;
    }

    public void execute(String... parameters) {
        try {
            float pitch = Float.parseFloat(parameters[0]);
            _controller.setPitch(pitch);
        }
        catch (Exception e){}
    }
}
