package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.MergeKSortedLists;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/6/15.
 */
public class MergeKSortedListsTest {

    @Test
    public void testMergeKLists() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        ListNode n9 = new ListNode(9);
        ListNode n10 = new ListNode(10);
        ListNode n11 = new ListNode(11);
        ListNode n12 = new ListNode(12);

        n1.next = n4;
        n4.next = n5;
        n5.next = n10;

        n2.next = n3;
        n3.next = n6;
        n6.next = n11;

        n7.next = n8;
        n8.next = n9;
        n9.next = n12;

        MergeKSortedLists s = new MergeKSortedLists();
        ListNode head = s.mergeKLists(new ListNode[]{n1, n2, n7});
    }
}