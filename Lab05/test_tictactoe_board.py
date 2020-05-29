"""
:author: Ian Sulley

Honor Code Statement:
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.

"""

from tictactoe_board import *
from testing import *


def test_get_winner():
    start_tests("Tests for tictactoe_board.get_winner()")
    test_get_winner_horiz_X()
    test_get_winner_horiz_O()
    test_get_winner_vert_X()
    test_get_winner_vert_O()
    test_get_winner_diag_l_to_r_X()
    test_get_winner_dia_l_to_r_O()
    test_get_winner_diag_r_to_l_X()
    test_get_winner_dia_r_to_l_O()
    test_get_winner_incomplete_board()
    test_get_winner_empty()
    finish_tests()

"""
Individual unit tests start here
"""

def test_get_winner_horiz_X():
    a_board = Tictactoe_board(['XXX', 'OOX', 'XOO'])
    assert_equals(str(a_board) + "Three Xs in a row horizontally",
                  'X',
                  a_board.get_winner())

def test_get_winner_horiz_O():
    a_board = Tictactoe_board(['XOX', 'OOO', 'XXO'])
    assert_equals(str(a_board) + "Three Os in a row horizontally",
                  'O',
                  a_board.get_winner())


def test_get_winner_vert_X():
    a_board = Tictactoe_board(['XOX', 'XXO', 'XOO'])
    assert_equals(str(a_board) + "Three Xs in a row vertically",
                  'X',
                  a_board.get_winner())


def test_get_winner_vert_O():
    a_board = Tictactoe_board(['XOX', 'OOX', 'XOO'])
    assert_equals(str(a_board) + "Three Os in a row vertically",
                  'O',
                  a_board.get_winner())

def test_get_winner_diag_l_to_r_X():
    a_board = Tictactoe_board(['XOX', 'OXO', 'OOX'])
    assert_equals(str(a_board) + "Three Xs in a row diagonally from top left to bottom right",
                  'X',
                  a_board.get_winner())


def test_get_winner_dia_l_to_r_O():
    a_board = Tictactoe_board(['OXX', 'OOX', 'XOO'])
    assert_equals(str(a_board) + "Three Os in a row diagonally from top left to bottom right",
                  'O',
                  a_board.get_winner())

def test_get_winner_diag_r_to_l_X():
    a_board = Tictactoe_board(['XOX', 'OXO', 'XOO'])
    assert_equals(str(a_board) + "Three Xs in a row diagonally from top right to bottom left",
                  'X',
                  a_board.get_winner())


def test_get_winner_dia_r_to_l_O():
    a_board = Tictactoe_board(['OXO', 'XOX', 'OXX'])
    assert_equals(str(a_board) + "Three Os in a row diagonally from top right to bottom left",
                  'O',
                  a_board.get_winner())

def test_get_winner_incomplete_board():
    a_board = Tictactoe_board(['XXX', 'OOX', 'XOO'])
    a_board.clear_cell(0, 0)
    assert_equals(str(a_board) + "Incomplete board, no winner yet",
                  None,
                  a_board.get_winner())


def test_get_winner_empty():
    a_board = Tictactoe_board(None)
    assert_equals(str(a_board) + "Empty board, no winner yet",
                  None,
                  a_board.get_winner())


if __name__ == "__main__":
    test_get_winner()
