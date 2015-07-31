"""
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.
"""
from TreeNode import TreeNode
import SameTree


class Solution:
    # @param {integer[]} inorder
    # @param {integer[]} postorder
    # @return {TreeNode}
    def buildTree(self, inorder, postorder):
        # Memory Limit Exceeded
        if not inorder or not postorder:
            return None
        root_val = postorder[-1]
        root = TreeNode(root_val)
        root_index = inorder.index(root_val)
        root.left = self.buildTree(inorder[:root_index], postorder[:root_index])
        root.right = self.buildTree(inorder[root_index+1:], postorder[root_index:-1])
        return root

    def buildTree2(self, inorder, postorder):

        def __buildTree(i_l, i_r, p_l, p_r):
            if i_l > i_r:
                return None
            root_val = postorder[p_r]
            root = TreeNode(root_val)
            root_index = inorder[i_l:i_r+1].index(root_val)
            root.left = __buildTree(i_l, i_l+root_index-1, p_l, p_l+root_index-1)
            root.right = __buildTree(i_l+root_index+1, i_r, p_l+root_index, p_r-1)
            return root

        return __buildTree(0, len(inorder) - 1, 0, len(postorder) - 1)


if __name__ == '__main__':
    root1 = Solution().buildTree([4,2,5,1,8,6,7,3], [4,5,2,8,6,7,3,1])
    root2 = Solution().buildTree2([4,2,5,1,8,6,7,3], [4,5,2,8,6,7,3,1])
    print SameTree.Solution().isSameTree(root1, root2)