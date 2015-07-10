"""
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @param {integer} sum
    # @return {integer[][]}
    def pathSum(self, root, sum):
        res = []

        def __pathSum(root, cur_sum, cur):
            if not root:
                return
            cur_sum += root.val
            if cur_sum == sum and not root.left and not root.right:
                res.append(cur+[root.val])
                return
            __pathSum(root.left, cur_sum, cur+[root.val])
            __pathSum(root.right, cur_sum, cur+[root.val])

        __pathSum(root, 0, [])
        return res

if __name__ == '__main__':
    n1 = TreeNode(-2)
    n2 = TreeNode(4)
    n3 = TreeNode(-3)
    n4 = TreeNode(11)
    n5 = TreeNode(13)
    n6 = TreeNode(4)
    n7 = TreeNode(7)
    n8 = TreeNode(2)
    n9 = TreeNode(5)
    n10 = TreeNode(1)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n3.left = n5
    n3.right = n6
    n4.left = n7
    n4.right = n8
    n6.left = n9
    n6.right = n10
    print Solution().pathSum(n1, 22)
