import java.util.*;


public class StudPokerHand{

    private ArrayList<Card> cardsInHand = new ArrayList<Card>();
    ArrayList<Card> comunityCards = new ArrayList<Card>();

    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardArrayList){
        cardsInHand.addAll(cardArrayList);
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
        ArrayList<PokerHand> allHands = new ArrayList<PokerHand>();
        for(j = 0; j < comunityCards.size(); j++ ){
            PokerHand currentHand = new PokerHand(cardsInHand);
        }
        return allHands;
    }
}