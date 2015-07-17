"""
>>> heap = Heap(3, 2, 3, 1, 2, 4, 5, 5, 6, 7, 7, 8, 2, 3, 1, 1, 10, 11)
>>> heap
[11, 10, 7, 8, 6, 4, 3, 5, 7, 2, 5, 3, 2, 3, 1, 1, 1, 2]
>>> len(heap)
18

>>> heap.insert(10, 6, 20)
>>> heap
[20, 11, 7, 10, 10, 4, 3, 5, 8, 6, 5, 3, 2, 3, 1, 1, 1, 2, 7, 2, 6]

>>> heap.heapsort()
[1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 10, 10, 11, 20]

>>> heap.delete_max()
20

>>> heap.delete(2)
>>> heap.heapsort()
[1, 1, 1, 2, 2, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 10, 10, 11]

>>> heap.delete_all(2)
>>> heap.heapsort()
[1, 1, 1, 3, 3, 3, 4, 5, 5, 6, 6, 7, 7, 8, 10, 10, 11]
"""
import doctest


class Heap(object):
    """ Max-Heap
    """

    def __init__(self, *nums):
        self.heap = list()  # max-heap
        for num in nums:
            self.insert(num)

    def __str__(self):
        return str(self.heap)

    def __repr__(self):
        return self.__str__()

    def __len__(self):
        return len(self.heap)

    def insert(self, *nums):
        for num in nums:
            self.heap.append(num)
            index = len(self.heap) - 1
            self.__swim(index)

    def __swim(self, index):
        """ bottom-up the num at index
        """
        num = self.heap[index]
        cur = index
        while cur > 0:
            p = (cur - 1) / 2  # parent
            if num > self.heap[p]:
                self.heap[cur] = self.heap[p]
                cur = p
            else:
                break
        self.heap[cur] = num

    def delete(self, num):
        """ removes first occurrence of num
        """
        try:
            index = self.heap.index(num)
        except:
            raise ValueError('Heap.delete(x): x not in heap')
        self.heap[index] = self.heap[-1]
        self.heap.pop()
        if index < len(self.heap):
            self.__sink(index)

    def delete_all(self, num):
        """removes all num in the heap
        """
        while num in self.heap:
            self.delete(num)

    def delete_max(self):
        """ removes and returns the max element
        """
        if self.heap:
            ret = self.heap[0]
            self.heap[0] = self.heap[-1]
            self.heap.pop()
            if self.heap:
                self.__sink(0)
            return ret
        else:
            raise IndexError('Delete max from empty heap')

    def __sink(self, index):
        """ top-down the num at index
        """
        num = self.heap[index]
        cur = index
        child = cur * 2 + 1  # left child
        while child < len(self.heap):
            if child + 1 < len(self.heap) and self.heap[child] < self.heap[child+1]:
                child += 1
            if num < self.heap[child]:
                self.heap[cur] = self.heap[child]
                cur = child
                child = cur * 2 + 1
            else:
                break
        self.heap[cur] = num

    def heapsort(self):
        res = []
        temp = list(self.heap)
        while self.heap:
            res.insert(0, self.delete_max())
        self.heap = temp
        return res


if __name__ == '__main__':
    doctest.testmod()
