package src.test;

import org.junit.Test;
import src.main.LongestSubstringWithoutRepeatingCharacters;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/7/15.
 */
public class LongestSubstringWithoutRepeatingCharactersTest {

    @Test
    public void testLengthOfLongestSubstring() throws Exception {
        String str = "afsdtreymnkwqefq";
        LongestSubstringWithoutRepeatingCharacters s = new LongestSubstringWithoutRepeatingCharacters();
        int len = s.lengthOfLongestSubstring(str);
    }
}