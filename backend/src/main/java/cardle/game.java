package cardle;

import java.util.ArrayList;
import java.util.Scanner;
public class game{
    public static void main (String[] args){
        CardList cardList = new CardList();
        CardList.loadCards();

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
        System.out.println(); // Add an empty line for better readability

        // Create house deck
        ArrayList<Card> houseDeck = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            Card card = cardList.getRandomCard(cardList.allCardsList);
            houseDeck.add(card);
        }
        
        // Display the house deck
        System.out.println("House Deck:");
        for (Card card : houseDeck) {
            System.out.println("Card Name: " + card.getName() + ", Description: " + card.getDescription() + ", Value: " + card.getValue() + ", Weight: " + card.getWeight());
        }
        System.out.println(); // Add an empty line for better readability
        System.out.println("Choose a card from the house deck to replace a card from your starter deck.");
        System.out.println("Enter the index of the house card you want to choose (1-5): ");
        int houseCardIndex = scnr.nextInt() - 1;

        System.out.println("Enter the index of the starter deck card you want to replace (1-5): ");
        int starterCardIndex = scnr.nextInt() - 1;

        //input validation
        if (houseCardIndex >= 0 && houseCardIndex < houseDeck.size() && starterCardIndex >= 0 && starterCardIndex < starterDeck.size()) {
            Card chosenHouseCard = houseDeck.get(houseCardIndex);
            starterDeck.set(starterCardIndex, chosenHouseCard);
        } else {
            System.out.println("Invalid indices entered.");
        }
        
        // Display the updated starter deck
        System.out.println("Updated Starter Deck:");
        for (Card card : starterDeck) {
            System.out.println("Card Name: " + card.getName() + ", Description: " + card.getDescription() + ", Value: " + card.getValue() + ", Weight: " + card.getWeight());
        }

        System.out.println(); // Add an empty line for better readability
        double scoreToBeat = 0;
        for(Card card : starterDeck){
            scoreToBeat += card.getValue();
        }
        
        boolean playerIsAlive = true;
        double totalScore = 0;

        // Game loop
        while (playerIsAlive){
            System.out.println("===============================");
            System.out.println("Score to beat: " + scoreToBeat);

            System.out.println("Select cards to play for this hand: ");
            starterDeck = gameFunctions.selectCards(starterDeck, scnr);
            
            if(scoreToBeat <= 0){
                    System.out.println("You have beaten the score!");
                }
            else{
                System.out.println("You lose! Score to beat remaining: " + scoreToBeat);
            }
        }
    }
    
}