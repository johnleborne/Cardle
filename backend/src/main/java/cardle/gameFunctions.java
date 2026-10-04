public class gameFunctions {
    public static void selectCards (ArrayList<Card> deck, Scanner scnr) {
        Card[] finalHand = new Card[deck.size()];
        
        System.out.println("Select a card to play: ");
        int selectedCard = scnr.nextInt();
        selectedCard -= 1;
        if (selectedCard < 1 || selectedCard > deck.size()) {
            System.out.println("Invalid selection. Please select a card between 1 and " + deck.size());
            selectCards(deck, scnr);
        } else {
            Card cardToPlay = deck.get(selectedCard - 1);
            card
            System.out.println("You selected: " + cardToPlay.getName());
        }

    }
}