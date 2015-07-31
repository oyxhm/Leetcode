import apple.laf.JRSUIUtils;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yhf on 15/5/27.
 */

/*
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


一定要先right再left，如以下这种情况：
               1
             /   \
           2      3
         /  \    / \
        4    5  6   7
      /    /  \    / \
     8    9   10  11 12
             /
           13

   若先处理左子树，root为5时，6.next = 7 这一步还没处理到，rootNext无法变成7，所以10无法连接到11
*/

public class PopulatingNextRightPointersInEachNode2 {
    public static void connect(TreeLinkNode root) {
        // BFS, Time Limit Exceeded, 我傻逼了......
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        while (!queue.isEmpty()) {
            int size = queue.size();
            int i = 0;
            TreeLinkNode pre = queue.remove();
            i++;
            enqueue(queue, pre);
            while (i < size && pre == null) {
                pre = queue.remove();
                i++;
                enqueue(queue, pre);
            }  // now pre is the first not null node on this level
            if (i == size) {
                break;  // on this level, level is all NULL
            }
            while (i < size) {
                TreeLinkNode node = queue.remove();
                i++;
                enqueue(queue, node);
                while (i < size && node == null) {
                    node = queue.remove();
                    i++;
                    enqueue(queue, node);
                }
                pre.next = node;
                pre = node;
            }
            if (pre != null) {   // in case of pre is the first and the only not null node on this level
                pre.next = null;
            }
        }
    }

    private static void enqueue(Queue<TreeLinkNode> queue, TreeLinkNode root) {
        if (root == null) {
            queue.add(null);
            queue.add(null);
        } else {
            queue.add(root.left);
            queue.add(root.right);
        }
    }

    public static void connect3(TreeLinkNode root) {
        // BFS
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
            }
            if (pre.right != null) {
                q.add(pre.right);
            }
            for (int i = 1; i < size; i++) {
                TreeLinkNode node = q.remove();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
                pre.next = node;
                pre = node;
            }
        }
    }

    public static void connect2(TreeLinkNode root) {
        // DFS
        if (root == null) {
            return;
        }

        TreeLinkNode rootNext = root.next;
        while (rootNext != null && rootNext.left == null && rootNext.right == null) {
            rootNext = rootNext.next;
        }
        if (root.left != null) {
            if (root.right != null) {
                root.left.next = root.right;
            }
        }
        if (root.right != null) {
            if (rootNext != null) {
                root.right.next = (rootNext.left != null) ? rootNext.left : rootNext.right;
            }
        } else {
            if (rootNext != null && root.left != null) {
                root.left.next = (rootNext.left != null) ? rootNext.left : rootNext.right;
            }
        }

        connect2(root.right);
        connect2(root.left);
    }

    public static void main(String[] args) {
        TreeLinkNode n1 = new TreeLinkNode(1);
        TreeLinkNode n2 = new TreeLinkNode(2);
        TreeLinkNode n3 = new TreeLinkNode(3);
        TreeLinkNode n4 = new TreeLinkNode(4);
        TreeLinkNode n5 = new TreeLinkNode(5);
        TreeLinkNode n6 = new TreeLinkNode(6);
        TreeLinkNode n7 = new TreeLinkNode(7);
        TreeLinkNode n8 = new TreeLinkNode(8);
        TreeLinkNode n9 = new TreeLinkNode(9);
        TreeLinkNode n10 = new TreeLinkNode(10);
        TreeLinkNode n11 = new TreeLinkNode(11);
        TreeLinkNode n12 = new TreeLinkNode(12);
        TreeLinkNode n13 = new TreeLinkNode(13);

        n1.left = n2;
//        n1.right = n3;
//        n2.left = n4;
//        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n5.left = n9;
        n5.right = n10;
        n7.left = n11;
        n7.right = n12;
        n10.left = n13;

        connect3(n1);
    }
}
