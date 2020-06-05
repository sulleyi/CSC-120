package proj4;
import java.util.*;


public class StudPokerHand{

    private static final int MAX_HAND_SIZE = 2;
    private ArrayList<Card> cardsInHand;
    private CommunityCardSet communityCards;


    /**
     * Constructor for a StudPokerHand
     * @param cc communityCard set for this hand
     * @param cardArrayList the cards in this hand
     */
    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardArrayList){

        cardsInHand = cardArrayList;
        communityCards = cc;
    }

    /**
     * return the card in the StudPokerHand at the given index
     *
     * @param index index of card being retrieved
     * @return Card
     */
    public Card get_ith_card(int index) {
        if (index >= 0 && index < cardsInHand.size()) {
            return cardsInHand.get(index);
        } else {
            return null;
        }
    }

    /**
     * add a card to the StudPokerHand if there are less than 2 cards in the hand
     * otherwise do nothing
     *
     * @param card card being added to the PokerHand
     */
    public void addCard(Card card) {

        if (cardsInHand.size() < MAX_HAND_SIZE) {
            cardsInHand.add(card);
        }
    }


    /**
     * Determines how this hand compares to another hand, using the
     * community card set to determine the best 5-card hand it can * make. Returns positive, negative, or zero depending on the comparison.
     * @param other The hand to compare this hand to
     * * @return a negative number if this is worth LESS than other, zero
     * * if they are worth the SAME, and a positive number if this is worth * MORE than other
     * */
    public int compareTo(StudPokerHand other){

        PokerHand thisBestHand = this.getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();

        return thisBestHand.compareTo(otherBestHand);
    }


    /**
     * override the toString function to turn a PokerHand into a properly formatted string
     * @return String
     */
    public @Override String toString(){
        String studString = "The Community Cards are: ";
        studString += communityCards.toString();
        studString += "\n The Hole Cards are: ";

        for (Card myCard:cardsInHand) {
            studString += myCard.toString();
            studString += " ";
        }

        return studString;
    }

    /**
     * determines the best possible 5 card hand from all possible 5 card hands
     * @return PokerHand of highest evaluation
     */
    private PokerHand getBestFiveCardHand() {
        ArrayList<PokerHand> hands = getAllFiveCardHands();
        PokerHand bestSoFar = hands.get(0);
        for (int i = 1; i < hands.size(); i++) {
            if (hands.get(i).compareTo(bestSoFar) > 0) {
                bestSoFar = hands.get(i);
            }
        }
        return bestSoFar;
    }

    /**
     * generates all possible five card hadns from the community cards and the hole cards
     * @return ArrayList of PokerHands
     */
    private ArrayList<PokerHand> getAllFiveCardHands(){

        ArrayList<PokerHand> allHands = new ArrayList<PokerHand>();//keep track of all the hands
        ArrayList<Card> allCards = new ArrayList<Card>(cardsInHand); //keep track of all the cards in this hand (hole cards + community cards)

        for(int i = 0; i < communityCards.size(); i++){
            allCards.add(communityCards.get_ith_card(i));//add all the community cards to all cards
        }

        for(int i = 0; i < communityCards.size() + cardsInHand.size(); i++) { //these for loops just iterate through every index in the list removing a different combo of two cards
            for(int j = i +1; j < communityCards.size() + cardsInHand.size()  - 1; j ++) { //which generates all the unique 5 card hands

                ArrayList<Card> cloneAllCards = new ArrayList<Card>(allCards); // make a copy of allCards to remove from
                cloneAllCards.remove(i); //remove 1 card
                cloneAllCards.remove(j); //remove another

                PokerHand currentHand = new PokerHand(cloneAllCards); //make a hand with the remaining cards
                allHands.add(currentHand); //add the new hand to the list of hands
            }
        }
        return allHands;
    }
}
