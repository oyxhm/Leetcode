"""
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
"""
from TreeNode import TreeNode


class Solution:

    # @param {TreeNode} root
    # @return {integer[]}
    def preorderTraversal(self, root):
        self.__traversal = list()

        def __preorderTraversal(root):
            if not root:
                return
            self.__traversal.append(root.val)
            __preorderTraversal(root.left)
            __preorderTraversal(root.right)

        __preorderTraversal(root)
        return self.__traversal


    def preorderTraversalBFS(self, root):
        stack = []
        res = []
        if not root:
            return res
        stack.append(root)
        while stack:
            node = stack.pop()
            res.append(node.val)
            if node.right:
                stack.append(node.right)
            if node.left:
                stack.append(node.left)
        return res


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

    s = Solution()
    assert s.preorderTraversal(n1) == [1, 2, 4, 8, 5, 3, 6, 7]
