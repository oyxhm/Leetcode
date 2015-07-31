"""
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be
set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
"""
from TreeLinkNode import TreeLinkNode


class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        if root:
            if root.left:
                root.left.next = root.right
            if root.right and root.next:
                root.right.next = root.next.left
            self.connect(root.left)
            self.connect(root.right)

    def connectBFS(self, root):
        if not root:
            return
        queue = [root]
        while queue:
            size = len(queue)
            pre = queue.pop(0)
            if pre.left:
                queue.append(pre.left)
            if pre.right:
                queue.append(pre.right)
            for i in xrange(1, size):
                cur = queue.pop(0)
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)
                pre.next = cur
                pre = cur


if __name__ == '__main__':
    n1 = TreeLinkNode(1)
    n2 = TreeLinkNode(2)
    n3 = TreeLinkNode(3)
    n4 = TreeLinkNode(4)
    n5 = TreeLinkNode(5)
    n6 = TreeLinkNode(6)
    n7 = TreeLinkNode(7)
    n8 = TreeLinkNode(8)
    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = n7
    n4.left = n8

    s = Solution()
    s.connectBFS(n1)
