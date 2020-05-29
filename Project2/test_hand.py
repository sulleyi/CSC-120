from testing import *
from hand import *
from card import *


######TESTS###########
def test_all():
    start_tests( "Starting All Tests" )
    test_all_flushes()
    test_all_two_pair()
    test_all_pair()
    test_all_highcard()



#####FLUSH TESTS#####

def test_all_flushes():
    start_tests( "Testing Flushes" )
    compare_flushes1()
    compare_flushes2()
    compare_flushes_tie()
    compare_flush_2pair()
    compare_flush_pair()
    compare_flush_hi()
    finish_tests()


# Flush1 vs Flush2 (Flush 1 wins highcard is greater)
def compare_flushes1():
    hand1 = PokerHand( [Card( 13, "S" ), Card( 12, "S" ), Card( 9, "S" ), Card( 7, "S" ), Card( 3, "S" )] )
    hand2 = PokerHand( [Card( 4, "C" ), Card( 2, "C" ), Card( 7, "C" ), Card( 5, "C" ), Card( 10, "C" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs Flush2 (Flush 1 wins; Highcard is greater)",
                   expected_answer,
                   actual_answer )


# Flush1 vs Flush2 (Flush 2 wins highcard is greater)
def compare_flushes2():
    hand1 = PokerHand( [Card( 4, "C" ), Card( 2, "C" ), Card( 7, "C" ), Card( 5, "C" ), Card( 10, "C" )] )
    hand2 = PokerHand( [Card( 13, "S" ), Card( 12, "S" ), Card( 9, "S" ), Card( 7, "S" ), Card( 3, "S" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs Flush2 (Flush 2 wins highcard is greater)",
                   expected_answer,
                   actual_answer )


# Flush1 vs Flush2 (Tie)
def compare_flushes_tie():
    hand1 = PokerHand( [Card( 4, "C" ), Card( 2, "C" ), Card( 7, "C" ), Card( 5, "C" ), Card( 10, "C" )] )
    hand2 = PokerHand( [Card( 7, "S" ), Card( 5, "S" ), Card( 4, "S" ), Card( 2, "S" ), Card( 10, "S" )] )

    expected_answer = 0
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs Flush2 Tie",
                   expected_answer,
                   actual_answer )


# Flush vs 2 pair
def compare_flush_2pair():
    hand1 = PokerHand( [Card( 7, "S" ), Card( 5, "S" ), Card( 11, "S" ), Card( 2, "S" ), Card( 10, "S" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs 2pair (Flush 1 wins)",
                   expected_answer,
                   actual_answer )


# Flush vs pair
def compare_flush_pair():
    hand1 = PokerHand( [Card( 7, "S" ), Card( 5, "S" ), Card( 4, "S" ), Card( 2, "S" ), Card( 10, "S" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs pair (Flush 1 wins)",
                   expected_answer,
                   actual_answer )


# Flush vs high Card
def compare_flush_hi():
    hand1 = PokerHand( [Card( 7, "S" ), Card( 5, "S" ), Card( 4, "S" ), Card( 2, "S" ), Card( 10, "S" )] )
    hand2 = PokerHand( [Card( 3, "H" ), Card( 4, "D" ), Card( 10, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs highcard (Flush 1 wins)",
                   expected_answer,
                   actual_answer )


#####2 PAIR TESTS#####

def test_all_two_pair():
    start_tests( "Testing 2pair" )
    compare_2pair_flush()
    compare_2pair_2pair_1()
    compare_2pair_2pair_2()
    compare_2pair_2pair_3()
    compare_2pair_2pair_4()
    compare_2pair_2pair_5()
    compare_2pair_2pair_tie()
    compare_2pair_pair()
    compare_2pair_hi()
    finish_tests()


# 2pair vs Flush
def compare_2pair_flush():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 7, "S" ), Card( 5, "S" ), Card( 11, "S" ), Card( 2, "S" ), Card( 10, "S" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair vs Flush",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (2pair1 wins higher of pair values is greater)
def compare_2pair_2pair_1():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 6, "D" ), Card( 10, "S" ), Card( 10, "C" ), Card( 4, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair1 vs 2pair2 (2pair1 wins higher of pair values is greater)",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (2pair2 wins higher of pair values is greater)
def compare_2pair_2pair_2():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 14, "H" ), Card( 14, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair1 vs 2pair2 (2pair2 wins higher of pair values is greater)",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (2pair1 wins lower of pair values is greater)
def compare_2pair_2pair_3():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 3, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 3, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "2pair1 vs 2pair2 (2pair1 wins lower of pair values is greater)",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (2pair2 wins lower of pair values is greater)
def compare_2pair_2pair_4():
    hand1 = PokerHand( [Card( 3, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 3, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair1 vs 2pair2 (2pair2 wins lower of pair values is greater)",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (2pair1 wins, both pairs same but highcard wins)
def compare_2pair_2pair_5():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 2, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair1 vs 2pair2 (2pair1 wins, both pairs same but highcard wins)",
                   expected_answer,
                   actual_answer )


# 2pair1 vs 2pair2 (tie)
def compare_2pair_2pair_tie():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = 0
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair1 vs 2pair2 (tie)",
                   expected_answer,
                   actual_answer )


# 2pair vs pair
def compare_2pair_pair():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing 2pair vs pair",
                   expected_answer,
                   actual_answer )


# 2pair vs highcard
def compare_2pair_hi():
    hand1 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 3, "H" ), Card( 4, "D" ), Card( 10, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "2pair vs highcard",
                   expected_answer,
                   actual_answer )


#####PAIR TESTS#####

def test_all_pair():
    start_tests( "Testing pairs" )
    compare_pair_flush()
    compare_pair_2pair()
    compare_pair_pair_1()
    compare_pair_pair_2()
    compare_pair_pair_3()
    compare_pair_pair_4()
    compare_pair_hi()
    compare_pair_pair_tie()
    finish_tests()


# pair vs flush
def compare_pair_flush():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "C" ), Card( 2, "C" ), Card( 7, "C" ), Card( 5, "C" ), Card( 10, "C" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair vs flush",
                   expected_answer,
                   actual_answer )


# pair vs 2pair
def compare_pair_2pair():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair vs 2pair",
                   expected_answer,
                   actual_answer )


# pair1 vs pair2 (pair1 wins; high pair)
def compare_pair_pair_1():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 2, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 9, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "pair1 vs pair2 (pair1 wins; high pair)",
                   expected_answer,
                   actual_answer )


# pair1 vs pair2 (pair2 wins; high pair)
def compare_pair_pair_2():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 12, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 12, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair1 vs pair2 (pair2 wins; high pair)",
                   expected_answer,
                   actual_answer )


# pair1 vs pair2 (pair1 wins; highcard)
def compare_pair_pair_3():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 12, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair1 vs pair2 (pair1 wins; highcard)",
                   expected_answer,
                   actual_answer )


# pair1 vs pair2 (pair2 wins; highcard)
def compare_pair_pair_4():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 13, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair1 vs pair2 (pair2 wins; highcard",
                   expected_answer,
                   actual_answer )


# pair1 vs pair2 (tie)
def compare_pair_pair_tie():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = 0
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair1 vs pair2 (tie)",
                   expected_answer,
                   actual_answer )


# pair vs high Card
def compare_pair_hi():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 3, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing pair vs high Card",
                   expected_answer,
                   actual_answer )


#####HIGHCARD TESTS#####
def test_all_highcard():
    start_tests( "Testing Highcards" )
    compare_hi_flush()
    compare_hi_2pair()
    compare_hi_pair()
    compare_hi_hi_1()
    compare_hi_hi_2()
    compare_hi_hi_tie()
    finish_tests()


# highcard vs flush
def compare_hi_flush():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "C" ), Card( 2, "C" ), Card( 7, "C" ), Card( 5, "C" ), Card( 10, "C" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing Flush1 vs Flush2 (Flush 1 wins; Highcard is greater)",
                   expected_answer,
                   actual_answer )


