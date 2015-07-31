"""
Sort a linked list in O(n log n) time using constant space complexity.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def sortList(self, head):
        if not head or not head.next:
            return head
        fast = slow = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        new_head = slow.next
        slow.next = None
        head1 = self.sortList(head)
        head2 = self.sortList(new_head)
        return self.merge_lists(head1, head2)

    def merge_lists(self, head1, head2):
        if not head1 or not head2:
            return head1 or head2
        dummy_head = cur = ListNode(0)
        while head1 and head2:
            if head1.val <= head2.val:
                cur.next = head1
                head1 = head1.next
            else:
                cur.next = head2
                head2 = head2.next
            cur = cur.next
        if head1 or head2:
            cur.next = head1 or head2
        return dummy_head.next


if __name__ == '__main__':
    print Solution().sortList(ListNode(5, 4, 3, 2, 1))
