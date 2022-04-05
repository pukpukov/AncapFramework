package AncapLibrary.Commands;

import AncapLibrary.Name.AncapCommandName;

public class AncapCommandType implements CommandType {

    private AncapCommandName name;
    private CommandExecutor executor;

    public AncapCommandType(AncapCommandName name, CommandExecutor executor) {
        this.name = name;
        this.executor = executor;
    }
}
