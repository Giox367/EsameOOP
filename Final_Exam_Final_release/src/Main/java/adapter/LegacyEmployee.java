package adapter;


// Classe legacy da adattare
public class LegacyEmployee {
    private String legacyName;
    private String legacyPosition;

    public LegacyEmployee(String name, String position) {
        this.legacyName = name;
        this.legacyPosition = position;
    }

    public String getLegacyName() {
        return legacyName;
    }

    public String getLegacyPosition() {
        return legacyPosition;
    }
}
