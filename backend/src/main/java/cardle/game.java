package cardle;

import java.util.ArrayList;
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
        ArrayList<Card> starterDeck = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Card card = cardList.getRandomCard(cardList.allCardsList);
            starterDeck.add(card);
        }

        // Display the player's name and starter deck
        System.out.println("Player Name: " + player.getName());
        System.out.println("Starter Deck:");
        for (Card card : starterDeck) {
            System.out.println("Card Name: " + card.getName() + ", Description: " + card.getDescription() + ", Value: " + card.getValue() + ", Weight: " + card.getWeight());
        }
        



    }
    
}