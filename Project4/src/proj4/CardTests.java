package proj4;


public class CardTests{

    public static void testAll(){
        testGetCardRank();
        testGetCardSuit();
        testGetCardSuit2();
        testCardToString();
    }

    public static void testGetCardRank(){

        Card myCard = new Card(4, 2);

        int expectedValue = 4;
        int actualValue = myCard.getCardRank();

        Testing.assertEquals("Testing getCardRank",
                expectedValue,
                actualValue);
    }

    public static void testGetCardSuit(){

        Card myCard = new Card(4, 2);

        String expectedValue = "Clubs";
        String actualValue = myCard.getCardSuit();

        Testing.assertEquals("Testing getCardSuit",
                expectedValue,
                actualValue);
    }
    public static void testGetCardSuit2(){

        Card myCard = new Card(4, "Spades");

        String expectedValue = "Spades";
        String actualValue = myCard.getCardSuit();

        Testing.assertEquals("Testing getCardSuit",
                expectedValue,
                actualValue);
    }

    public static void testCardToString(){

        Card myCard = new Card(4, 2);

        String expectedValue = "[4 of Clubs]";
        String actualValue = myCard.toString();

        Testing.assertEquals("Testing getCardSuit",
                expectedValue,
                actualValue);
    }
}

