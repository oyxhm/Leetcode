"""
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of
the first two lists.
"""
from ListNode import ListNode

class Solution:
    # @param {ListNode} l1
    # @param {ListNode} l2
    # @return {ListNode}
    def mergeTwoLists(self, l1, l2):
        cur = dummy = ListNode(0)
        while l1 and l2:
            if l1.val <= l2.val:
                cur.next = l1
                l1 = l1.next
            else:
                cur.next = l2
                l2 = l2.next
            cur = cur.next
        cur.next = l1 or l2
        return dummy.next




if __name__ == '__main__':
    n1 = ListNode(1)
    n2 = ListNode(3)
    n3 = ListNode(5)
    n4 = ListNode(7)
    n5 = ListNode(9)
    n1.next = n2
    n2.next = n3
    n3.next = n4
    n4.next = n5

    m1 = ListNode(2)
    m2 = ListNode(4)
    m3 = ListNode(6)
    m1.next = m2
    m2.next = m3

    head = Solution().mergeTwoLists(n1, m1)
