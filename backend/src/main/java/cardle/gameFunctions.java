package cardle;

import java.util.ArrayList;
import java.util.Scanner;

public class gameFunctions {
    // prompts user and returns a hand to play
    public static ArrayList<Card> selectCards (ArrayList<Card> deck, Scanner scnr) {
        ArrayList<Card> finalHand = new ArrayList<Card>();
        boolean isChoosing = true;

        while (isChoosing){
            System.out.println("Select a card to play: ");
            int selectedCard = scnr.nextInt();
            selectedCard -= 1;
            if (selectedCard < 1 || selectedCard > deck.size()) {
                System.out.println("Invalid selection. Please select a card between 1 and " + deck.size());
                selectCards(deck, scnr);
            }
            else {
                Card cardToPlay = deck.get(selectedCard - 1);
                finalHand.add(cardToPlay);
                System.out.println("You selected: " + cardToPlay.getName());
                System.out.println("Would you like to select another card? (y/n)");
                String response = scnr.next();
                if (response.equalsIgnoreCase("n")) {
                    isChoosing = false;
                }
                else{
                    isChoosing = true;
                }
            }
        }
        return finalHand;

    }

    public static double calculateScore(ArrayList<Card> hand) {
    double score = 0.0;
    for (Card card : hand) {
        score += card.getValue();
    }
    return score;
}
}