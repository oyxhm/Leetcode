/**
 * Created by yhf on 15/6/26.
 */

/*
Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is
counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

Let dp[i][j] stands for the edit distance between two strings with length i and j, i.e., word1[0,...,i-1] and word2[0,...,j-1].
There is a relation between dp[i][j] and dp[i-1][j-1]. Let's say we transform from one string to another. The first
string has length i and it's last character is "x"; the second string has length j and its last character is "y". The
following diagram shows the relation.

edit-distance-dynamic-programming

if x == y, then dp[i][j] == dp[i-1][j-1]
if x != y, and we insert y for word1, then dp[i][j] = dp[i][j-1] + 1
if x != y, and we delete x for word1, then dp[i][j] = dp[i-1][j] + 1
if x != y, and we replace x with y for word1, then dp[i][j] = dp[i-1][j-1] + 1
When x!=y, dp[i][j] is the min of the three situations.

Initial condition:
dp[i][0] = i, dp[0][j] = j

http://www.programcreek.com/2013/12/edit-distance-in-java/
*/

public class EditDistance {
    public static int minDistance(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
                }
            }
        }
        return dp[len1][len2];
    }

    public static void main(String[] args) {
        int distance = minDistance("hello", "ello");
    }
}
