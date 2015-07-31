/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
(you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".

Another example, nRows = 5, 

P       H
A     S I
Y   I   R
P L     I G
A       N

*/

public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        if (nRows == 1) {
            return s;
        }

        int len = s.length();
        int nCols = len / 2 + 1;
        char[][] letters = new char[nRows][nCols];

        int k = 0;  // index of String s
        for (int j = 0; j < nCols; j++) {
            for (int i = 0; i < nRows && k < len; i++) {
                if (j % (nRows - 1) == 0) {             // full column
                    letters[i][j] = s.charAt(k++);
                } else {                                // column with only one item
                    if ((i + j) % (nRows - 1) == 0) {   // the row with item
                        letters[i][j] = s.charAt(k++);                       
                    } else {                            // null row
                        continue;
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                if (letters[i][j] == '\0') {
                    continue;
                } else {
                    sb.append(letters[i][j]);
                }
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}