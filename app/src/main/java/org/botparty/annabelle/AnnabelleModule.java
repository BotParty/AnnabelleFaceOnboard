package org.botparty.annabelle;

/**
 * Created by brandon on 2/25/2017.
 */

import android.content.Context;

import org.botparty.annabelle.api.SpeechController;
import org.botparty.annabelle.api.SpeechControllerImpl;
import org.botparty.annabelle.api.ViewController;
import org.botparty.annabelle.api.ViewControllerImpl;
import org.botparty.annabelle.command.CommandLookup;
import org.botparty.annabelle.command.CommandReference;
import org.botparty.annabelle.command.EyeCommand;
import org.botparty.annabelle.command.FaceCommand;
import org.botparty.annabelle.command.PauseCommand;
import org.botparty.annabelle.command.PitchCommand;
import org.botparty.annabelle.command.RateCommand;
import org.botparty.annabelle.command.SayCommand;
import org.botparty.annabelle.command.ViewCommand;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AnnabelleModule {

    FullscreenActivity _context;

    public AnnabelleModule(FullscreenActivity context) {
        _context = context;
    }

    @Provides @Singleton
    FullscreenActivity provideFullScreenActivity() {
        return _context;
    }

    @Provides @Singleton
    Context provideContext() {
        return _context;
    }

    @Provides
    @Singleton
    public ViewController providesViewController() {
        return new ViewControllerImpl(_context);
    }

    @Provides
    @Singleton
    public SpeechController providesSpeechController(ViewController view) {
        return new SpeechControllerImpl(_context,view);
    }

    @Provides
    @Singleton
    public CommandReference providesCommandReference(CommandLookup lookup) {
        return lookup;
    }


    //TODO FIGURE OUT DAGGER  + FACTORIES
    @Provides
    @Singleton
    public CommandLookup providesCommandLookup(FaceCommand face,  PitchCommand pitch, SayCommand say, PauseCommand pause, RateCommand rate, ViewCommand view, EyeCommand eye) {
        return new CommandLookup(face,pause,pitch,say,rate,view,eye);
    }

    @Provides
    public EyeCommand providesEyeCommand(ViewController vc) {
        return new EyeCommand(vc);
    }
    @Provides
    public FaceCommand providesFaceCommand(ViewController vc) {
        return new FaceCommand(vc);
    }
    @Provides
    public ViewCommand providesViewCommand(ViewController vc) {
        return new ViewCommand(vc);
    }
    @Provides
    public SayCommand providesSayCommand(SpeechController sc) {
        return new SayCommand(sc);
    }
    @Provides
    public PauseCommand providesPauseCommand() {
        return new PauseCommand();
    }
    @Provides
    public PitchCommand providesPitchCommand(SpeechController sc) {
        return new PitchCommand(sc);
    }
    @Provides
    public RateCommand providesRateCommand(SpeechController sc) {
        return new RateCommand(sc);
    }



}

