from deck import deck
from hand import PokerHand

"""
By: Ian Sulley

Honor Code:
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.

"""


def generate_hand(deck):
    """
    generates a hand from the given deck
    :param deck: deck used to form hand
    :return: hand
    """
    new_hand = PokerHand()
    if (len( deck.get_card_list() ) >= 5):
        new_hand.deal_poker_hand( deck )
        return new_hand
    if (len( deck.get_card_list() ) < 5):  # if the cards in the deck drops below 5

        new_deck = generate_deck()  # generate a new deck

        new_deck.extend(deck.get_card_list())
        deck = new_deck
        new_hand.deal_poker_hand( deck )

        return None


def generate_deck():
    """
    creates a new deck
    :return: deck
    """

    new_deck = deck()
    return new_deck


def main():

    my_deck = generate_deck() #make a deck of cards
    score_count = 0 #keep track of score

    while True:

        if len( my_deck.get_card_list() ) < 10:
            break

        hand_1 = generate_hand( my_deck )
        hand_2 = generate_hand( my_deck )

        evaluated_winner = hand_1.compare_to( hand_2 )

        print( "Hand 1: \n" )
        print( hand_1 )
        print( "\n" )

        print( "Hand 2: \n" )
        print( hand_2 )
        print( "\n" )

        user_winner = int( input( "Who is the winner?(1, 2, or 0 if tie): " ) )

        while user_winner != 1 and user_winner != 2 and user_winner != 0:
            user_winner = int( input( "Sorry, your answer was invalid, please enter 1, 2, or 0.: " ) )

        print( user_winner )
        if user_winner == 2:
            user_winner = -1
        if user_winner == evaluated_winner:
            score_count += 1
            print( "Correct! 1 point awarded." )
        else:
            print( "Sorry, Wrong Answer." )
            print( evaluated_winner )
            game_over = True

    print( "Congrats, You've made it through the entire deck!" )
    print( "Your score: " + str( score_count ) )
    print( "Thanks for playing!" )


if __name__ == '__main__':
    main()
