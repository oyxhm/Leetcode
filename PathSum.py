"""
Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along
the path equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \      \
        7    2      1
return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @param {integer} sum
    # @return {boolean}
    def hasPathSum(self, root, sum):

        def __hasPathSum(root, cur):
            if not root:
                return False
            cur += root.val
            if not root.left and not root.right:
                return cur == sum
            return __hasPathSum(root.left, cur) or __hasPathSum(root.right, cur)

        return __hasPathSum(root, 0)


if __name__ == '__main__':
    n1 = TreeNode(5)
    n2 = TreeNode(4)
    n3 = TreeNode(8)
    n4 = TreeNode(11)
    n5 = TreeNode(13)
    n6 = TreeNode(4)
    n7 = TreeNode(7)
    n8 = TreeNode(2)
    n9 = TreeNode(1)

    n1.left = n2
    n1.right = n3
    n2.left = n4
    n3.left = n5
    n3.right = n6
    n4.left = n7
    n4.right = n8
    n6.right = n9

    print Solution().hasPathSum(n1, 22)
