package proj3; // do not erase. Gradescope expects this.

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class for modeling a Deck of Cards
 */
public class Deck {

    private int DECK_SIZE =52;//standard deck size
    private ArrayList<Card> cardList = new ArrayList<Card>(DECK_SIZE); //Arraylist of cards
    private int nextToDeal = 0;//intialized variable of index we are drawing next card from

    /**
     * Constructor for a Deck object
     */
    public Deck() {
        generateDeck();//generates the deck
    }

    /**
     * Generates a standard 52 card deck
     * ranks: 2 to 14
     * suits: Hearts, Diamonds, Spades, Clubs
     */
    private void generateDeck(){
        for(int i=0; i<4; i++){
            for(int j=2; j<=14; j++) {
                Card card = null;
                if(i == 0){
                    card = new Card(j, "Hearts");
                }
                if(i == 1){
                    card = new Card(j,"Diamonds");
                }
                if(i == 2){
                    card = new Card(j, "Clubs");
                }
                if(i == 3){
                    card = new Card(j, "Spades");
                }
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

}
