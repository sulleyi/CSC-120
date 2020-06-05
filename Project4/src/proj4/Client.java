package proj4;

import java.util.ArrayList;

public class Client{


    public static void main(String[] args){

        Deck myDeck = new Deck();
        myDeck.shuffle();

        ArrayList<Card> cc = new ArrayList<Card>();
        for(int i = 0; i < 5; i++){
            cc.add(myDeck.deal());
        }


        ArrayList<Card> StudHand1 = new ArrayList<Card>();
        ArrayList<Card> StudHand2 = new ArrayList<Card>();
        for(int i = 0; i < 2; i++){
            StudHand1.add(myDeck.deal());
            StudHand2.add(myDeck.deal());
        }
        CommunityCardSet myCCS = new CommunityCardSet(cc);

        StudPokerHand myhand = new StudPokerHand(myCCS, StudHand1);
        StudPokerHand otherhand = new StudPokerHand(myCCS, StudHand2);


        System.out.print(myhand.compareTo(otherhand));


    }
}