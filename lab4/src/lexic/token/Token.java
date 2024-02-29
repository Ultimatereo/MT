package lexic.token;

public class Token {
    private final String name;
    private final String value;

    public Token(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String name() {
        return name;
    }

    public String value() {
        return value;
    }
}
