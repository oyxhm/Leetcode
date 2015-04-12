/*
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
*/

import java.util.*;

class MinStack {
    private int min = Integer.MAX_VALUE;
    private List<Integer> l = new ArrayList<Integer>();
    private List<Integer> minList = new ArrayList<Integer>();
    private int len = 0, lenMinList = 1;

    MinStack() {
        minList.add(min);        
    }

    public void push(int x) {
        l.add(x);
        len++;
        if (x <= minList.get(lenMinList-1)) {
            minList.add(x);
            lenMinList++;
        }
    }

    public void pop() {
        if (l.get(len-1).intValue() == minList.get(lenMinList-1).intValue()) {
            minList.remove(lenMinList-- - 1);
        }
        l.remove(len-- - 1);
    }

    public int top() {
        return l.get(len-1);
    }

    public int getMin() {
        return minList.get(lenMinList - 1);
    }
}

public class MinStackTest {
    public static void main(String[] args) {
        MinStack s = new MinStack();
        s.push(512);
        s.push(-1024);
        s.push(-1024); 
        s.push(512);
        s.pop();
        s.pop();
        System.out.println(s.getMin());
        s.pop();
        System.out.println(s.getMin());
    }
}