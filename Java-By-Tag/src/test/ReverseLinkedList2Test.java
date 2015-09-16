package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.ReverseLinkedList2;

import static org.junit.Assert.*;

/**
 * Created by yhf on 9/15/15.
 */
public class ReverseLinkedList2Test {

    @Test
    public void testReverseBetween() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        ReverseLinkedList2 s = new ReverseLinkedList2();
        ListNode head = s.reverseBetween(n1, 2, 4);
    }
}