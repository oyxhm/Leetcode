package src.test;

import org.junit.Test;
import src.main.InsertionSortList;
import src.main.ListNode;

import static org.junit.Assert.*;

/**
 * Created by yhf on 9/15/15.
 */
public class InsertionSortListTest {

    @Test
    public void testInsertionSortList() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n5.next = n4;
        n4.next = n3;
        n3.next = n2;
        n2.next = n1;
        InsertionSortList s = new InsertionSortList();
        ListNode head = s.insertionSortList(n5);
    }
}
