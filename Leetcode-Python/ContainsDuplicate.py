"""
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value
appears at least twice in the array, and it should return false if every element is distinct.
"""


class Solution:
    # @param {integer[]} nums
    # @return {boolean}
    def containsDuplicate(self, nums):
        s = set()
        for num in nums:
            if s.__contains__(num):
                return True
            s.add(num)
        return False


if __name__ == '__main__':
    s = Solution()
    assert s.containsDuplicate([1, 2, 2]) == True
    assert s.containsDuplicate([1, 2, 3]) == False

