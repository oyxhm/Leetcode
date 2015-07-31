"""
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
"""


class Solution:
    # @param {string} s
    # @param {integer} numRows
    # @return {string}
    def convert(self, s, numRows):
        if numRows <= 0:
            return None
        if numRows == 1:
            return s
        N = numRows * 2 - 2
        rows = ["" for _ in xrange(numRows)]
        for idx, char in enumerate(s):
            if idx % N < numRows:
                rows[idx % N] += char
            else:
                rows[N - idx % N] += char
        return "".join(rows)


if __name__ == '__main__':
    print Solution().convert("A", 1)
