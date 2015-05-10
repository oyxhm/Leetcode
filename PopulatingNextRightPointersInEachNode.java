import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yhf on 15/5/7.
 */

/*
Given a binary tree

    struct TreeLinkNode {
      TreeLinkNode *left;
      TreeLinkNode *right;
      TreeLinkNode *next;
    }
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

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
*/

class TreeLinkNode {
    int val;
    TreeLinkNode left, right, next;
    TreeLinkNode(int x) { val = x; }
}

public class PopulatingNextRightPointersInEachNode {
    public static void connect(TreeLinkNode root) {
        // recursively, DFS
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        connect(root.left);
        connect(root.right);
    }

    public static void connect2(TreeLinkNode root) {
        // iteratively, BFS
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode pre = q.remove();
            if (pre.left != null) {
                q.add(pre.left);
                q.add(pre.right);
            }
            for (int i = 1; i < size; i++) {
                TreeLinkNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                    q.add(node.right);
                }gi
                pre.next = node;
                pre = node;
            }
            pre.next = null;
        }
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        connect2(n1);
    }
}
