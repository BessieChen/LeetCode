import math
from functools import reduce
import operator

class Solution:
    '''Runtime: 28 ms, faster than 60.30% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 12.9 MB, less than 100.00% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.'''
    def subtractProductAndSum(self, n: int) -> int:
        prod = 1
        sum = 0
        while n :
            ret = n % 10
            prod *= ret
            sum += ret
            n //= 10 #TODO这里不能是n /= 10, 否则n就会变成小数，然后while n 永远没有尽头。
            #print(n)
        return prod - sum

    '''Runtime: 16 ms, faster than 99.49% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.'''
    def subtractProductAndSum2(self, n: int) -> int:
        prod = 1
        sum = 0
        while n :
            ret = n % 10
            prod *= ret
            sum += ret
            n = math.floor(n / 10) #TODO这里不能是n /= 10, 否则n就会变成小数，然后while n 永远没有尽头。
            #print(n)
        return prod - sum

    '''Runtime: 24 ms, faster than 85.21% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 12.7 MB, less than 100.00% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.'''
    def subtractProductAndSum3(self, n: int) -> int:
        s = str(n).replace('','*')
        s = s[1:-1]
        t = str(n).replace('','+')
        t = t[1:-1]
        prod = eval(s)
        sum = eval(t)
        return prod - sum

    '''
    #return eval(str(n).replace('', '*')[1:-1])-eval(str(n).replace('', '+')[1:-1])
    # say,
    n = 234
    n = str(n).replace('', '*') # --- > n = "*2*3*4*"
    n = n[1:-1] # --- > n = "2*3*4"
    n = eval(n) # --- > n = 2*3*4
    '''

    '''Runtime: 16 ms, faster than 99.49% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 12.9 MB, less than 100.00% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.'''
    def subtractProductAndSum4(self, n: int) -> int:
        A = list(map(int, str(n)))#int('1')
        return reduce(lambda x, y : x * y , A) - reduce(lambda x, y : x + y , A)

    '''Runtime: 24 ms, faster than 85.21% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Subtract the Product and Sum of Digits of an Integer.'''
    def subtractProductAndSum5(self, n: int) -> int:
        A = list(map(int, str(n)))
        return reduce(operator.mul , A) - reduce(operator.add , A)


if __name__ == "__main__":
    n1 = 234
    n2 = 4421
    print("n1, #1:", Solution().subtractProductAndSum(n1))
    print("n2, #1:", Solution().subtractProductAndSum(n2))
    print("----------")
    print("n1, #2:", Solution().subtractProductAndSum2(n1))
    print("n2, #2:", Solution().subtractProductAndSum2(n2))
    print("----------")
    print("n1, #3:", Solution().subtractProductAndSum3(n1))
    print("n2, #3:", Solution().subtractProductAndSum3(n2))
    print("----------")
    print("n1, #4:", Solution().subtractProductAndSum4(n1))
    print("n2, #4:", Solution().subtractProductAndSum4(n2))
    print("----------")
    print("n1, #5:", Solution().subtractProductAndSum5(n1))
    print("n2, #5:", Solution().subtractProductAndSum5(n2))