package src.main;

/**
 * Created by yhf on 8/25/15.
 */

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        String ret = "[";
        ListNode cur = this;
        while (cur != null) {
            ret += cur.val + " ";
            cur = cur.next;
        }
        ret += ret.substring(0, ret.length() - 1) + "]";
        return ret;
    }
}
