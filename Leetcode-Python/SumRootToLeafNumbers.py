"""
Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

An example is the root-to-leaf path 1->2->3 which represents the number 123.

Find the total sum of all root-to-leaf numbers.

For example,

    1
   / \
  2   3
The root-to-leaf path 1->2 represents the number 12.
The root-to-leaf path 1->3 represents the number 13.

Return the sum = 12 + 13 = 25.
"""
from TreeNode import TreeNode


class Solution:
    # @param {TreeNode} root
    # @return {integer}
    def sumNumbers(self, root):
        self.__sum = 0
        if not root:
            return self.__sum

        def __list_to_int(l):
            base = 1
            ret = 0
            for num in reversed(l):
                ret += base * num
                base *= 10
            return ret

        def __sumNumbers(cur, root):
            cur.append(root.val)
            if not root.left and not root.right:
                self.__sum += __list_to_int(cur)
                return
            if root.left:
                __sumNumbers(list(cur), root.left)
            if root.right:
                __sumNumbers(list(cur), root.right)

        # def __sumNumbers2(sum, root):
        #     if not root:
        #         return 0
        #     sum = sum * 10 + root.val
        #     if not root.left and not root.right:
        #         return sum
        #     return __sumNumbers2(sum, root.left) + __sumNumbers2(sum, root.right)
        #
        #
        # return __sumNumbers2(0, root)

        __sumNumbers([], root)
        return self.__sum


if __name__ == '__main__':
    n1 = TreeNode(1)
    n2 = TreeNode(2)
    n3 = TreeNode(3)
    n4 = TreeNode(4)
    n1.left = n2
    n1.right = n3
    n2.left = n4

    print Solution().sumNumbers(n1)
