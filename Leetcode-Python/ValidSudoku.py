"""
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
"""


class Solution:
    # @param {character[][]} board
    # @return {boolean}
    def isValidSudoku(self, board):
        for row in board:
            existed = [False] * 10
            for entry in row:
                if entry != '.':
                    if existed[int(entry)]:
                        return False
                    existed[int(entry)] = True

        for idx_col in xrange(9):
            existed = [False] * 10
            for idx_row in xrange(9):
                entry = board[idx_row][idx_col]
                if entry != '.':
                    if existed[int(entry)]:
                        return False
                    existed[int(entry)] = True

        for i in xrange(3):
            for j in xrange(3):
                existed = [False] * 10
                for idx_row in xrange(i * 3, i * 3 + 3):
                    for idx_col in xrange(j * 3, j * 3 + 3):
                        entry = board[idx_row][idx_col]
                        if entry != '.':
                            if existed[int(entry)]:
                                return False
                            existed[int(entry)] = True

        return True


if __name__ == '__main__':
    print Solution().isValidSudoku([".87654321","2........","3........","4........","5........","6........","7........","8........","9........"])
