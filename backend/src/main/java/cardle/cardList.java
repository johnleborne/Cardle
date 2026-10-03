import java.util.Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

    public class CardList{
    Random rand = new Random();
    ArrayList<Card> allCards = new ArrayList<>();

    public void loadCards() {
        try (BufferedReader br = new BufferedReader(new FileReader("/assets/Cards.csv"))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] arr = line.split(",");
                String name = arr[0];
                String description = arr[1];
                int value = Integer.parseInt(arr[2]);
                int rarity = Integer.parseInt(arr[3]);

                Card card = new Card(name, description, value, rarity);
                allCards.add(card);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
}