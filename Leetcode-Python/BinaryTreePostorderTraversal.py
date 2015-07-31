"""
Given a binary tree, return the postorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},
   1
    \
     2
    /
   3
return [3,2,1].

Note: Recursive solution is trivial, could you do it iteratively?
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer[]}
    def postorderTraversal(self, root):

        self.__traversal = []

        def __postorderTraversal(root):
            if not root:
                return
            __postorderTraversal(root.left)
            __postorderTraversal(root.right)
            self.__traversal.append(root.val)

        __postorderTraversal(root)
        return self.__traversal

    def postorderTraversalBFS(self, root):
        res = []
        if not root:
            return res
        stack = [root]
        prev = None
        while stack:
            cur = stack[-1]
            if not prev or prev.left == cur or prev.right == cur:  # going down
                if cur.left:
                    stack.append(cur.left)
                elif cur.right:
                    stack.append(cur.right)
                else:
                    res.append(stack.pop().val)
            elif prev == cur.left:                                 # going up from left child
                if cur.right:
                    stack.append(cur.right)
                else:
                    res.append(stack.pop().val)
            else:                                                  # going up from right child
                res.append(stack.pop().val)
            prev = cur

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
    assert s.postorderTraversal(n1) == [8, 4, 5, 2, 6, 7, 3, 1]