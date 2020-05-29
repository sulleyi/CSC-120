"""
Ian Sulley

A module for receiving a completed tic-tac-toe board in a txt file and evaluating the winner

Honor Code Statement:
I affirm that I have carried out the attached academic endeavors with full academic honesty,
in accordance with the Union College Honor Code and the course syllabus.

Comparing goodmain vs badmain:

badmain was written in a way that made the order of steps taken to solve a board confusing. because it was using global
variables the functions being called did not clearly reference the variables they were using. This made it hard to
follow what variables were being accessed in each function and how changing a global variable might affect the output of
the function. In goodmain, main() follows a clear and specific order. it takes a file and makes a board from it, then it
takes that board and evaluates a winner, then it prints the results. It much easier to see how the different variables
rely on each other when it is written this way. by changing the variables from a global scope and instead passing them
to each function as an argument, it is clear exactly what variable is being used in each function.
"""


def print_board(board):
    """
    given a board in list form, iterates though each part and prints it in a readable way

    :param board: list of 3 strings, each string a row in the board
    :return: prints the given board to the terminal
    """
    num_rows = len(board)
    num_cols = len(board[0])
    for row_num, row in enumerate(board):
        row_str = ''
        for col_num, marker in enumerate(row):
            row_str += marker
            if col_num < num_cols - 1:
                row_str += ' | '
        print(row_str)
        if row_num < num_rows - 1:
            print('---------')


def row_all_same(board, row):
    """
    given a board and a row, determines if each value in a row are equal or not and returns True or False

    :param board: the board whos row is being tested
    :param row: the row being tested
    :return: True if all values are equal, False otherwise
    """
    return board[row][0] == board[row][1] == board[row][2]


def column_all_same(column):
    """
    given a column, checks if each value in a column are equal or not, returns True or False

    :param column: list of strings, each string containing the contents of a board column
    :return: True if all column values are equal, false otherwise
    """
    return column[0] == column[1] == column[2]


def diagonal_all_same(diagonal):
    """
    given a diagonal, checks if each value in a diagonal are equal or not, returns True or False

    :param diagonal: list of strings, each string containing a diagonal value
    :return: True if all diagonal values are equal, false otherwise
    """
    return diagonal[0] == diagonal[1] == diagonal[2]


def get_back_slash(board):
    """
    given a board, gets diagonal values from upper left to bottom right and returns each value

    :param board: board from which diagonal is being retrieved
    :return: value of each diagonal tile
    """
    return [board[i][i] for i in range(len(board))]


def get_forward_slash(board):
    """
    gets diagonal values from board from bottom left to upper right

    :param board: board which diagonal is being retrieved from
    :return: value of each diagonal tile
    """

    return [board[len(board) - i - 1][i] for i in range(len(board))]


def columns(board):
    """
    given a board, separates each column into a list

    :param board: board columns are being retrieved from
    :return: list of values in a column for each column
    """
    num_cols = len(board[0])
    num_rows = len(board)

    to_return = []

    for i in range(num_cols):
        col_str = ''
        for j in range(num_rows):
            col_str += board[j][i]
        to_return.append(col_str)
    return to_return


def check_winner(board):
    """
    given a board, determines the winner and returns the winner

    :param board: board having winner evaluated
    :return: winner (X, O, or '')
    """
    for row_num, row in enumerate(board):
        if row_all_same(board, row_num):
            winner = board[row_num][0]
            return winner

    for col in columns(board):
        if column_all_same(col):
            winner = col[0]
            return winner

    if diagonal_all_same(get_back_slash(board)):
        winner = board[0][0]
        return winner

    if diagonal_all_same(get_forward_slash(board)):
        winner = board[2][0]
        return winner

    else:
        winner = ''
        return winner


def get_board_from_file(filename):
    """
    given a txt file, generates a board, represents board as a list of strings and returns it

    :param filename: file being converted
    :return: board (list of strings)
    """

    board_list = []
    board_file = open(filename, "r")
    for line in board_file:
        board_list.append(line.strip())
    board_file.close()
    return board_list


def print_winner(winner):
    """
    given a winner, prints the winner with proper formatting

    :param winner: winner being printed
    :return: if there is a winner prints '(name of winner) wins!' else prints 'tie game'
    """
    if winner != '':
        print(winner + ' WINS!!!!')
    else:
        print("TIE GAME!!!!")


def main():
    """
    main calls all processes necessary for converting a txt file into a board.
    Evaluates and prints board and its winner

    :return: Prints board and the winner
    """

    inputfile = 'input.txt'  # assign txt file to a variable

    board = get_board_from_file(inputfile)  # create a board from that txt file

    print_board(board)  # print the board

    winner = check_winner(board)  # determine the winner of the board

    print_winner(winner)  # print the winner


if __name__ == '__main__':
    main()
