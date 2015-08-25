package src.test;

import org.junit.Test;
import src.main.WordBreak;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/24/15.
 */
public class WordBreakTest {

    @Test
    public void testWordBreak() throws Exception {
        WordBreak s = new WordBreak();
        Set<String> wordDict = new HashSet<>();
        wordDict.add("leet");
        wordDict.add("code");
        assert s.wordBreak("leetcode", wordDict) == true;
    }
}