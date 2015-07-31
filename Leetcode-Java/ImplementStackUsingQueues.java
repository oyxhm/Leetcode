import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yhf on 15/6/12.
 */

/*
Implement the following operations of a stack using queues.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
empty() -- Return whether the stack is empty.

Notes:
You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is
empty operations are valid.
Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
(double-ended queue), as long as you use only standard operations of a queue.
You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
*/


class MyStack {

    private Queue<Integer> q = new LinkedList<>();
    private Queue<Integer> temp = new LinkedList<>();

    // Push element x onto stack.
    public void push(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            temp.add(q.remove());
        }
        q = new LinkedList<>(temp);
        temp.clear();
    }

    // Get the top element.
    public int top() {
        int size = q.size();
        for (int i = 0; i < size - 1; i++) {
            temp.add(q.remove());
        }
        int ret = q.remove();
        temp.add(ret);
        q = new LinkedList<>(temp);
        temp.clear();
        return ret;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }

    public void print() {
        for (int x : q) {
            System.out.print(x + " ");
        }
        System.out.println();
    }
}


public class ImplementStackUsingQueues {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        System.out.println(s.empty());
        s.push(1);
        s.push(2);
        System.out.println(s.empty());
        s.push(3);
        s.pop();
        s.print();
        System.out.println(s.top());
    }
}


