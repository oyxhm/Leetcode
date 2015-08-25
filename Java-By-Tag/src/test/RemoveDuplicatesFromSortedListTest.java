package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.RemoveDuplicatesFromSortedList;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/25/15.
 */
public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void testDeleteDuplicates() throws Exception {
        RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(2);
        ListNode n5 = new ListNode(2);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        s.deleteDuplicates(n1);
    }
}