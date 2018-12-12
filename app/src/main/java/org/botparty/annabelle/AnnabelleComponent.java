package org.botparty.annabelle;

import org.botparty.annabelle.command.CommandLookup;
import org.botparty.annabelle.command.CommandReference;
import org.botparty.annabelle.command.FaceCommand;
import org.botparty.annabelle.command.PauseCommand;
import org.botparty.annabelle.command.PitchCommand;
import org.botparty.annabelle.command.SayCommand;
import org.botparty.annabelle.command.ViewCommand;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by brandon on 2/26/2017.
 */

@Singleton
@Component(modules={AppModule.class, AnnabelleModule.class})
public interface AnnabelleComponent {
  //  FullscreenActivity oontext();
    void inject(FullscreenActivity activity);
    void inject(CommandReference reference);
    void inject(CommandLookup lookup);
    void inject(FaceCommand face);
    void inject(ViewCommand face);
    void inject(PauseCommand pause);
    void inject(PitchCommand pitch);
    void inject(SayCommand say);
}


