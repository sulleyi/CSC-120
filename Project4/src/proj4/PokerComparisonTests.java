package proj4;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Author: Ian Sulley
 *
 * Honor Code: I affirm that I have carried out the attached academic endeavors
 * with full academic honesty, in accordance with the Union College Honor Code
 * and the course syllabus
 */

/**
 * Testing Class for PokerHand compareTo()
 */
public class PokerComparisonTests {

    public static void main(String[] args) {

        test_all();
    }


    //######TESTS###########
    public static void test_all(){
        Testing.startTests();
        test_all_flushes();
        test_all_two_pair();
        test_all_pair();
        Testing.finishTests();
    }


//#####FLUSH TESTS#####

    public static void test_all_flushes() {
        Testing.startTests();
        compare_flushes1();
        compare_flushes2();
        compare_flushes_tie();
        compare_flush_2pair();
        compare_flush_pair();
        compare_flush_hi();
        Testing.finishTests();
    }

    //# Flush1 vs Flush2 (Flush 1 wins highcard is greater)
    public static void compare_flushes1() {
        ArrayList<Card> hand1array = new ArrayList<Card>(Arrays.asList(new Card(13, "S"), new Card(12, "S"), new Card(9, "S"), new Card(7, "S"), new Card(3, "S")));
        PokerHand hand1 = new PokerHand(hand1array);
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs Flush2 (Flush 1 wins; Highcard is greater)",
                expected_answer,
                actual_answer);
    }

    //# Flush1 vs Flush2 (Flush 2 wins highcard is greater)
    public static void compare_flushes2() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(13, "S"), new Card(12, "S"), new Card(9, "S"), new Card(7, "S"), new Card(3, "S"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs Flush2 (Flush 2 wins highcard is greater)",
                expected_answer,
                actual_answer);
    }

    //# Flush1 vs Flush2 (Tie)
    public static void compare_flushes_tie() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "C"), new Card(2, "C"), new Card(7, "C"), new Card(5, "C"), new Card(10, "C"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(7, "S"), new Card(5, "S"), new Card(4, "S"), new Card(2, "S"), new Card(10, "S"))));

        int expected_answer = 0;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs Flush2 Tie",
                expected_answer,
                actual_answer);
    }

    //# Flush vs 2 pair
    public static void compare_flush_2pair() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(7, "S"), new Card(5, "S"), new Card(11, "S"), new Card(2, "S"), new Card(10, "S"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs 2pair (Flush 1 wins)",
                expected_answer,
                actual_answer);
    }

    //# Flush vs pair
    public static void compare_flush_pair() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(7, "S"), new Card(5, "S"), new Card(4, "S"), new Card(2, "S"), new Card(10, "S"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs pair (Flush 1 wins)",
                expected_answer,
                actual_answer);
    }

    //# Flush vs high Card
    public static void compare_flush_hi() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(7, "S"), new Card(5, "S"), new Card(4, "S"), new Card(2, "S"), new Card(10, "S"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(3, "H"), new Card(4, "D"), new Card(10, "S"), new Card(8, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing Flush1 vs highcard (Flush 1 wins)",
                expected_answer,
                actual_answer);
    }

//#####2 PAIR TESTS#####

    public static void test_all_two_pair() {
        Testing.startTests();
        compare_2pair_flush();
        compare_2pair_2pair_1();
        compare_2pair_2pair_2();
        compare_2pair_2pair_3();
        compare_2pair_2pair_4();
        Testing.finishTests();
    }

    //# 2pair vs Flush
    public static void compare_2pair_flush() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(7, "S"), new Card(5, "S"), new Card(11, "S"), new Card(2, "S"), new Card(10, "S"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing 2pair vs Flush",
                expected_answer,
                actual_answer);
    }

    //# 2pair1 vs 2pair2 (2pair1 wins higher of pair values is greater)
    public static void compare_2pair_2pair_1() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(6, "D"), new Card(10, "S"), new Card(10, "C"), new Card(4, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing 2pair1 vs 2pair2 (2pair1 wins higher of pair values is greater)",
                expected_answer,
                actual_answer);
    }

    //# 2pair1 vs 2pair2 (2pair2 wins higher of pair values is greater)
    public static void compare_2pair_2pair_2() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(14, "H"), new Card(14, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing 2pair1 vs 2pair2 (2pair2 wins higher of pair values is greater)",
                expected_answer,
                actual_answer);
    }

    //# 2pair1 vs 2pair2 (2pair1 wins lower of pair values is greater)
    public static void compare_2pair_2pair_3() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(3, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(3, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("2pair1 vs 2pair2 (2pair1 wins lower of pair values is greater)",
                expected_answer,
                actual_answer);
    }

    //# 2pair1 vs 2pair2 (2pair2 wins lower of pair values is greater)
    public static void compare_2pair_2pair_4() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(3, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(3, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(4, "H"), new Card(4, "D"), new Card(8, "S"), new Card(8, "C"), new Card(6, "D"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing 2pair1 vs 2pair2 (2pair2 wins lower of pair values is greater)",
                expected_answer,
                actual_answer);
    }

//#####PAIR TESTS#####

    public static void test_all_pair() {
        Testing.startTests();
        compare_pair_pair_1();
        compare_pair_pair_2();
        compare_pair_pair_3();
        compare_pair_pair_4();
        Testing.finishTests();
    }


    //# pair1 vs pair2 (pair1 wins; high pair)
    public static void compare_pair_pair_1() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(2, "H"), new Card(4, "D"), new Card(9, "S"), new Card(9, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("pair1 vs pair2 (pair1 wins; high pair)",
                expected_answer,
                actual_answer);
    }

    //# pair1 vs pair2 (pair2 wins; high pair)
    public static void compare_pair_pair_2() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(12, "H"), new Card(4, "D"), new Card(9, "S"), new Card(12, "C"), new Card(6, "D"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing pair1 vs pair2 (pair2 wins; high pair)",
                expected_answer,
                actual_answer);
    }

    //# pair1 vs pair2 (pair1 wins; highcard)
    public static void compare_pair_pair_3() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(12, "S"), new Card(10, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));

        int expected_answer = 1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing pair1 vs pair2 (pair1 wins; highcard)",
                expected_answer,
                actual_answer);
    }

    //# pair1 vs pair2 (pair2 wins; highcard)
    public static void compare_pair_pair_4() {
        PokerHand hand1 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(4, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));
        PokerHand hand2 = new PokerHand(new ArrayList<Card>(Arrays.asList(new Card(10, "H"), new Card(13, "D"), new Card(9, "S"), new Card(10, "C"), new Card(6, "D"))));

        int expected_answer = -1;
        int actual_answer = hand1.compareTo(hand2);
        Testing.assertEquals("Testing pair1 vs pair2 (pair2 wins; highcard",
                expected_answer,
                actual_answer);
    }
}





/*


 _______  _     _  ______     ______  _     _  _____
(__ _ __)(_)   (_)(______)   (______)(_)   (_)(_____)
   (_)   (_)___(_)(_)__      (_)__   (__)_ (_)(_)  (_)
   (_)   (_______)(____)     (____)  (_)(_)(_)(_)  (_)
   (_)   (_)   (_)(_)____    (_)____ (_)  (__)(_)__(_)
   (_)   (_)   (_)(______)   (______)(_)   (_)(_____)


 */



