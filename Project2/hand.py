
class PokerHand:
    """
    models a poker hand
    """

    def __init__(self, hand_list=None):
        if hand_list is None:
            hand_list = []
        self.__hand = hand_list

    def get_hand(self):
        """
        getter method for hand(list of cards)

        :return: hand
        """
        return self.__hand

    def add_card(self, card):
        """
        append a card to a hand

        :param card: card being added
        :return: None
        """
        self.__hand.append( card )

    def get_ith_card(self, index):
        if 0 <= index < len( self.get_hand() ):
            return self.get_hand()[index]
        else:
            return None

    def deal_poker_hand(self, deck):
        """
        this function adds 5 cards from the deck to the hand

        :param deck: deck that cards are being drawn from
        :return:
        """

        for i in range( 5 ):
            self.__hand.append( deck.deal() )

    def what_is_it(self):
        """
        evaluates the hand

        :return: index[0] - hand type      index[1] - pair values                              index[2]
                 4 for flush                pairs = [] (empty list) - if there are no pairs    list of
                 3 for 2pair                pairs = [rank1,] - if 1 pair                       highcard values
                 2 for pair                 pairs = [rank1, rank2] - if 2 pairs                (all cards not in a pair)
                 1 for highcard
        """

        pairs = []
        highcards = []

        ranks = sorted( [card.get_rank() for card in self.get_hand()] )
        suits = [card.get_suit() for card in self.get_hand()]

        for r in set( ranks ):
            if ranks.count( r ) == 4:
                pairs.append( r )
                pairs.append( r )

            if ranks.count( r ) == 3:
                pairs.append( r )

            if ranks.count( r ) == 2:
                pairs.append( r )

            else:
                highcards.append( r )

        if all( s == suits[0] for s in suits ):
            return 4, pairs, highcards

        if len( pairs ) == 2:
            return 3, pairs, highcards

        if len( pairs ) == 1:
            return 2, pairs, highcards
        else:

            return 1, pairs, highcards

    def compare_to(self, other_hand):
        """
        Determines which of two poker hands is worth more. Returns an int
        which is either positive, negative, or zero depending on the comparison.
        :param self: The first hand to compare
        :param other_hand: The second hand to compare
        :return: a negative number if self is worth LESS than other_hand,
        zero if they are worth the SAME (a tie), and a positive number if
        self is worth MORE than other_hand

         """

        this_hand_type = self.what_is_it()[0]
        other_hand_type = other_hand.what_is_it()[0]

        this_hand_pairs = sorted( self.what_is_it()[1], reverse=True )
        other_hand_pairs = sorted( other_hand.what_is_it()[1], reverse=True )

        this_hand_highcards = sorted( self.what_is_it()[2], reverse=True )
        other_hand_highcards = sorted( other_hand.what_is_it()[2], reverse=True )

        if this_hand_type > other_hand_type:  # if this hand is a higher type
            return 1
        if this_hand_type < other_hand_type:  # if this hand is a lower type
            return -1
        if this_hand_type == other_hand_type:  # if same hand type
            if len( this_hand_pairs ) != 0:  # makes sure there are pairs
                if self.compare_to_helper( this_hand_pairs, other_hand_pairs ) == 0:  # if pairs tie
                    return self.compare_to_helper( this_hand_highcards,
                                                   other_hand_highcards )  # compare highcards result
                else:
                    return self.compare_to_helper( this_hand_pairs,
                                                   other_hand_pairs )  # compare pairs result
            else:  # if no pairs then just compare the highcards
                return self.compare_to_helper( this_hand_highcards,
                                               other_hand_highcards )  # compare highcards result

    def compare_to_helper(self, this_hand_list, other_hand_list):
        """

        :param this_hand_list: sorted list of ranks from 'this' hand
        :param other_hand_list: sorted list of ranks from other hand
        :return:  1 if this_hand_list contains first instance of a greater rank,
                  -1 if other_hand_list contains first instance of a greater rank,
                  and 0 if all ranks are the same
        """
        for rank1, rank2 in zip( this_hand_list, other_hand_list ):
            if rank1 > rank2:
                return 1
            if rank1 < rank2:
                return -1
            if rank1 == rank2:
                continue
        return 0

    def __str__(self):
        """
        prints all cards in hand
        :return: none
        """
        string = ""
        for card in self.get_hand():
            string += str( card ) + "\n"

        return string
