"""
Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example,
1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.

Hint:

The naive approach is to call isUgly for every number until you reach the nth one. Most
numbers are not ugly. Try to focus your effort on generating only the ugly ones.
An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
The key is how to maintain the order of the ugly numbers. Try a similar approach of
merging from three sorted lists: L1, L2, and L3.

Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
"""


class Solution(object):
    def nthUglyNumber(self, n):
        """
        :type n: int
        :rtype: int
        """
        queue2, queue3, queue5 = [2], [3], [5]
        num = 1
        for _ in xrange(n - 1):
            if min(queue2[0], queue3[0], queue5[0]) == queue2[0]:
                num = queue2.pop(0)
                queue2.append(num * 2)
                queue3.append(num * 3)
                queue5.append(num * 5)
            elif min(queue2[0], queue3[0], queue5[0]) == queue3[0]:
                num = queue3.pop(0)
                queue3.append(num * 3)
                queue5.append(num * 5)
            else:
                num = queue5.pop(0)
                queue5.append(num * 5)
        return num


if __name__ == '__main__':
    print Solution().nthUglyNumber(1)
