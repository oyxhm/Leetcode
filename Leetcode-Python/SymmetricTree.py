"""
Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.
"""


class Solution:
    # @param {TreeNode} root
    # @return {boolean}
    def isSymmetric(self, root):
        return self.__isSymmetric(root.left, root.right) if root else True

    def __isSymmetric(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        return left.val == right.val and\
               self.__isSymmetric(left.left, right.right) and self.__isSymmetric(left.right, right.left)

    def isSymmetricBFS(self, root):
        if not root:
            return True
        lq = [root.left]
        rq = [root.right]
        while lq or rq:
            left = lq.pop(0)
            right = rq.pop(0)
            if not left and not right:
                continue
            if not left or not right or left.val != right.val:
                return False
            lq += [left.left, left.right]
            rq += [right.right, right.left]
        return True