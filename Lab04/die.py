import random


class Die:
    """
    instance of a die
    """
    def __init__(self, sides=6):
        """
        Initializes an instance of a die object

        :param sides: number of sides of the die. 6 sides by default
        """
        self.__sides = sides
        self.__top_value = random.randint(1, sides)


    def get_sides(self):
        """
        getter method for number of sides of the die

        :return: number of sides
        """
        return self.__sides

    def get_value(self):
        """
        getter method for tip value of the die

        :return: top value
        """
        return self.__top_value



    def roll(self):
        """
        rolls the die, setting the top value as a random number in the range of the die's number of sides

        :return: none
        """
        sides = self.get_sides()
        self.__top_value = random.randint(1, sides)
