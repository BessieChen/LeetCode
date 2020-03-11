import bisect
from typing import List

class Solution:
    '''Runtime: 52 ms, faster than 86.22% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent(self, nums: List[int]) -> List[int]:
        sortedNums = sorted(nums)
        return [bisect.bisect_left(sortedNums, n) for n in nums]

    '''Runtime: 80 ms, faster than 52.68% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent2(self, nums: List[int]) -> List[int]:
        sortedNums = sorted(nums)
        return [sortedNums.index(n) for n in nums]

    # def smallerNumbersThanCurrent3(self, nums: List[int]) -> List[int]:
    #     sortedNums = sorted(nums)
    #     return list(map(lambda x,y: bisect.bisect_left(x, y), sortedNums, nums))

    '''Runtime: 56 ms, faster than 69.48% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent3(self, nums: List[int]) -> List[int]:
        sortedNums = sorted(nums)
        return list(map(lambda x: bisect.bisect_left(sortedNums, x), nums))

    # def smallerNumbersThanCurrent4(self, nums: List[int]) -> List[int]:
    #     sortedNums = sorted(nums)
    #     return list(map(bisect.bisect_left(sortedNums), nums))

    '''Runtime: 68 ms, faster than 57.68% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.9 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent5(self, nums: List[int]) -> List[int]:
        sortedNums = sorted(nums)
        return list(map(sortedNums.index, nums))

    '''Runtime: 52 ms, faster than 86.22% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent6(self, nums: List[int]) -> List[int]:
        return list(map((lambda nums_sorted: lambda num: bisect.bisect_left(nums_sorted, num))(sorted(nums)), nums))

    '''Runtime: 44 ms, faster than 98.87% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent7(self, nums: List[int]) -> List[int]:
        map = [0]*102
        for i in nums:
            map[i+1] += 1
        for i in range(1,102):
            map[i] += map[i-1]
        ret = [0]*len(nums)
        for i in range(len(nums)):
            ret[i] = map[nums[i]]
        return ret

    '''Runtime: 56 ms, faster than 69.48% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent8(self, nums: List[int]) -> List[int]:
        map = [0]*102
        for i in nums:
            map[i+1] += 1
        for i in range(1,102):
            map[i] += map[i-1]
        return [map[num] for num in nums]

    '''Runtime: 52 ms, faster than 86.22% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.
    Memory Usage: 12.9 MB, less than 100.00% of Python3 online submissions for How Many Numbers Are Smaller Than the Current Number.'''
    def smallerNumbersThanCurrent9(self, nums: List[int]) -> List[int]:
        dict = {}
        for ind, num in enumerate(sorted(nums)):
            dict.setdefault(num, ind)
        return [dict[n] for n in nums]


if __name__ == "__main__":
    #input = list([8,1,2,2,3])
    #input = list([6,5,4,8])
    input = list([7,7,7,7])
    print("#1:",Solution().smallerNumbersThanCurrent(input))
    print("#2:", Solution().smallerNumbersThanCurrent2(input))
    print("#3:", Solution().smallerNumbersThanCurrent3(input))
    #print("#4:", Solution().smallerNumbersThanCurrent4(input))
    print("#5:", Solution().smallerNumbersThanCurrent5(input))
    print("#6:", Solution().smallerNumbersThanCurrent6(input))
    print("#7:", Solution().smallerNumbersThanCurrent7(input))
    print("#8:", Solution().smallerNumbersThanCurrent8(input))
    print("#9:", Solution().smallerNumbersThanCurrent9(input))

