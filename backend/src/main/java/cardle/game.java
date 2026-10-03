import java.util.Scanner;
public class Game{
    public static void main (String[] args){
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter player name: ");

        // Create a new player with the entered name
        String playerName = scnr.nextLine();
        Player player1 = new Player(playerName);

        // Create starter deck
        Deck starterDeck = new Deck();
        starterDeck.addCard(



    }
    
}