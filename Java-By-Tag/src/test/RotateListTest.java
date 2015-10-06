package src.test;

import org.junit.Test;
import src.main.ListNode;
import src.main.RotateList;

import static org.junit.Assert.*;

/**
 * Created by yhf on 10/6/15.
 */
public class RotateListTest {

    @Test
    public void testRotateRight() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        RotateList s = new RotateList();
//        ListNode head = s.rotateRight(n1, 2);
//        ListNode head2 = s.rotateRight(n1, 7);
//        ListNode head3 = s.rotateRight(n1, 5);
        ListNode head = s.rotateRight(null, 0);
    }

}