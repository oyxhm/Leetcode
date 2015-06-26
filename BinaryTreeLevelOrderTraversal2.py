"""
Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by
level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its bottom-up level order traversal as:
[
  [15,7],
  [9,20],
  [3]
]
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer[][]}
    def levelOrderBottom(self, root):
        if not root:
            return []
        queue = [root]
        res = []
        while queue:
            level = map(lambda n: n.val, list(queue))
            res.append(level)
            size = len(queue)
            for _ in xrange(size):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return list(reversed(res))


if __name__ == '__main__':
    n1 = TreeNode(1)
    print Solution().levelOrderBottom(n1)
