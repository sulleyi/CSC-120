""" lets make some dominos and some functions to access them"""

"""creates a domino with a left and a right value"""
def create(left, right):
    domino = (left, right)
    return domino

"""gets left domino value"""
def get_left(domino):
    return domino[0]
"""gets right domino value"""
def get_right(domino):
    return domino[1]


"""converts domino value to a str and prints to terminal """
def as_str(domino):
    return ("[%d | %d]" % (get_left(domino), get_right(domino)))



