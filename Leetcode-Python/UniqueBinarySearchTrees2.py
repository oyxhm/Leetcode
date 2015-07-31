"""
Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
"""
from TreeNode import TreeNode


class Solution:
    # @param {integer} n
    # @return {TreeNode[]}
    def generateTrees(self, n):

        def __generateTrees(left, right):
            res = []
            if left > right:
                return [None]
            else:
                for mid in xrange(left, right + 1):
                    for left_child in __generateTrees(left, mid - 1):
                        for right_child in __generateTrees(mid + 1, right):
                            root = TreeNode(mid)
                            root.left = left_child
                            root.right = right_child
                            res.append(root)
                return res

        return __generateTrees(1, n)

if __name__ == "__main__":
    roots = Solution().generateTrees(3)
