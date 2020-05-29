from deck import deck
from hand import hand
from accumulator import accumulator

"""
By: Ian Sulley

Honor Code:
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.

Refactoring:
I eliminated the use of global variables by building an accumulator object that stores and tracks all the statistics you
may want to know about the results of the current test

I eliminated my prints result function by overriding the ___str___() property of my accumulator object.
This way just by printing the accumulator you automatically have it in correct formatting with all data fields displayed
"""



def count_hand(accum, my_hand):
    """
    counts instances of each type of hand
    :param my_hand:  hand that is being counted
    :return: none
    """

    hand_value = my_hand.what_is_it

    if hand_value == "Flush":
        accum.flush_count += 1
    if hand_value == "4 of a kind" or hand_value == "Full House" or hand_value == "2 pair":
        accum.two_pair_count += 1
    if hand_value == "1 pair" or hand_value == "3 of a kind":
        accum.pair_count += 1
    else:
        accum.high_card_count += 1


def generate_hand(deck):
    """
    generates a hand from the given deck
    :param deck: deck used to form hand
    :return: hand
    """
    new_hand = hand()
    new_hand.deal_poker_hand(deck)
    return new_hand


def generate_deck():
    """
    creates a new deck
    :return: deck
    """

    new_deck = deck()
    return new_deck


def tester(accum):
    """
    runs necessary processedures to create and count hands
    :param number_of_hands: how many hands you want to create
    :return: none
    """

    hands_made = 0  # keeps track of hands made
    my_deck = generate_deck()

    while hands_made < accum.number_of_hands:

        if (len(my_deck.cardList) >= 5):  # if we can make a full hand then do so

            my_hand = generate_hand(my_deck)
            count_hand(accum, my_hand)
            hands_made += 1  # we can still make hands

        if (len(my_deck.cardList) < 5):  # if the cards in the deck drops below 5

            new_deck = generate_deck()  # generate a new deck

            new_deck.cardList += my_deck.cardList
            my_deck = new_deck


def main():

    num_of_hands = [10000, 20000, 30000, 40000, 50000, 60000, 70000, 80000, 90000, 100000]
    print("# of hands     pairs    %      2 pairs    %      flushes    %      high card    %")
    for num in num_of_hands:
        x = accumulator(num)
        tester(x)
        x.calculate_percents()
        print(x)


if __name__ == '__main__':
    main()
