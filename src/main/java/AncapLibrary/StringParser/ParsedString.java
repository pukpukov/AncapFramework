package AncapLibrary.StringParser;

import java.util.HashMap;
import java.util.Set;

public class ParsedString {

    HashMap<String, String> parsedString;

    public ParsedString(HashMap<String, String> parsedString) {
        this.parsedString = parsedString;
    }

    public Set<String> getKeys() {
        return this.parsedString.keySet();
    }

    public String getValue(String key) {
        return parsedString.get(key);
    }
}
