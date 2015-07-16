# encoding: utf-8
"""
Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @param {integer} m
    # @param {integer} n
    # @return {ListNode}
    def reverseBetween(self, head, m, n):
        if not head:
            return head
        start_pre = dummy_head = ListNode(0)
        dummy_head.next = head
        for _ in xrange(1, m):
            start_pre = start_pre.next
        start = cur = start_pre.next
        next = cur.next
        for _ in xrange(m, n):
            temp = next.next
            next.next = cur
            cur = next
            next = temp
        end = cur
        end_next = next
        start_pre.next = end
        start.next = end_next
        return dummy_head.next


if __name__ == '__main__':
    print Solution().reverseBetween(ListNode(1, 2, 3, 4, 5), 2, 4)
    print Solution().reverseBetween(ListNode(1, 2, 3, 4, 5), 1, 4)
    print Solution().reverseBetween(ListNode(1, 2, 3, 4, 5), 2, 5)
    print Solution().reverseBetween(ListNode(1, 2, 3, 4, 5), 1, 5)
    print Solution().reverseBetween(None, 0, 0)
