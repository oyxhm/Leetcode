#encoding: utf-8
"""
Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.

Note:
You may assume k is always valid, 1 ≤ k ≤ BST's total elements.

Follow up:
What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently? How would
you optimize the kthSmallest routine?
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @param {integer} k
    # @return {integer}
    def kthSmallest(self, root, k):
        traversal = []
        self.count = 0

        def __traverse(root):
            if not root:
                return
            __traverse(root.left)
            traversal.append(root.val)
            self.count += 1
            if self.count == k:
                self._ret = root.val
            __traverse(root.right)

        __traverse(root)
        return self._ret


if __name__ == '__main__':
    n1 = TreeNode(10)
    n2 = TreeNode(5)
    n3 = TreeNode(15)
    n4 = TreeNode(2)
    n5 = TreeNode(8)
    n6 = TreeNode(1)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n4.left = n6

    print Solution().kthSmallest(n1, 4)
