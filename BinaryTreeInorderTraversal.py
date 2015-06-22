"""
Given a binary tree, return the inorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [1,3,2].

Note: Recursive solution is trivial, could you do it iteratively?
"""
from TreeNode import TreeNode


class Solution:

    # @param {TreeNode} root
    # @return {integer[]}
    def inorderTraversal(self, root):

        self.__traversal = list()

        def __inorderTraversal(root):
            if not root:
                return
            __inorderTraversal(root.left)
            self.__traversal.append(root.val)
            __inorderTraversal(root.right)

        __inorderTraversal(root)
        return self.__traversal

    def inorderTraversalBFS(self, root):
        stack = list()
        res = list()
        if not root:
            return res
        while stack or root:
            if root:
                stack.append(root)
                root = root.left
            else:
                root = stack.pop()
                res.append(root.val)
                root = root.right
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
    assert s.inorderTraversalBFS(n1) == [8, 4, 2, 5, 1, 6, 3, 7]
