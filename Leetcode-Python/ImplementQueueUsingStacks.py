"""
Implement the following operations of a queue using stacks.

push(x) -- Push element x to the back of queue.
pop() -- Removes the element from in front of queue.
peek() -- Get the front element.
empty() -- Return whether the queue is empty.
Notes:
You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size, and is empty
operations are valid.
Depending on your language, stack may not be supported natively. You may simulate a stack by using a list or deque (doub
le-ended queue), as long as you use only standard operations of a stack.
You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).
"""


class Queue:
    # initialize your data structure here.
    def __init__(self):
        self._stack = []
        self._stack_temp = []

    # @param x, an integer
    # @return nothing
    def push(self, x):
        self._stack.append(x)

    # @return nothing
    def pop(self):
        while len(self._stack) > 1:
            self._stack_temp.append(self._stack.pop())
        if len(self._stack) == 1:
            ret = self._stack.pop()
        while self._stack_temp:
            self._stack.append(self._stack_temp.pop())
        return ret

    # @return an integer
    def peek(self):
        while self._stack:
            self._stack_temp.append(self._stack.pop())
        if self._stack_temp:
            ret = self._stack_temp[-1]
        while self._stack_temp:
            self._stack.append(self._stack_temp.pop())
        return ret

    # @return an boolean
    def empty(self):
        return len(self._stack) == 0
