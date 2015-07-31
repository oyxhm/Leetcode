"""
Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be
changed.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def swapPairs(self, head):
        p = head
        pre = dummy = ListNode(0)
        while p and p.next:
            pre.next = p.next
            pre = p
            temp = p.next.next
            p.next.next = p
            p = temp
        pre.next = p
        return dummy.next


if __name__ == '__main__':
    n1 = ListNode(1)
    n2 = ListNode(2)
    n3 = ListNode(3)
    n4 = ListNode(4)
    n5 = ListNode(5)

    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    head = Solution().swapPairs(n1)
