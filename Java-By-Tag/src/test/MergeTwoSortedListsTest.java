package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.MergeTwoSortedLists;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/25/15.
 */
public class MergeTwoSortedListsTest {

    @Test
    public void testMergeTwoLists() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(5);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);

        n1.next = n2;
        n2.next = n3;

        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n8;

        MergeTwoSortedLists s = new MergeTwoSortedLists();
        ListNode head = s.mergeTwoLists(n1, n4);
    }
}
