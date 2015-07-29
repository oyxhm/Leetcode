"""
Given a list, rotate the list to the right by k places, where k is non-negative.

For example:
Given 1->2->3->4->5->NULL and k = 2,
return 4->5->1->2->3->NULL.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @param {integer} k
    # @return {ListNode}
    def rotateRight(self, head, k):
        temp, temp_k = head, k
        if not head or not head.next:
            return head
        while k > 0:
            head = self.rotateRightByOne(head)
            k -= 1
            if head == temp and temp_k != k:
                k %= (temp_k - k)
        return head

    def rotateRightByOne(self, head):
        cur = head
        while cur.next and cur.next.next:
            cur = cur.next
        new_head = cur.next
        cur.next = None
        new_head.next = head
        return new_head


if __name__ == '__main__':
    head = ListNode(1, 2, 3, 4)
    print Solution().rotateRight(head, 3)
