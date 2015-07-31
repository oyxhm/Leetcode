"""
Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

push(x) -- Push element x onto stack.
pop() -- Removes the element on top of the stack.
top() -- Get the top element.
getMin() -- Retrieve the minimum element in the stack.
"""


class MinStack:
    # initialize your data structure here.
    def __init__(self):
        self._stack = []
        self._mins = []

    # @param x, an integer
    # @return nothing
    def push(self, x):
        self._stack.append(x)
        if self._mins:
            self._mins.append(min(self._mins[-1], x))
        else:
            self._mins.append(x)

    # @return nothing
    def pop(self):
        self._stack.pop()
        self._mins.pop()

    # @return an integer
    def top(self):
        return self._stack[-1]

    # @return an integer
    def getMin(self):
        return self._mins[-1]


if __name__ == '__main__':
    ms = MinStack()
    ms.push(3)
    ms.push(4)
    print ms.getMin()
    ms.push(10)
    print ms.getMin()
    ms.push(1)
    print ms.getMin()
    ms.pop()
    print ms.getMin()
