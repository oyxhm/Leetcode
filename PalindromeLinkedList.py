"""
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
"""
from ListNode import ListNode


class Solution:
    # @param {ListNode} head
    # @return {boolean}
    def isPalindrome(self, head):
        if not head or not head.next:
            return True
        fast = slow = head
        while fast.next and fast.next.next:
            fast = fast.next.next
            slow = slow.next
        mid = slow
        new_head = pre = mid.next
        mid.next = None
        cur = pre.next
        while cur:
            temp = cur.next
            cur.next = pre
            pre = cur
            cur = temp
        new_head.next = None
        while pre and head.val == pre.val:   # 注意这里奇数个数时，左半边长一个
            head = head.next
            pre = pre.next
        return pre is None


if __name__ == '__main__':
    head = ListNode(1, 2, 2, 1)
    print Solution().isPalindrome(head)
