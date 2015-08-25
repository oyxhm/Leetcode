package src.test;

import org.junit.Test;
import src.main.LinkedListCycle;
import src.main.ListNode;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/25/15.
 */
public class LinkedListCycleTest {

    @Test
    public void testHasCycle() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n3;
        LinkedListCycle s = new LinkedListCycle();
        assert s.hasCycle(n1);
    }
}