package cardle;

import java.util.ArrayList;
import java.util.Scanner;
public class Game{
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
        System.out.println("Score to beat: " + scoreToBeat);

        System.out.println("Select how many cards you want to play from your starter deck: ");
        int numCardsToPlay = scnr.nextInt();
        if(numCardsToPlay <= 0 || numCardsToPlay > starterDeck.size()){
            System.out.println("Invalid number of cards selected.");
            return;
        }
        double totalScore = 0;
        for(int i = 0; i < numCardsToPlay; i++){
            
            System.out.println("Which card do you want to play? (1-5): ");
            int cardIndex = scnr.nextInt() - 1;
            if(starterDeck.get(cardIndex) != null){
                Card playedCard = starterDeck.get(cardIndex);
                System.out.println("You played: " + playedCard.getName());

                if("-".equals(playedCard.getDescription())){
                    totalScore += playedCard.getValue();
                }
                else switch (playedCard.getDescription()) {
                    case "ace":
                        totalScore += 1;
                        totalScore *= 1.6;
                        break;
                    case "king":
                        totalScore += 13;
                        totalScore *= 1.2;
                        break;
                    case "queen":
                        totalScore += 12;
                        totalScore *= 1.1;
                        break;
                    case "jack":
                        totalScore += 11;
                        totalScore *= 1.05;
                        break;
                    default:
                        totalScore += playedCard.getValue();
                        break;
                }
                System.out.println("Total score so far: " + totalScore);
            } else {
                System.out.println("Invalid card selected.");
            }
            
        }
        scoreToBeat -= totalScore;
            if(scoreToBeat <= 0){
                System.out.println("You have beaten the score!");
                return;
            }
            else{
                System.out.println("You lose! Score to beat remaining: " + scoreToBeat);
            }
    }
    
}