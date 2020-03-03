#https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution(object):

    '''Runtime: 16 ms, faster than 73.91% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    Memory Usage: 12 MB, less than 100.00% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    '''
    def numberOfSteps (self, num):
        """
        :type num: int
        :rtype: int
        """
        ret = 0
        while num:
            if num % 2 == 0:
                num /= 2
            else:
                num -= 1
            ret += 1
        return ret

    '''Runtime: 16 ms, faster than 73.91% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    Memory Usage: 12 MB, less than 100.00% of Python online submissions for Number of Steps to Reduce a Number to Zero.'''
    def numberOfSteps2 (self, num):
        ret = 0
        while num:
            num, ret = num - 1 if num % 2 else num / 2, ret + 1 #python不可以写成if num & 1，因为&在python中不是位与运算：TypeError: unsupported operand type(s) for &: 'float' and 'int'
        return ret

    '''
    Runtime: 20 ms, faster than 36.22% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    Memory Usage: 11.7 MB, less than 100.00% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    '''
    def numberOfSteps3(self, num):
        bits = "{0:b}".format(num)#python3: f'{num:b}'
        return len(bits) - 1 + bits.count('1')

    '''Runtime: 16 ms, faster than 73.91% of Python online submissions for Number of Steps to Reduce a Number to Zero.
    Memory Usage: 11.7 MB, less than 100.00% of Python online submissions for Number of Steps to Reduce a Number to Zero.'''
    def numberOfSteps4(self, num):
        if(num == 0): return 0
        ret = 0
        while num:
            ret += 2 if num & 1 == 1 else 1
            num >>= 1
        return ret - 1



if __name__ == "__main__":
    input = 14
    print("#1: ", Solution().numberOfSteps(input))
    print("#2: ", Solution().numberOfSteps2(input))
    print("#3: ", Solution().numberOfSteps3(input))
    print("#4: ", Solution().numberOfSteps4(input))
