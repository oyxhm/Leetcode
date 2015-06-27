"""
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
"""
from TreeNode import TreeNode


class BSTIterator:
    # @param root, a binary search tree's root node
    def __init__(self, root):
        self.__stack = []
        while root:
            self.__stack.append(root)
            root = root.left


    # @return a boolean, whether we have a next smallest number
    def hasNext(self):
        return len(self.__stack) != 0


    # @return an integer, the next smallest number
    def next(self):
        ret = self.__stack.pop()
        if ret.right:
            node = ret.right
            while node:
                self.__stack.append(node)
                node = node.left
        return ret.val


# Your BSTIterator will be called like this:
# i, v = BSTIterator(root), []
# while i.hasNext(): v.append(i.next())
