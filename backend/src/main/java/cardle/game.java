import java.util.Scanner;
public class Game{
    public static void main (String[] args){
        CardList cardList = new CardList();
        cardList.loadCards();

        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter player name: ");

        // Create a new player with the entered name
        String playerName = scnr.nextLine();
        Player player = new Player(playerName);

        // Create starter deck
        Deck starterDeck = new Deck();
        for(int i = 0; i < 5; i++){
            Card card = cardList.getRandomCard(i);
            starterDeck.addCard(card);
        }



    }
    
}