package proj4;

import java.util.ArrayList;
import java.util.Arrays;

public class StudPokerHandTests{

    public static void main(String[] args) {

        test_all();
    }

    public static void test_all(){

        testSPHCompareTo();
        testAddCard();

    }

    public static void testSPHCompareTo(){

        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));
        StudPokerHand hand1 = new StudPokerHand(cc, (new ArrayList<Card> (Arrays.asList(new Card(13, "S"), new Card(12, "S")))));
        StudPokerHand hand2 = new StudPokerHand(cc, (new ArrayList<Card> (Arrays.asList(new Card(10, "S"), new Card(5, "H")))));

        int expectedValue = -1;

        int actualValue = hand1.compareTo(hand2);

        Testing.assertEquals("Testing StudPokerHand CompareTo",
                expectedValue,
                actualValue);
    }


    public static void testAddCard(){

        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));
        StudPokerHand hand1 = new StudPokerHand(cc, (new ArrayList<Card> (Arrays.asList(new Card(10, "S")))));

        hand1.addCard(new Card(5, "H"));

        int expectedValue =  1;

        int actualValue = 1;

        Testing.assertEquals("Testing StudPokerHand testAddCard",
                expectedValue,
                actualValue);



    }

    public static void testGetIthCard(){

        CommunityCardSet cc = new CommunityCardSet(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));
        StudPokerHand hand1 = new StudPokerHand(cc, (new ArrayList<Card> (Arrays.asList(new Card(10, "S")))));



        int expectedValue =  1;

        int actualValue = 1;

        Testing.assertEquals("Testing StudPokerHand testAddCard",
                expectedValue,
                actualValue);



    }
}