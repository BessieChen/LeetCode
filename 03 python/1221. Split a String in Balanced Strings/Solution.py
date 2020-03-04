from itertools import accumulate as acc
class Solution:
    '''Runtime: 32 ms, faster than 29.08% of Python3 online submissions for Split a String in Balanced Strings.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Split a String in Balanced Strings.'''
    def balancedStringSplit2(self, s: str) -> int:
        cnt = 0
        ret = 0
        for c in s:
            cnt += 1 if c == 'R' else -1
            ret += 1 if cnt == 0 else 0
        return ret

    '''Runtime: 32 ms, faster than 29.08% of Python3 online submissions for Split a String in Balanced Strings.
        Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Split a String in Balanced Strings.'''
    def balancedStringSplit(self, s: str) -> int:
        return list(acc(-1 if c == 'L' else 1 for c in s)).count(0)

    '''Runtime: 28 ms, faster than 68.26% of Python3 online submissions for Split a String in Balanced Strings.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Split a String in Balanced Strings.'''
    def balancedStringSplit3(self, s: str) -> int:
        return list(acc(map(" L".find, s))).count(0)#stringS = " L"; stringS.find(c); for c in s. #TODO

    '''Runtime: 24 ms, faster than 89.47% of Python3 online submissions for Split a String in Balanced Strings.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Split a String in Balanced Strings.'''
    def balancedStringSplit4(self, s: str) -> int:
        return list(acc(map({'R': -1, 'L': 1}.get, s))).count(0)


if __name__ == "__main__":
    s = "RLRRLLRLRL"
    t = "LLLLRRRR"

    print("s, #1:", Solution().balancedStringSplit(s))
    print("t, #1:", Solution().balancedStringSplit(t))
    print("s, #2:", Solution().balancedStringSplit2(s))
    print("t, #2:", Solution().balancedStringSplit2(t))
    print("s, #3:", Solution().balancedStringSplit3(s))
    print("t, #3:", Solution().balancedStringSplit3(t))
    print("s, #4:", Solution().balancedStringSplit4(s))
    print("t, #4:", Solution().balancedStringSplit4(t))