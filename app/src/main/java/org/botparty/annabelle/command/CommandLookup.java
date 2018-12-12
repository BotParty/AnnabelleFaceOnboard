package org.botparty.annabelle.command;

import org.apache.commons.lang3.NotImplementedException;

import java.util.HashMap;

import javax.inject.Inject;

/**
 * Created by brandon on 2/20/2017.
 */


public class CommandLookup implements CommandReference {

 //  private HashMap<String,Class> lookup = new HashMap<>();

    private HashMap<String,ChatCommand> lookup = new HashMap<>();
    // TODO THIS IS TEMPORARY UNTIL I UNDERSTAND DAGGER ENOUGH TO IMPLEMENT A FACTORY
    // Reflections DOES NOT WORK with android, god I hate java. Other option is to use
    // annotation processors, but for now just registering types.
    @Inject
    public CommandLookup(
            FaceCommand face,
            PauseCommand pause,
            PitchCommand pitch,
            SayCommand say,
            RateCommand rate,
            ViewCommand view,
            EyeCommand eye
    ) {
        lookup.put("face", face);
        lookup.put("pause", pause);
        lookup.put("pitch", pitch);
        lookup.put("say", say);
        lookup.put("rate", rate);
        lookup.put("view", view);
        lookup.put("eye", eye);

    }

    public Class getCommand(String key) {
        throw new NotImplementedException("not working");
    }

    public ChatCommand getCommandObject(String key) {
        return lookup.get(key);
    }
/*
      //  Reflections reflections = new Reflections("com.org.org.org.botparty.org.org.botparty.annabelle.command");
         //for (Class clazz : reflections.getTypesAnnotatedWith(Command.class)) {
        for (Class clazz : getCommands()) {
            String commandName = "";
            Command annotation = ChatCommandBase.getCommandAnnotation(clazz);
            if (annotation != null) {
                commandName = annotation.commandText();
            } else {
                commandName = ChatCommandBase.getConventionalCommandName(clazz);
            }
            lookup.put(commandName,clazz);
        }



    //for the moment, new commands need to be registered here
    private static Class[] getCommands() {
        return new Class[]{
                FaceCommand.class,
                PauseCommand.class,
                SayCommand.class,
                PitchCommand.class
        };
    }

    @Override
    public Class getCommand(String cmd) {
        if (lookup.containsKey(cmd)) return lookup.get(cmd);
        return null;
    }
*/


}