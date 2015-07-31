"""
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal
to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @param {integer} x
    # @return {ListNode}
    def partition(self, head, x):
        lt_dummy_head = lt_cur = ListNode(0)
        gt_dummy_head = gt_cur = ListNode(0)

        while head:
            if head.val < x:
                lt_cur.next = head
                lt_cur = lt_cur.next
            else:
                gt_cur.next = head
                gt_cur = gt_cur.next
            head = head.next
        lt_cur.next = gt_dummy_head.next
        gt_cur.next = None
        return lt_dummy_head.next


if __name__ == '__main__':
    n1 = ListNode(1)
    n2 = ListNode(4)
    n3 = ListNode(3)
    n4 = ListNode(2)
    n5 = ListNode(5)
    n6 = ListNode(2)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5
    n5.next = n6
    head = Solution().partition(n1, 3)
