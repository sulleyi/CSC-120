package proj4;

import java.util.*;

public class CommunityCardSet{

    private ArrayList<Card> communityCards = new ArrayList<Card>(5);
    private final int MAX_CC_SIZE = 5;
    public CommunityCardSet(ArrayList<Card> cardList){
        communityCards.addAll(cardList);
    }


    /**
     * return the card in the pokerHand at the given index
     *
     * @param index index of card being retrieved
     * @return Card
     */
    public Card get_ith_card(int index) {
        if (index >= 0 && index < communityCards.size()) {
            return communityCards.get(index);
        } else {
            return null;
        }
    }

    public int size(){
        return communityCards.size();
    }

    /**
     * add a card to the Poker Hand if there are less than 5 cards in the hand
     * otherwise do nothing
     *
     * @param card card being added to the PokerHand
     */
    public void addCard(Card card) {

        if (communityCards.size() < MAX_CC_SIZE) {
            communityCards.add(card);
        }
    }

    public @Override String toString(){
        String str = "";
        for (int i = 0; i < communityCards.size(); i++) {
            str += communityCards.get(i).toString();
            str += "\n";
        }
        return str;
    }
}