# highcard vs 2pair
def compare_hi_2pair():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 4, "H" ), Card( 4, "D" ), Card( 8, "S" ), Card( 8, "C" ), Card( 6, "D" )] )
    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing highcard vs 2pair",
                   expected_answer,
                   actual_answer )


# highcard vs pair
def compare_hi_pair():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 10, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing highcard vs pair",
                   expected_answer,
                   actual_answer )


# highcard1 vs highcard2 (highcard1 wins)
def compare_hi_hi_1():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 12, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )

    expected_answer = 1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing highcard1 vs highcard2 (highcard1 wins)",
                   expected_answer,
                   actual_answer )


# highcard1 vs highcard2 (highcard2 wins)
def compare_hi_hi_2():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 12, "C" ), Card( 6, "D" )] )

    expected_answer = -1
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing highcard1 vs highcard2 (highcard2 wins)",
                   expected_answer,
                   actual_answer )


# highcard1 vs highcard2 (tie)
def compare_hi_hi_tie():
    hand1 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )
    hand2 = PokerHand( [Card( 10, "H" ), Card( 4, "D" ), Card( 9, "S" ), Card( 2, "C" ), Card( 6, "D" )] )

    expected_answer = 0
    actual_answer = hand1.compare_to( hand2 )
    assert_equals( "Testing highcard1 vs highcard2 (tie)",
                   expected_answer,
                   actual_answer )




if __name__ == "__main__":
    test_all()








"""
 _____  _____  _____ 
|_   _||  |  ||   __|
  | |  |     ||   __|
  |_|  |__|__||_____|
                     
                     
 _____  _____  ____  
|   __||   | ||    \ 
|   __|| | | ||  |  |
|_____||_|___||____/ 
               
"""
