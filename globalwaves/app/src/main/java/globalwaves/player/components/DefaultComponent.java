package globalwaves.player.components;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import globalwaves.fileio.input.command.CommandInput;
import globalwaves.fileio.output.command.CommandOutput;
import globalwaves.player.user.UserData;
import globalwaves.player.user.UserState;
import globalwaves.utils.Constants;

public class DefaultComponent {
    protected Map<String, UserData> usersData;

    public DefaultComponent(Map<String, UserData> usersData) {
        this.usersData = usersData;
    }

    private void updatePlayer(CommandInput command) {
        if (!usersData.containsKey(command.getUsername())) {
            return;
        }

        UserData currentUserData = usersData.get(command.getUsername());
        UserState currentUserState = currentUserData.getState();

        if (currentUserState.equals(UserState.AUDIOFILE_LOADED)) {
            usersData.get(command.getUsername()).getNowPlaying().update(command.getTimestamp());
        }
    }

    public CommandOutput run(CommandInput command) {
        if (Constants.DEBUG) {
            System.out.println(command);
            System.out.println(command.getClass().getSimpleName());
        }

        updatePlayer(command);

        try {
            Method visitMethod = this.getClass().getDeclaredMethod("visit", command.getClass());

            return (CommandOutput) visitMethod.invoke(this, command);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new IllegalArgumentException("No visit method found for the type of command");
        }
    }
}
