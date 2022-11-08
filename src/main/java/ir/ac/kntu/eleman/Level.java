package ir.ac.kntu.eleman;

public enum Level {
    EASY("EASY"),
    MEDIUM("MEDIUM"),
    HARD("HARD");

    private String level;

    Level(String level) {
        this.level = level;
    }

    public String getLevel() {
        return level;
    }
}
