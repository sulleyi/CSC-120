"""
Ian Sulley

I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

from die import Die


def main():
    """
    instantiates two dice objects and plays a game comparing the results.
    If twice the 6 sided die equals the result of the 12 sided die you win, else you lose and roll again.
    :return: Die values and Win or Lose
    """
    die_12 = Die(12)
    die_6 = Die()

    while (die_6.get_value() * 2) != die_12.get_value():

        print(str(die_12.get_value()) + " does not equal " + str(die_6.get_value()) + " times 2")
        print("You lose! Roll again. \n")

        die_6.roll()
        die_12.roll()


    else:
        print(str(die_12.get_value()) + " equals " + str(die_6.get_value()) + " times 2")
        print("You win!")


if __name__ == '__main__':
    main()
