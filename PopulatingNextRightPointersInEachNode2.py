"""
Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
"""
from TreeLinkNode import TreeLinkNode


class Solution:
    # @param root, a tree link node
    # @return nothing
    def connect(self, root):
        # BFS
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
            for _ in xrange(size - 1):
                cur = queue.pop(0)
                pre.next = cur
                pre = cur
                if cur.left:
                    queue.append(cur.left)
                if cur.right:
                    queue.append(cur.right)

    def connectDFS(self, root):
        if root:
            root_next = root.next
            while root_next and not root_next.left and not root_next.right:
                root_next = root_next.next
            if root.left:
                root.left.next = root.right or ((root_next.left or root_next.right) if root_next else None)
            if root.right:
                root.right.next = (root_next.left or root_next.right) if root_next else None
            self.connectDFS(root.right)
            self.connectDFS(root.left)


if __name__ == '__main__':
    n1 = TreeLinkNode(2)
    n2 = TreeLinkNode(1)
    n3 = TreeLinkNode(3)
    n4 = TreeLinkNode(0)
    n5 = TreeLinkNode(7)
    n6 = TreeLinkNode(9)
    n7 = TreeLinkNode(1)
    n8 = TreeLinkNode(2)
    n9 = TreeLinkNode(1)
    n10 = TreeLinkNode(0)
    n11 = TreeLinkNode(8)
    n12 = TreeLinkNode(8)
    n13 = TreeLinkNode(7)

    n1.left = n2
    n1.right = n3
    n2.left = n4
    n2.right = n5
    n3.left = n6
    n3.right = n7
    n4.left = n8
    n5.left = n9
    n5.right = n10
    n7.left = n11
    n7.right = n12
    n9.left = n13

    s = Solution()
    s.connectDFS(n1)
    a = 1
