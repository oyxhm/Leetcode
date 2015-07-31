# encoding: utf-8
"""
The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note: Given n will be between 1 and 9 inclusive.

assuming we are going to solve the problem when n = 3 and k = 5.
In fact, because k starts from 1, we need to subtract 1 from it to make it starting from 0. So we are going to find the permutation 4 now.
To calculate the first digit, we can calculate it by k % (n – 1)! = 4 / 2! = 2, which is the position of 3 in array [1,2,3].
Now we need to delete 3 from the array, so the array becomes [1, 2]. And k should become 4 % 2! = 0.
Now we calculate k / (n – 2)! = 0 / 1 = 0, which is the position of 1 in array [1, 2]. So the second digit should be 1.
We need to delete 1 from the array. And there is only one entry left in the array. So the final digit should be 2.
Finally we get the permutation: 312.
"""


class Solution:
    # @param {integer} n
    # @param {integer} k
    # @return {string}
    def getPermutation(self, n, k):
        if n == 1:
            return "1"
        digits = range(1, n+1)
        fac = reduce(lambda x, y: x * y, xrange(1, n))  # fac(n-1)
        sequence = ""
        k -= 1
        while n > 1:
            i = k / fac
            sequence += str(digits[i])
            del digits[i]
            k = k % fac
            fac /= n - 1
            n -= 1
        return sequence + str(digits[0])


if __name__ == '__main__':
    print Solution().getPermutation(3, 3)
