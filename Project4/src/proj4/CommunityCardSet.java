package proj4;

import java.util.*;

public class CommunityCardSet{

    private ArrayList<Card> communityCards = new ArrayList<Card>(5);

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
}