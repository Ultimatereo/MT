package lexic.token;

public class KeyWord extends Token {
    public KeyWord(String value) {
        super(value.toUpperCase(), value);
    }
}
