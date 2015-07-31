# encoding: utf-8
"""
Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].
"""


class Solution:
    # @param {integer[]} nums
    # @return {integer[][]}
    def permuteUnique(self, nums):
        # DFS
        len_nums = len(nums)
        res = list()

        def __permuteUnique(nums, idx):
            if idx == len_nums - 1:
                res.append(list(nums))
                return
            for i in xrange(idx, len_nums):
                if not __contains_duplicates(nums, idx, i):
                    nums[i], nums[idx] = nums[idx], nums[i]
                    __permuteUnique(nums, idx+1)
                    nums[i], nums[idx] = nums[idx], nums[i]

        def __contains_duplicates(nums, start, end):
            return nums[end] in nums[start:end]

        __permuteUnique(nums, 0)
        return res

    def permuteUnique2(self, nums):
        # DFS
        """
        http://blog.csdn.net/linhuanmars/article/details/21570835

        对于重复的元素循环时跳过递归函数的调用，只对第一个未被使用的进行递归，我们那么这一次结果会出现在第一个的递归函数
        结果中，而后面重复的会被略过。如果第一个重复元素前面的元素还没在当前结果中，那么我们不需要进行递归。首先我们要对
        元素集合排序，从而让重复元素相邻，接下来就是一行代码对于重复元素和前面元素使用情况的判断即可。

        每次都从0 - len遍历一遍，找到没used的num，append到cur上去。如果与前一个相同，并且前一个没用的话，这个也先不用，
        等前一个先用。
        """
        len_nums = len(nums)
        nums.sort()
        res = list()

        def __permuteUnique(cur, used):
            if len(cur) == len_nums:
                res.append(list(cur))
                return

            for i in xrange(len_nums):
                if i > 0 and nums[i] == nums[i-1] and not used[i-1]:  # !!!!这里一定要想清楚，not used[i-1]!!!!
                    continue
                if not used[i]:
                    used[i] = True
                    __permuteUnique(cur+[nums[i]], used)
                    used[i] = False

        __permuteUnique([], [False]*len_nums)
        return res


if __name__ == '__main__':
    print Solution().permuteUnique2([1, 1, 2])
