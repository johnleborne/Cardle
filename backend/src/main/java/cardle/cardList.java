package cardle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

public class CardList{
    Random rand = new Random();

    static ArrayList<Card> allCardsList = new ArrayList<>();

    public static void loadCards(){
        InputStream input = CardList.class
        .getClassLoader()
        .getResourceAsStream("Cards.csv");
        
        if (input == null) {
            System.err.println("Could not find Cards.csv");
            return;
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(input))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
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

    public static Card getRandomCard(ArrayList<Card> cards) {
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