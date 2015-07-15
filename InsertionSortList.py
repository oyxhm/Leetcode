# encoding: utf-8
"""
Sort a linked list using insertion sort.
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {ListNode}
    def insertionSortList(self, head):
        # Time Limit Exceeded
        dummy_head = ListNode(0)
        cur = head
        while cur:
            next = cur.next
            p = dummy_head
            while p.next and p.next.val < cur.val:
                p = p.next
            temp = p.next
            p.next = cur
            cur.next = temp
            cur = next
        return dummy_head.next

    def insertionSortList2(self, head):
        if not head:
            return head
        dummy_head = ListNode(0)
        dummy_head.next = head
        cur = head
        while cur.next:
            if cur.next.val >= cur.val:  # 如果链表升序，cur就向后移动
                cur = cur.next
            else:
                p = dummy_head
                while p.next.val < cur.next.val:
                    p = p.next
                temp = cur.next
                cur.next = temp.next
                temp.next = p.next
                p.next = temp
        return dummy_head.next


if __name__ == '__main__':
    n1 = ListNode(10, 9, 8, 7, 6, 5, 4)
    print Solution().insertionSortList2(n1)
