"""
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
"""
from TreeNode import TreeNode


class Solution:
    # @param {ListNode} head
    # @return {TreeNode}
    def sortedListToBST(self, head):
        self.__cur = head

        def __sortedListToBST(low, high):
            if low <= high:
                mid = low + (high - low) / 2
                left = __sortedListToBST(low, mid - 1)
                root = TreeNode(self.__cur.val)
                self.__cur = self.__cur.next
                root.left = left
                root.right = __sortedListToBST(mid + 1, high)
                return root
            else:
                return None

        len = 0
        while head:
            head = head.next
            len += 1
        return __sortedListToBST(0, len - 1)