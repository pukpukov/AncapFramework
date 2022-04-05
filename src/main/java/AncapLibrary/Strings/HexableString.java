package AncapLibrary.Strings;

public class HexableString {

    private String string;

    public HexableString(String string) {
        this.string = string;
    }

    public boolean isHex() {
        try {
            Long.parseLong(this.string, 16);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

}
