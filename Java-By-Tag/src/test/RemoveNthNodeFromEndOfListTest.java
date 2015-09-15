package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.RemoveNthNodeFromEndOfList;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/31/15.
 */
public class RemoveNthNodeFromEndOfListTest {

    @Test
    public void testRemoveNthFromEnd() throws Exception {
        RemoveNthNodeFromEndOfList s = new RemoveNthNodeFromEndOfList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        assert s.removeNthFromEnd(n1, 1) == null;

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        assert s.removeNthFromEnd(n1, 5) == n2;
        ListNode head = s.removeNthFromEnd(n1, 2);
    }
}