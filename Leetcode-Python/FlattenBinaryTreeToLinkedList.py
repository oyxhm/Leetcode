"""
Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6

The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6

"""
from TreeNode import TreeNode


class Solution:
    def __init__(self):
        self.__pre = None

    # @param {TreeNode} root
    # @return {void} Do not return anything, modify root in-place instead.
    def flatten(self, root):
        if not root:
            return
        temp = root.right
        if self.__pre:
            self.__pre.left, self.__pre.right = None, root
        self.__pre = root
        self.flatten(root.left)
        self.flatten(temp)

if __name__ == '__main__':
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n5 = TreeNode(5)
    n6 = TreeNode(6)

    n1.left = n2
    # n1.right = n5
    n2.left = n3
    # n2.right = n4
    # n5.right = n6

    head = Solution().flatten(n1)
