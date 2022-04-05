package AncapLibrary.Name;

import javax.naming.InvalidNameException;

public interface CommandNameValidable {

    String getString();

    default void validate() throws InvalidNameException {
        if (this.getString().length() <= 2 || !this.getString().matches("[a-zA-Z0-9а-яА-Я-_]+")) {
            throw new InvalidNameException();
        }
    }
}
