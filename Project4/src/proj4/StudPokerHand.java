package proj4;
import java.util.*;


public class StudPokerHand{

    private ArrayList<Card> cardsInHand;
    private ArrayList<Card> communityCards = new ArrayList<Card>();



    public StudPokerHand(CommunityCardSet cc, ArrayList<Card> cardArrayList){

        cardsInHand = cardArrayList;
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
        ArrayList<Card> allCards = new ArrayList<Card>(cardsInHand);
        allCards.addAll(communityCards);

        for(int i = 0; i < communityCards.size() + cardsInHand.size(); i++) {
            for(int j = i +1; j < communityCards.size() + cardsInHand.size(); j ++) {

                ArrayList<Card> cloneAllCards = (ArrayList<Card>) allCards.clone();
                cloneAllCards.remove(i);
                cloneAllCards.remove(j);

                PokerHand currentHand = new PokerHand(cloneAllCards);
                allHands.add(currentHand);
            }
        }
        return allHands;
    }


    public int compareTo(StudPokerHand other){
        PokerHand thisBestHand = this.getBestFiveCardHand();
        PokerHand otherBestHand = other.getBestFiveCardHand();

        return thisBestHand.compareTo(otherBestHand);
    }
}

//I probably should have read the entire assignment and seen the psuedo-code before I tried to write this recursively
  /*  private void getAllFiveCardHandsR(ArrayList<Card> communityCards, PokerHand currentHand, int start) {

          for (int i=start; i < communityCards.size() - cardsInHand.size(); i++)
                  {
                      currentHand.addCard(communityCards.get(i);
                      getAllFiveCardHandsR(communityCards, currentHand, i+1);
                  }

          allHands.add(currentHand);
    }*/