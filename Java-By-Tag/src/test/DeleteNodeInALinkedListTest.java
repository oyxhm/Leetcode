package src.test;

import org.junit.Test;
import src.main.DeleteNodeInALinkedList;
import src.main.ListNode;

/**
 * Created by yhf on 8/25/15.
 */
public class DeleteNodeInALinkedListTest {

    @Test
    public void testDeleteNode() throws Exception {
        DeleteNodeInALinkedList s = new DeleteNodeInALinkedList();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        s.deleteNode(n2);
    }
}