"""
Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.
"""
import copy


class Solution:

    # @param {integer} n
    # @return {integer}
    def totalNQueens(self, n):
        self.__res = []
        self.__count = 0

        def __totalNQueensDFS(n, rows):
            if len(rows) == n:
                # NOTE: DEEP COPY!!!!!!!
                # here `rows` is a just a list of integers,
                # so can also copy like these:
                # temp = rows[:]
                # temp = copy.copy(rows)
                temp = copy.deepcopy(rows)
                self.__res.append(temp)
                self.__count += 1
            else:
                for i in xrange(n):
                    can_put_col_i = True  # can put at (len(rows), i)?
                    for idx, pos in enumerate(rows):
                        if not valid(idx, pos, len(rows), i):
                            can_put_col_i = False
                            break
                    if can_put_col_i:
                        rows.append(i)
                        __totalNQueensDFS(n, rows)
                        rows.pop()

        def valid(x1, y1, x2, y2):
            return y1 != y2 and abs(x2 - x1) != abs(y2 - y1)

        __totalNQueensDFS(n, [])
        return self.__count


if __name__ == '__main__':
    s = Solution()
    print s.totalNQueens(4)
