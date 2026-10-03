package cardle;

public class Player {
    private String name;
    private int score;
    private int luck;

    public Player(String name) {
        this.name = name;
        this.score = 0;
        this.luck = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
    public int getLuck() {
        return luck;
    }
    public void setLuck(int luck) {
        this.luck = luck;
    }
}