"""
A really simple domino game.

I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.
"""

import boneyard as yard
# boneyard must have these functions:
"""
create()
draw(boneyard)
tiles_remaining(boneyard)
"""
import domino as doms
# domino must have these functions:
"""
 create(left, right)
 as_str(domino)
 get_left(domino)
 get_right(domino)
"""

"""initializes domino list"""
the_yard = yard.create()
"""initial game status param"""
game_over = False

while not game_over:
    """ends game"""
    if yard.tiles_remaining(the_yard) == 0:
        print('Ran out of dominoes')
        game_over = True
    else:
        """draw a domino and checks to it has a value of 6, which determines if you win or keep playing"""
        input('Press return to continue')
        tile = yard.draw(the_yard)
        print('Got tile %s' % (doms.as_str(tile)))
        if doms.get_left(tile) == 6 or doms.get_right(tile) == 6:
            print('Got a SIX!!!')
            game_over = True

print("Game Over.")    
