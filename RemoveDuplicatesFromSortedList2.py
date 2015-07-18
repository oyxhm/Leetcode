"""
Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def deleteDuplicates(self, head):
        if not head:
            return head
        dummy_head = ListNode(head.val - 1)
        dummy_head.next = head
        pre = dummy_head
        while pre:
            cur = pre.next
            if cur and cur.next and cur.val == cur.next.val:
                while cur and cur.next and cur.val == cur.next.val:
                    cur = cur.next
                pre.next = cur.next
                cur = pre.next
            else:
                pre = cur
        return dummy_head.next


if __name__ == '__main__':
    head = ListNode(1, 1, 1, 2, 3)
    print Solution().deleteDuplicates(head)
