package cardle;

import java.util.ArrayList;
import java.util.Scanner;
public class Game{
    public static void main (String[] args){
        CardList cardList = new CardList();
        System.out.println(System.getProperty("user.dir"));
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
        



    }
    
}