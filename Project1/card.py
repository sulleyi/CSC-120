class card:
    """
    Class for the card object

    """

    def __init__(self, value, suit):
        """
        initializes card object

        :param self: instance of card
        :param value: cards number or face value
        :param suit: suit value of card (heart,diamond, club, or spade)
        :return:
        """
        self.value = value
        self.suit = suit



    def printCard(self):

        print("[" + str(self.value) + " , " + self.suit + "]")
