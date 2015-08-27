package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.ReverseLinkedList;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/25/15.
 */
public class ReverseLinkedListTest {

    @Test
    public void testReverseList() throws Exception {
        ReverseLinkedList s = new ReverseLinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode head = s.reverseList(n1);
        ListNode head2 = s.reverseList2(n4);
    }
}