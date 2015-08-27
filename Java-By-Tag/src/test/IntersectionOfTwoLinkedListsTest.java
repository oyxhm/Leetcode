package src.test;

import org.junit.Test;
import src.main.IntersectionOfTwoLinkedLists;
import src.main.ListNode;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/27/15.
 */
public class IntersectionOfTwoLinkedListsTest {

    @Test
    public void testGetIntersectionNode() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        ListNode n8 = new ListNode(8);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n6.next = n7;
        n7.next = n8;
        n8.next = n3;

        IntersectionOfTwoLinkedLists s = new IntersectionOfTwoLinkedLists();
        ListNode Intersection = s.getIntersectionNode(n1, n6);
    }
}