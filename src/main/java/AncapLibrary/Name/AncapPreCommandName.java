package AncapLibrary.Name;

import javax.naming.InvalidNameException;

public class AncapPreCommandName extends AncapPreName implements CommandNameValidable {

    public AncapPreCommandName(String string) {
        super(string);
    }

    public Name getPreparedName() throws InvalidNameException {
        this.validate();
        return new AncapCommandName(this.getString());
    }
}
