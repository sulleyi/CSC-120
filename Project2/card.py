class Card:
    """
    Class for the Card object

    """

    def __init__(self, rank, suit):
        """
        initializes Card object

        :param self: instance of Card
        :param rank: cards number or face value
        :param suit: suit value of Card (heart,diamond, club, or spade)
        :return:
        """
        self.__card = {'rank': rank, 'suit': suit}



    def get_rank(self):
        """
        getter method for this cards rank
        :return:  rank value
        """

        return self.__card['rank']

    def get_suit(self):
        """
        getter method for this cards suit
        :return: suit value
        """
        return self.__card['suit']

    def __str__(self):

        rank = str(self.get_rank())

        if rank == "11":
            rank = "Jack"
        if rank == "12":
            rank = "Queen"
        if rank == "13":
            rank = "King"
        if rank == "14":
            rank = "Ace"

        suit = self.get_suit()

        if suit == "S":
            suit = "Spades"
        if suit == "D":
            suit = "Diamonds"
        if suit == "C":
            suit = "Clubs"
        if suit == "H":
            suit = "Hears"




        return "[ " + rank + " of " + suit + " ]"
