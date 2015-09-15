package src.main;

/**
 * Created by yhf on 9/15/15.
 */

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 */

public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode head2 = partition(head);
        ListNode head1 = sortList(head);
        head2 = sortList(head2);
        return merge(head1, head2);
    }

    /**
     * Partition the list at mid and return the head of the second half of the list.
     */
    private ListNode partition(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode ret = slow.next;
        slow.next = null;
        return ret;
    }

    /**
     * Merge two sorted lists.
     */
    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0), cur = dummy;
        while (head1 != null && head2 != null) {
            if (head1.val <= head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        if (head1 != null) {
            cur.next = head1;
        } else {
            cur.next = head2;
        }
        return dummy.next;
    }
}
