class accumulator:
    """
    class for accumulating my results

    Refactoring:
    I added the percentage counts as accumulator properties so it is easier to keep track of them
    and keep them with the test they were computed from
    """

    def __init__(self, number_of_hands):

        self.number_of_hands = number_of_hands

        self.flush_count = 0

        self.two_pair_count = 0

        self.pair_count = 0

        self.high_card_count = 0

        self.flush_percent = 0

        self.two_pair_percent = 0

        self.pair_percent = 0

        self.high_card_percent = 0


    def __str__(self):
        """
        builtin in method so that when you call print on an object it does this
        :return: values of each count and percentage
        """
        x = " "

        if(self.number_of_hands != 100000):
            hand_x = 4 * x
        else:
            hand_x = 3 * x


        return(hand_x + format(self.number_of_hands, ",") + 5 * x
              + format(self.pair_count, ">5") + 2 * x + format(self.pair_percent, "0>5.2f") + 6 * x
              + format(self.two_pair_count, ">5") + 2 * x + format(self.two_pair_percent, "0>5.2f") + 6 * x
              + format(self.flush_count, ">5") + 2 * x + format(self.flush_percent, "0>5.2f") + 8 * x
              + format(self.high_card_count, ">5") + 2 * x + format(self.high_card_percent, "0>5.2f"))





    def calculate_percents(self):
        """
        calculates the percentage value of each hand type based on number of hands delt
        :return: none
        """


        self.flush_percent = (self.flush_count / self.number_of_hands) * 100

        self.two_pair_percent = (self.two_pair_count / self.number_of_hands) * 100

        self.pair_percent = (self.pair_count / self.number_of_hands) * 100

        self.high_card_percent = (self.high_card_count / self.number_of_hands) * 100
