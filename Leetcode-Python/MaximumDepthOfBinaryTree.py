"""
Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
"""


from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def maxDepth(self, root):
        return 0 if not root else max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1


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

    assert Solution().maxDepth(n1) == 4
