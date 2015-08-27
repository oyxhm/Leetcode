package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.SwapNodesInPairs;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/27/15.
 */
public class SwapNodesInPairsTest {

    @Test
    public void testSwapPairs() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        SwapNodesInPairs s = new SwapNodesInPairs();
        ListNode head = s.swapPairs(n1);
    }
}