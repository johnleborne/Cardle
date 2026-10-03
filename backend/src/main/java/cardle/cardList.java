import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CardList{
    Random rand = new Random();

    static ArrayList<Card> allCardsList = new ArrayList<>();

    public static void loadCards(){
        try (BufferedReader br = new BufferedReader(new FileReader("resources/Cards.csv"))) {
            String line;
            line = br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                String[] readingArray = line.split(",");
                Card newCard = new Card(readingArray[0], readingArray[1], Integer.parseInt(readingArray[2]), Integer.parseInt(readingArray[3]));
                allCardsList.add(newCard);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }

    /*
    public static Card getRandomCard(){
        int randomInt = rand.nextInt(allCardsList.size());
        return allCardsList.
    }
    */

    public Card getRandomCard(ArrayList<Card> cards) {
    Random random = new Random();

    int totalWeight = 0;

    for (Card card : cards) {
        totalWeight += card.getWeight();
    }

    int randomNumber = random.nextInt(totalWeight);

    for (Card card : cards) {
        randomNumber -= card.getWeight();

        if (randomNumber < 0) {
            return card;
        }
    }

    return null;
    }
}