"""
Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192
(represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
"""


class Solution:
    # @param n, an integer
    # @return an integer
    def reverseBits(self, n):
        bits = []
        for _ in xrange(32):
            bits.append(n & 1)
            n >>= 1
        bits.reverse()
        base = 1
        num = 0
        for bit in bits:
            num += base * bit
            base *= 2
        return num

    def reverseBitsOptimized(self, n):

        def __swapBits(num, i, j):
            # swap bits at i and j
            x = (num >> i) & 1
            y = (num >> j) & 1

            if x != y:
                num ^= (1 << i) | (1 << j)
            return num

        for i in xrange(16):
            n = __swapBits(n, i, 31 - i)
        return n


if __name__ == '__main__':
    print Solution().reverseBitsOptimized(43261596)
