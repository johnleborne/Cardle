import java.util.*;

// TESTING 

public class CardList{
    Random rand = new Random();
    ArrayList<Card>
    try (BufferedReader br = new BufferedReader(new FileReader("Cards.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
}