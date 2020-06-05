package proj4; // do not erase. Gradescope expects this.


import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for modeling a Deck of Cards
 */
public class Deck {

    private final int DECK_SIZE = 52;//standard deck size
    private ArrayList<Card> cardList;//Arraylist of cards
    private int nextToDeal;//index we are drawing next card from

    /**
     * Constructor for a Deck object
     */
    public Deck() {

        nextToDeal = 0;
        cardList = new ArrayList<Card>(DECK_SIZE);

        generateDeck();//generates the deck
    }

    /**
     * Generates a standard 52 card deck
     * ranks: 2 to 14
     * suits: Hearts, Diamonds, Spades, Clubs
     */
    private void generateDeck(){


        Map<Integer, String> suitMap = new HashMap<>();
        suitMap.put(0, "Spades");
        suitMap.put(1, "Hearts");
        suitMap.put(2, "Clubs");
        suitMap.put(3, "Diamonds");

        int[] ranks = new int[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14};

        for(Integer key: suitMap.keySet()){
            for(int j : ranks) {
                Card card = new Card(j, key);
                cardList.add(card);
            }
        }
    }


    /**
     * shuffles the deck of cards
     */
    public void shuffle(){

        for(int i = nextToDeal; i < cardList.size(); i++){

            Card currentCard = cardList.get(i);

            int random = ThreadLocalRandom.current().nextInt(i, cardList.size());

            Card swapCard = cardList.get(random);

            cardList.set(i,swapCard);
            cardList.set(random, currentCard);
        }
    }


    /**
     * deals the next card in the deck
     * effiency: O(1)
     * @return previously undelt Card
     */
    public Card deal(){
        if(nextToDeal == this.size()){
            return null;
        }
        else {
            Card topCard = cardList.get(nextToDeal);
            nextToDeal++;
            return topCard;
        }

    }

    /**
     * return size of the deck; number of undelt cards
     * @return int value of number of cards
     */
    public int size(){
        int deckSize;
        deckSize = cardList.size() - nextToDeal;
        return deckSize;
    }

    /**
     * reset the next card to deal to the first in the deck
     */
    public void gather(){
        nextToDeal = 0;
    }

    /**
     * format the deck as a string for printing and such
     * @return String
     */
    public @Override String toString(){
        String str = "";
        for(int i = nextToDeal; i <cardList.size(); i++){
            str += cardList.get(i).toString();
            str += "\n";
        }
        return str;
    }

    /**
     * determines if there are cards left in the deck or not
     * @return boolean. True if no more cards, false otherwise
     */
    public boolean isEmpty(){
        if(nextToDeal == DECK_SIZE){
            return true;
        }
        else{
            return false;
        }
    }

}
