import random

from card import card


class deck:
    """
    model of a deck
    """

    def __init__(self):
        """
        initialize deck object
        """
        self.cardList = []
        deck.generate(self)



    def generate(self):
        """
        generates a deck of 52 cards
        :return: none
        """

        for i in range(0,4):
            for j in range(2,15):

                if i == 0: #Heart suit
                    suit = "heart"

                if i == 1: #Diamond suit
                    suit = "diamond"

                if i == 2: #spade suit
                    suit = "spade"

                if i == 3: #club suit
                    suit = "club"


                self.cardList.append(card(j, suit))

        random.shuffle(self.cardList)



    def drawCard(self):
        """
        draws a card from the deck
        :return: card
        """

        if self.cardList.__len__() != 0:
            return self.cardList.pop()

        else:
            self = deck()
            return self.cardList.pop()

    def printDeck(self):
        """
        prints deck of cards
        :return: none
        """

        for card in self.cardList:
            card.printCard()




