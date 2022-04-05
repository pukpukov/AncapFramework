package AncapLibrary.Commands;

import AncapLibrary.Library.AncapLibrary;
import AncapLibrary.Player.AncapPlayer;

public interface PreCommand {

    Command getPreparedCommand();

    String[] getArgs();

    AncapPlayer getSender();

    default void validateArgsCount(int accepted) throws AncapCommandException {
        int argsLength = this.getArgs().length;
        if (argsLength < accepted) {
            throw new AncapCommandException(this.getSender(), AncapLibrary.getConfiguration().getInvalidArgsCountMessage(argsLength, accepted));
        }
    }
}
