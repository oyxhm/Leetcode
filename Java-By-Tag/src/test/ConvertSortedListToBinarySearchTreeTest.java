package src.test;

import org.junit.Test;
import src.main.ConvertSortedListToBinarySearchTree;
import src.main.ListNode;
import src.main.TreeNode;

import static org.junit.Assert.*;

/**
 * Created by yhf on 8/27/15.
 */
public class ConvertSortedListToBinarySearchTreeTest {

    @Test
    public void testSortedListToBST() throws Exception {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        ConvertSortedListToBinarySearchTree s = new ConvertSortedListToBinarySearchTree();
        TreeNode root = s.sortedListToBST(n1);
    }
}