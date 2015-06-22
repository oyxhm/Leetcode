"""
The n-queens puzzle is the problem of placing n queens on an n*n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a
queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
"""
import copy


class Solution:

    # @return a list of lists of string
    def solveNQueens(self, n):

        self.__res = []

        def __solveNQueensDFS(n, rows):
            if len(rows) == n:
                temp = copy.deepcopy(rows)
                self.__res.append(temp)
            else:
                for i in xrange(n):
                    can_put_col_i = True  # can put at (len(rows), i)?
                    for idx, pos in enumerate(rows):
                        if not valid(idx, pos, len(rows), i):
                            can_put_col_i = False
                            break
                    if can_put_col_i:
                        rows.append(i)
                        __solveNQueensDFS(n, rows)
                        rows.pop()

        def valid(x1, y1, x2, y2):
            return y1 != y2 and abs(x2 - x1) != abs(y2 - y1)

        __solveNQueensDFS(n, [])
        res = []
        for solution in self.__res:
            new_solution = []
            for col in solution:
                init_row = '.' * n
                row = init_row[:col] + 'Q' + init_row[col+1:]
                new_solution.append(row)
            res.append(new_solution)
        return res


if __name__ == '__main__':
    print Solution().solveNQueens(4)
