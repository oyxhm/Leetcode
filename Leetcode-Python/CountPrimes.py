"""
Count the number of prime numbers less than a non-negative number, n.
"""


class Solution:
    # @param {integer} n
    # @return {integer}
    def countPrimes(self, n):
        is_prime = [False, False] + [True] * (n - 2)
        i = 2
        while i * i < n:
            if is_prime[i]:
                for j in xrange(i*i, n, i):
                    is_prime[j] = False
            i += 1
        return len(filter(lambda x: x, is_prime))
