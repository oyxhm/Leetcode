"""
Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def minDepth(self, root):
        if not root:
            return 0

        self.__min_depth = 2 ** 31

        def __minDepth(root, depth):
            if not root.left and not root.right:
                self.__min_depth = min(depth, self.__min_depth)
            if root.left:
                __minDepth(root.left, depth + 1)
            if root.right:
                __minDepth(root.right, depth + 1)

        __minDepth(root, 1)
        return self.__min_depth


if __name__ == '__main__':
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n1.left = n2
    n1.right = n3
    print Solution().minDepth(n1)