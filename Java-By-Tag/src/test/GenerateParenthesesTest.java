package src.test;

import org.junit.Test;
import src.main.GenerateParentheses;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/10/15.
 */
public class GenerateParenthesesTest {

    @Test
    public void testGenerateParenthesis() throws Exception {
        GenerateParentheses s = new GenerateParentheses();
        List<String> res = s.generateParenthesis(3);
    }
}