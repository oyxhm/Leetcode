"""
Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
"""


class Solution:
    # @param {integer[]} nums
    # @return {string[]}
    def summaryRanges(self, nums):
        res = []
        if not nums:
            return res
        pre = 0
        for idx, num in enumerate(nums):
            if idx == 0 or num == nums[idx-1] + 1:
                continue
            else:
                if pre == idx - 1:
                    res.append(str(nums[pre]))
                else:
                    res.append("%s->%s" % (nums[pre], nums[idx-1]))
                pre = idx
        if pre == idx:
            res.append(str(nums[pre]))
        else:
            res.append("%s->%s" % (nums[pre], nums[idx]))
        return res


if __name__ == '__main__':
    print Solution().summaryRanges([0, 1, 2, 4, 5, 7, 8])
