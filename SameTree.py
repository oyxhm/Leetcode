"""
Given two binary trees, write a function to check if they are equal or not.

Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} p
    # @param {TreeNode} q
    # @return {boolean}
    def isSameTree(self, p, q):
        if not p and not q:
            return True
        if p and not q or not p and q or p.val != q.val:
            return False
        return self.isSameTree(p.left, q.left) and self.isSameTree(p.right, q.right)


if __name__ == '__main__':
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n5 = TreeNode(5)
    n6 = TreeNode(6)
    n7 = TreeNode(7)
    n8 = TreeNode(8)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = n7
    n4.left = n8

    m1 = TreeNode(1)
    m2 = TreeNode(2)
    m3 = TreeNode(3)
    m4 = TreeNode(4)
    m5 = TreeNode(5)
    m6 = TreeNode(6)
    m7 = TreeNode(7)
    m8 = TreeNode(8)
    m1.left = m2
    m1.right = m3
    m2.left = m4
    m2.right = m5
    m3.left = m6
    m3.right = m7
    m4.left = m8

    s = Solution()
    assert s.isSameTree(m1, n1) is True
    assert s.isSameTree(m1, n2) is False
