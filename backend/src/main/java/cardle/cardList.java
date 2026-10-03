import java.util.*;
public class CardList{
    Random rand = new Random();

    ArrayList<Card> allCardsList = new ArrayList<>();

    public static void loadCards(){
        try (BufferedReader br = new BufferedReader(new FileReader("/assets/Cards.csv"))) {
            String line;
            while (line = br.readLine()) != null {
                System.out.println(line);
                String[] readingArray = line.split(",");
                Card newCard = new Card(readingArray[0], readingArray[1], Integer.parseInt(readingArray[2]), Integer.parseInt(readingArray[3]));
                allCardsList.add(newCard);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}