from typing import List
import math

class Solution:
    '''Runtime: 52 ms, faster than 75.18% of Python3 online submissions for Find Numbers with Even Number of Digits.
    Memory Usage: 12.7 MB, less than 100.00% of Python3 online submissions for Find Numbers with Even Number of Digits.'''
    def findNumbers(self, nums:List[int]) -> int:
        return sum([(int)(math.log10(i)+1)&1 == 0 for i in nums])

    '''Runtime: 52 ms, faster than 75.18% of Python3 online submissions for Find Numbers with Even Number of Digits.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Find Numbers with Even Number of Digits.'''
    def findNumbers2(self, nums:List[int]) -> int:
        return sum([len(str(i))&1 == 0 for i in nums])

    # def findNumbers3(self, nums: List[int]) -> int:
    #     return len([x if len(str(x)) % 2 == 0 else x for x in nums])

    '''Runtime: 52 ms, faster than 75.18% of Python3 online submissions for Find Numbers with Even Number of Digits.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Find Numbers with Even Number of Digits.'''
    def findNumbers3(self, nums: List[int]) -> int:
        return len([x for x in nums if len(str(x)) % 2 == 0])

    def findNumbers4(self, nums: List[int]) -> int:
        ret = 0
        for i in nums:
            if len(str(i)) % 2 == 0 :
                ret += 1
        return ret

if __name__ == "__main__":
    l1 = list((100, 2))#0
    l2 = list((12,345,2,6,7896,100000))#3

    print("l1, #1:", Solution().findNumbers(l1))
    print("l2, #1:", Solution().findNumbers(l2))
    print("----------")
    print("l1, #2:", Solution().findNumbers2(l1))
    print("l2, #2:", Solution().findNumbers2(l2))
    print("----------")
    print("l1, #3:", Solution().findNumbers3(l1))
    print("l2, #3:", Solution().findNumbers3(l2))
    print("----------")
    print("l1, #4:", Solution().findNumbers4(l1))
    print("l2, #4:", Solution().findNumbers4(l2))