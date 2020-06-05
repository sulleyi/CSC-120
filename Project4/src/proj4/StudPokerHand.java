package proj4;
import java.util.*;


public class StudPokerHand{

    private ArrayList<Card> cardsInHand;
    private CommunityCardSet communityCards;



    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardArrayList){

        cardsInHand = cardArrayList;
        communityCards = cc;
    }

    public int compareTo(StudPokerHand other){

        PokerHand thisBestHand = this.getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();

        return thisBestHand.compareTo(otherBestHand);
    }

    public String toString{

    }

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

    private ArrayList<PokerHand> getAllFiveCardHands(){

        ArrayList<PokerHand> allHands = new ArrayList<PokerHand>();//keep track of all the hands
        ArrayList<Card> allCards = new ArrayList<Card>(cardsInHand); //keep track of all the cards in this hand (hole cards + community cards)

        for(int i = 0; i < communityCards.size(); i++){
            allCards.add(communityCards.get_ith_card(i));//add all the community cards to all cards
        }

        for(int i = 0; i < communityCards.size() + cardsInHand.size(); i++) { //these for loops just iterate through every index in the list removing a different combo of two cards
            for(int j = i +1; j < communityCards.size() + cardsInHand.size() -1; j ++) { //which generates all the unique 5 card hands

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
