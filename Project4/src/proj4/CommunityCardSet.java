package proj4;

import java.util.*;

public class CommunityCardSet{

    private ArrayList<Card> communityCards = new ArrayList<Card>(5);

    public CommunityCardSet(ArrayList<Card> cardList){
        communityCards.addAll(cardList);
    }
}