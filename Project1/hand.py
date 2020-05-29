class hand:
    """
    models a poker hand
    """

    def __init__(self):
        self.hand = []

    def deal_poker_hand(self, deck):
        """
        this function adds 5 cards from the deck to the hand

        :param deck: deck that cards are being drawn from
        :return:
        """

        for i in range(5):
            self.hand.append(deck.drawCard())

    @property
    def what_is_it(self):
        """
        evaluates the hand

        :return: value of hand
        """
        pairs = []
        triples = []

        values = sorted([card.value for card in self.hand])
        suits = [card.suit for card in self.hand]

        for v in set(values):
            if values.count(v) == 4:
                return "4 of a kind"
            if values.count(v) == 3:
                triples.append(v)
            if values.count(v) == 2:
                pairs.append(v)

        if all(s == suits[0] for s in suits):
            return "Flush"

        if len(triples) == 1 and len(pairs) == 1:
            return "Full House"

        if len(triples) == 1 and len(pairs) == 0:
            return "3 of a kind"

        if len(pairs) == 2:
            return "2 pair"

        if len(pairs) == 1:
            return "1 pair"
        else:
            return "High card"

    def print_hand(self):
        """
        prints all cards in hand
        :return: none
        """

        for card in self.hand:
            card.printCard()
