# https://leetcode.com/problems/decompress-run-length-encoded-list/
class Solution(object):

    '''Runtime: 56 ms, faster than 70.95% of Python online submissions for Decompress Run-Length Encoded List.
    Memory Usage: 12 MB, less than 100.00% of Python online submissions for Decompress Run-Length Encoded List.'''
    def decompressRLElist(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        length = len(nums)
        ret = []
        for i in range(0, length, 2):
            ret += nums[i] * [nums[i+1]] #: output would be [4, 4, 4, 2, 5, 5, 5, 5]
            #ret.extend(nums[i] * [nums[i+1]]) #: output would be [4, 4, 4, 2, 5, 5, 5, 5]
            #ret.append(nums[i] * [nums[i+1]])#: output would be[[4, 4, 4], [2], [5, 5, 5, 5]]

        return ret

    '''Runtime: 56 ms, faster than 70.95% of Python online submissions for Decompress Run-Length Encoded List.
    Memory Usage: 12.1 MB, less than 100.00% of Python online submissions for Decompress Run-Length Encoded List.'''
    def decompressRLElist2(self, nums):
        return [nums[i*2+1] for i in range( (int)(len(nums)/2) ) for _ in range(nums[i*2]) ] #expected int, got float instead.

    '''Runtime: 52 ms, faster than 88.68% of Python online submissions for Decompress Run-Length Encoded List.
    Memory Usage: 12 MB, less than 100.00% of Python online submissions for Decompress Run-Length Encoded List.'''
    def decompressRLElist3(self, nums):
        return [nums[i+1] for i in range(0, len(nums), 2) for _ in range(nums[i])]

    # def decompressRLElist4(self, nums):#ret.append(nums[i] * [nums[i+1]])#: output would be[[4, 4, 4], [2], [5, 5, 5, 5]], so we need solution 5th below which uses sum to concatenate.
    #     return [  nums[i]*[ nums[i + 1] ] for i in range(0, len(nums), 2)  ]

    '''Runtime: 56 ms, faster than 70.95% of Python online submissions for Decompress Run-Length Encoded List.
    Memory Usage: 12 MB, less than 100.00% of Python online submissions for Decompress Run-Length Encoded List.'''
    def decompressRLElist5(self, nums):
        return sum([nums[i] * [nums[i + 1]] for i in range(0, len(nums), 2)], [])

    '''Runtime: 64 ms, faster than 27.18% of Python online submissions for Decompress Run-Length Encoded List.
    Memory Usage: 12.1 MB, less than 100.00% of Python online submissions for Decompress Run-Length Encoded List.'''
    def decompressRLElist6(self, nums):
        ret = []
        for i in range(0, len(nums), 2):
            for j in range(nums[i]):
                ret.append(nums[i+1])
        return ret


def main():
    input = [3,4,1,2,4,5]

    ret = Solution().decompressRLElist(input)
    print(ret)

    ret2 = Solution().decompressRLElist2(input)
    print(ret2)

    ret3 = Solution().decompressRLElist3(input)
    print(ret3)

    ret4 = Solution().decompressRLElist4(input)
    print(ret4)

    ret5 = Solution().decompressRLElist5(input)
    print(ret5)

    ret6 = Solution().decompressRLElist6(input)
    print(ret6)

if __name__ == "__main__":
    main()


'''
https://leetcode.com/problems/decompress-run-length-encoded-list/discuss/478426/Python-3-(one-line)-(beats-100)
Interesting, I didn't know that "sum" works that way.

From the man page:
sum(iterable[, start])
Sums start and the items of an iterable from left to right and returns the total. start defaults to 0.

reply:
Yes. When you are summing the numbers in a list, 
you usually want to initiate the running total with 0. 
That way you get the sum of all the numbers in the list.
 
 If you want to sum a list of lists[[4, 4, 4], [2], [5, 5, 5, 5]],
  that is concatenate them, 
  then you will usually want to initiate the concatenation with the empty list [ ]. 
  Python will always use a default start value of 0 
  which is not appropriate when you are concatenating lists 
  since you cannot do 0 + [[4, 4, 4], [2], [5, 5, 5, 5]]. 
  In this case we have to explicitly designate start to be [ ].
'''