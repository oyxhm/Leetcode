package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.RemoveLinkedListElements;

import static org.junit.Assert.*;

/**
 * Created by yhf on 9/15/15.
 */
public class RemoveLinkedListElementsTest {

    @Test
    public void testRemoveElements() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(1);
        ListNode n7 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        RemoveLinkedListElements s = new RemoveLinkedListElements();
        ListNode head = s.removeElements(n1, 1);
    }
}