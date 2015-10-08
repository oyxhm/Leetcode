package src.test;

import org.junit.Test;
import src.main.LongestPalindromeSubstring;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/7/15.
 */
public class LongestPalindromeSubstringTest {

    @Test
    public void testLongestPalindrome() throws Exception {
        String str = "fasdfsdalskslkjqwer";
        LongestPalindromeSubstring s = new LongestPalindromeSubstring();
        String string = s.longestPalindrome(str);
    }
}