package proj4; // do not erase. Gradescope expects this.

import java.util.HashMap;
import java.util.Map;

public class Card {


    private int cardRank;// Rank of the card
    private String cardSuit; //Suit of the card

    /**  * constructor
     * * @param rank integer between 2-14
     * * @param suit integer: 0=Spades, 1=Hearts, 2=Clubs, or 3=Diamonds
     * */
    public Card(int rank, int suit){

        Map<Integer, String> suitMap = new HashMap<>();
        suitMap.put(0, "Spades");
        suitMap.put(1, "Hearts");
        suitMap.put(2, "Clubs");
        suitMap.put(3, "Diamonds");

        if(suitMap.containsKey(suit)){
            cardSuit = suitMap.get(suit);
        }
        else{
            throw new IllegalArgumentException("suit must be represented with an int 0-3");
        }

    }
    /**  * constructor
     *
     * * @param rank String: whole cards (2-10) can either be spelled
     * * out like "two" or numeric like "2". Case insensitive.
     * * @param suit String: "Spades", "Hearts", "Clubs", or "Diamonds"
     * */
    public Card(String rank, String suit){

        Map<String, Integer> rankMap = new HashMap<>();
        rankMap.put("two", 2);
        rankMap.put("three", 3);
        rankMap.put("four", 4);
        rankMap.put("five", 5);
        rankMap.put("six", 6);
        rankMap.put("seven", 7);
        rankMap.put("eight", 8);
        rankMap.put("nine", 9);
        rankMap.put("ten", 10);
        rankMap.put("Two", 2);
        rankMap.put("Three", 3);
        rankMap.put("Four", 4);
        rankMap.put("Five", 5);
        rankMap.put("Six", 6);
        rankMap.put("Seven", 7);
        rankMap.put("Eight", 8);
        rankMap.put("Nine", 9);
        rankMap.put("Ten", 10);

        if(rankMap.containsKey(rank)){
            cardRank = rankMap.get(rank);
        }
        else{
            cardRank = Integer.parseInt(rank);
        }

        cardSuit = suit;
    }


    /**
     * getter for the rank of the card
     * @return int: rank
     */
    public int getCardRank(){
        return cardRank;
    }

    /**
     * Getter for the suit of the card
     *
     * @return String: suit
     */
    public String getCardSuit(){
        return cardSuit;
    }

    /**
     * format the Card as a string for printing and such
     *
     * @return String of the card
     */
    public @Override String toString(){

        String rankHolder = Integer.toString(cardRank);
        if(cardRank == 11){
            rankHolder = "Jack";
        }
        if(cardRank == 12){
            rankHolder = "Queen";
        }
        if(cardRank == 13){
            rankHolder = "King";
        }
        if(cardRank == 14){
            rankHolder = "Ace";
        }

        String cardString = rankHolder + " of " + cardSuit;
        return cardString;

    }

}
