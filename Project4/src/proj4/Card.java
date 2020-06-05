package proj4; // do not erase. Gradescope expects this.

public class Card {


    private int cardRank;// Rank of the card
    private String cardSuit; //Suit of the card

    /**
     * Card Object Constructor
     * @param rank rank of the card
     * @param suit suit of the card
     */
    public Card(int rank, String suit){

        cardRank = rank;
        cardSuit = suit;

    }

    public Card(String rank, String suit){
        cardRank = Integer.parseInt(rank);
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

        String cardString = "[ " + cardRank + " of " + cardSuit + " ]";
        return cardString;

    }

}
