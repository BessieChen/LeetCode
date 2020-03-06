class Solution:
    '''Runtime: 28 ms, faster than 69.82% of Python3 online submissions for Jewels and Stones.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Jewels and Stones.'''
    def numJewelsInStones(self, J: str, S: str) -> int:
        return sum([s in J for s in S])
        #return sum(s in J for s in S)

    '''Runtime: 32 ms, faster than 31.94% of Python3 online submissions for Jewels and Stones.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Jewels and Stones.'''
    def numJewelsInStones2(self, J: str, S: str) -> int:
        return sum(list(map(J.count, S)))
        #return sum(map(J.count, S))

    '''Runtime: 16 ms, faster than 99.58% of Python3 online submissions for Jewels and Stones.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Jewels and Stones.'''
    def numJewelsInStones3(self, J: str, S: str) -> int:
        return sum(list(map(S.count, J)))
        #return sum(map(S.count, J))

if __name__ == "__main__":
    J = "Aa"
    S = "aAAbbbb"#3
    print("#1:", Solution().numJewelsInStones(J, S))
    print("#2:", Solution().numJewelsInStones2(J, S))
    print("#3:", Solution().numJewelsInStones3(J, S))