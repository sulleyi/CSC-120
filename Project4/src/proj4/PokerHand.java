package proj4; // do not erase. Gradescope expects this.

import java.util.*;

public class PokerHand {

    private int MAX_HAND_SIZE = 5;
    private ArrayList<Card> cardsInHand; //all the cards in the hand

     /**
     * A Constructer for a PokerHand Object
     *
     * @param cardList cards that will make up the PokerHand
     */
    public PokerHand(ArrayList<Card> cardList) {
        cardsInHand = cardList;
    }

    /**
     * add a card to the Poker Hand if there are less than 5 cards in the hand
     * otherwise do nothing
     *
     * @param card card being added to the PokerHand
     */
    public void addCard(Card card) {

        if (cardsInHand.size() < MAX_HAND_SIZE) {
            cardsInHand.add(card);
        }
    }

    /**
     * return the card in the pokerHand at the given index
     *
     * @param index index of card being retrieved
     * @return Card
     */
    public Card get_ith_card(int index) {
        if (index >= 0 && index < cardsInHand.size()) {
            return cardsInHand.get(index);
        } else {
            return null;
        }
    }

    /**
     * override the toString function to turn a PokerHand into a properly formatted string
     * @return String
     */
    public @Override String toString() {
        String str = "";
        for (int i = 0; i < cardsInHand.size(); i++) {
            str += cardsInHand.get(i).toString();
            str += "\n";
        }
        return str;
    }

    /**
     * Determines how this hand compares to another hand, returns
     * positive, negative, or zero depending on the comparison.
     *
     * @param other The hand to compare this hand to
     * @return a negative number if this is worth LESS than other, zero
     * if they are worth the SAME, and a positive number if this is worth
     * MORE than other
     */
    public int compareTo(PokerHand other) {

        //organize the hands and determine their types//
        //THIS hand
        TreeMap<Integer, Integer> rankOccurances = this.sortRanks();
        ArrayList<Integer> pairRanks = getRanks(rankOccurances, 1); //for seperating out the pairs
        ArrayList<Integer> highcardRanks = getRanks(rankOccurances, 0) ; //for seperating out the non-pairs
        Integer hand1Type = this.handType(pairRanks.size());

        //OTHER hand
        TreeMap<Integer, Integer> otherRankOccurances = other.sortRanks();
        ArrayList<Integer> otherPairRanks = getRanks(otherRankOccurances, 1); //for seperating out the pairs
        ArrayList<Integer> otherHighcardRanks = getRanks(otherRankOccurances, 0) ; //for seperating out the non-pairs
        Integer hand2Type = other.handType(otherPairRanks.size());


        int handTypeComparison = hand1Type.compareTo(hand2Type);

        if(handTypeComparison != 0){
            return handTypeComparison;
         }

        else {  //if hands are of the same type...
            if(!pairRanks.isEmpty()){ //if there are pairs to compare...
                int pairCompare = this.tieBreaker(pairRanks, otherPairRanks); //compare them
                if(pairCompare == 0){ //if the pair values are equal
                    return this.tieBreaker(highcardRanks, otherHighcardRanks); // return the highcard comparison
                }
                else{ //otherwise return the pair comparison
                    return pairCompare;
                }

            }
            else{ //if there are no pairs to compare, just return the highcard comparison
                return this.tieBreaker(highcardRanks, otherHighcardRanks);
            }
        }
    }

    /**
     * Determing the type of the hand. Flush, 2pair, 1pair, or highcard
     *
     * @return Integer : 4 if flush, 3 if 2pair, 2 if 1pair, 1 if highcard
     */
    private Integer handType(int pairRanksSize) {

        boolean isFlush = flushCheck();
        if(isFlush) {
            return 4; //FLUSH
        }
        if (pairRanksSize == 2) { // if you have 2 pairs
            return 3; //2Pair
        }
        if (pairRanksSize == 1) { //if you have 1 pair
            return 2; //1 PAIR
        }
        else { //If its not a flush, 2pair, or 1pair it has to be....
            return 1; //HIGHCARD
        }

    }

    /**
     * Breaks up all the hand data into managable chunks:
     * seperates suits and ranks into their own ArrayLists,
     * creates a Treemap of the ranks and their # of occurances,
     * uses the Treemap to fill ArrayLists with pair values, and non-pair(highcard) values
     *
     */
    private TreeMap<Integer, Integer> sortRanks(){

        ArrayList<Integer> allRanks = new ArrayList<Integer>(); //for seperating out the ranks of the cards
        TreeMap<Integer, Integer> rankOccurances = new TreeMap<Integer, Integer>(Collections.reverseOrder());//experimenting with a new data structure, makes sorting fuctions simplier

        for (int i = 0; i < cardsInHand.size(); i++) {
            Card currentCard = cardsInHand.get(i);//current card we are pulling data from
            allRanks.add(currentCard.getCardRank()); //adding the current cards rank to the rank array
        }

        //sort allRanks into a TreeMap with Key = Rank & Value = instances of the rank
        for (Integer i : allRanks) {
            Integer j = rankOccurances.get(i);
            rankOccurances.put(i, (j == null) ? 1 : j + 1);
        }
        return rankOccurances;
    }


    public ArrayList<Integer> getRanks(TreeMap<Integer, Integer> rankOccurances, int whichRanks){

        ArrayList<Integer> pairRanks = new ArrayList<Integer>(); //for seperating out the pairs
        ArrayList<Integer> highcardRanks = new ArrayList<Integer>(); //for seperating out the non-pairs

        //sort rankOccurances by pairs and non-pairs(highcards)
        for(Integer key : rankOccurances.keySet()){
            if(rankOccurances.get(key) == 4){ //2pair
                pairRanks.add(key);
                pairRanks.add(key);
            }
            if(rankOccurances.get(key) == 2 || rankOccurances.get(key) == 3){
                pairRanks.add(key);
            }
            else{
                highcardRanks.add(key);
            }
        }

        if(whichRanks == 0){
            return highcardRanks;
        }
        if(whichRanks == 1){
            return pairRanks;
        }
        else{
            return null;
        }
    }
    /**
     * compares two ArrayLists of ranks and determines which has the first instance of a greater value
     *
     * @param theseRanks Arraylist of ranks from this hand
     * @param otherRanks Arraylist of ranks from other hand
     * @return int 1 if theseRanks is greater, -1 if otherRanks is greater, 0 if all ranks are the same
     */
    private int tieBreaker(ArrayList<Integer> theseRanks, ArrayList<Integer> otherRanks) {

        //compare each rank
        for (int i = 0; i < theseRanks.size(); i++) {
            int currentCompare = theseRanks.get(i).compareTo(otherRanks.get(i)); //compare current index
            if (currentCompare != 0) { //if the current index ranks are different...
                return currentCompare; //return the comparison
            }
        }
        return 0; //you make it through all ranks and they are all the same
    }

    /**
     * checks if the hand is a flush
     *
     * @return true if hand is a flush, false if not
     */
    private boolean flushCheck(){

        ArrayList<String> allSuits = new ArrayList<String>(); //for seperating out the suits

        for (int i = 0; i < cardsInHand.size(); i++) {
            Card currentCard = cardsInHand.get(i);//current card we are pulling data from
            allSuits.add(currentCard.getCardSuit()); //adding the current cards suit to the suit array
        }

        //checking for a flush
        String checkSuit = allSuits.get(1);//a suit present in the hand
        if(Collections.frequency(allSuits, checkSuit) == cardsInHand.size()){
            return true;
        }
        else{
            return false;
        }
    }
}
