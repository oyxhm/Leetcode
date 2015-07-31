"""
Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see
ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def rightSideView(self, root):
        res = []
        if not root:
            return res
        queue = [root]
        while queue:
            size = len(queue)
            res.append(queue[size-1].val)
            for _ in queue[:size]:
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
        return res

if __name__ == '__main__':
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n5 = TreeNode(5)
    n1.left = n2
    n1.right = n3
    n2.right = n5
    n3.right = n4
    print Solution().rightSideView(n1)
