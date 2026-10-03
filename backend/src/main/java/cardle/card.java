public class Card {
    private String name;
    private String description;
    private int value;
    private int rarity;

    public Card(String name, String description,  int value, int rarity) {
        this.name = name;
        this.description = description;
        this.value = value;
        this.rarity = rarity;
    }
    public Card(String name, int value, int rarity) {
        this.name = name;
        this.description = "";
        this.value = value;
        this.rarity = rarity;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }


    
}