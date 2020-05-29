import random

from card import Card


class deck:
    """
    model of a deck
    """

    def __init__(self):
        """
        initialize deck object
        """
        self.__cardList = []
        deck.generate( self )
        deck.shuffle( self )

    def get_card_list(self):
        """
        getter method for cardList

        :return: cardList
        """
        return self.__cardList

    def size(self):
        """
        returns size of the deck left

        :return: size
        """


        card_list = self.get_card_list()
        return len( card_list )

    def generate(self):
        """
        generates a deck of 52 cards

        :return: none
        """

        for i in range( 0, 4 ):
            for j in range( 2, 15 ):

                if i == 0:  # Heart suit
                    suit = "H"

                if i == 1:  # Diamond suit
                    suit = "D"

                if i == 2:  # spade suit
                    suit = "S"

                if i == 3:  # club suit
                    suit = "C"

                self.__cardList.append( Card( j, suit ) )

    def shuffle(self):
        for i in range( 3 ):
            random.shuffle( self.__cardList )

    def deal(self):
        """
        draws a Card from the deck
        :return: Card
        """

        if self.__cardList.__len__() != 0:
            return self.__cardList.pop()

        else:
            return None

    def __str__(self):
        """
        prints deck of cards
        :return: none
        """
        string = "Hand \n"
        for card in self.get_card_list():
            string += card
            string += "\n"

        return string
