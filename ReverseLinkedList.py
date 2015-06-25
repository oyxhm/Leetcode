"""
Reverse a singly linked list.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def reverseList(self, head):
        # iteratively
        if not head or not head.next:
            return head
        pre = head
        cur = head.next
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        head.next = None
        return pre

    def reverseListRecursively(self, head):
        # recursively
        if not head or not head.next:
            return head
        new_head = self.reverseListRecursively(head.next)
        head.next.next = head
        head.next = None
        return new_head


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

    head = Solution().reverseListRecursively(n1)
