package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.RemoveDuplicatesFromSortedList2;

import static org.junit.Assert.*;

/**
 * Created by yhf on 9/16/15.
 */
public class RemoveDuplicatesFromSortedList2Test {

    @Test
    public void testDeleteDuplicates() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(3);
        ListNode n5 = new ListNode(4);
        ListNode n6 = new ListNode(4);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;

        RemoveDuplicatesFromSortedList2 s = new RemoveDuplicatesFromSortedList2();
        ListNode head = s.deleteDuplicates(n1);
    }
}