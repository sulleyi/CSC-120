"""
Models a boneyard -- a pile of dominoes.
"""

import domino as d
import random

"""creates a list of 36 dominos"""
def create():
    yard = []
    for i in range(0,7):
        for j in range(0, 7):
            tile = d.create(i, j)
            yard.append(tile)
    return yard

"""returns a random tile from the boneyard, removes that tile from boneyard list"""
def draw(boneyard):
    n = random.randint(0, len(boneyard)-1)
    return boneyard.pop(n)


"""returns number of tiles remaining in the boneyard list"""
def tiles_remaining(boneyard):
    return len(boneyard)

