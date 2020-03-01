#https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
import bisect

class Solution(object):
    # Runtime: 104 ms, faster than 75.33% of Python online submissions for Count Negative Numbers in a Sorted Matrix.
    # Memory Usage: 12.9 MB, less than 100.00% of Python online submissions for Count Negative Numbers in a Sorted Matrix.
    def countNegatives3(self, Grid):
        return sum(a < 0 for r in Grid for a in r)

    def countNegatives2(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        return sum(bisect.bisect_left(type('', (), {'__getitem__': lambda _, i: r[~i]})(), 0, 0, len(r)) for r in grid)

    # Runtime: 112 ms, faster than 26.00% of Python online submissions for Count Negative Numbers in a Sorted Matrix.
    # Memory Usage: 12.9 MB, less than 100.00% of Python online submissions for Count Negative Numbers in a Sorted Matrix.
    def countNegatives(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        return sum(
            bisect.bisect_right(type('', (), {'__getitem__': lambda _, i: r[~i]})(), -1, 0, len(r)) for r in grid)

def intToString(input):
    if input is None:
        input = 0
    return str(input)

if __name__ == '__main__':
    # 创建对象Solution
    input = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    print(type(input))
    ret = Solution().countNegatives2(input)
    print(ret)

'''
good comment: https://www.cnblogs.com/skydesign/archive/2011/09/02/2163592.html
https://docs.python.org/3/library/bisect.html
https://docs.python.org/zh-tw/3/library/bisect.html
'''
# PyCharm下解决Unresolved Reference问题
# 原创morven936 最后发布于2018-01-31 12:49:25 阅读数 32545  收藏
# 展开
# 在开发过程，特别是clone项目时在PyCharm中经常出现Unresolved Reference问题，对于有强迫症的人来说，简直不可忍受。
#
# 1. 进入PyCharm->Preferences->Build,Excution,Deployment->Console->Python Console勾选上Add source roots to PYTHONPATH;
# 2. 进入PyCharm->Preferences->Project->Project Structure,通过选中某一目录右键添加sources;
# 3. 点击Apply和OK即可.
# ————————————————
# 版权声明：本文为CSDN博主「morven936」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
# 原文链接：https://blog.csdn.net/haiyanggeng/article/details/79215819

'''
python3:
class Solution:
    # Runtime: 128 ms, faster than 59.71% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    # Memory Usage: 14 MB, less than 100.00% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    def countNegatives2(self, grid: List[List[int]]) -> int:
        return sum(a < 0 for r in grid for a in r)

    # Runtime: 136 ms, faster than 18.55% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    # Memory Usage: 13.8 MB, less than 100.00% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    def countNegatives1(self, grid: List[List[int]]) -> int:
        return sum(bisect.bisect_left(type('', (), {'__getitem__': lambda _, i: r[~i]})(), 0, 0, len(r)) for r in grid)

    # Runtime: 132 ms, faster than 34.05% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    # Memory Usage: 13.9 MB, less than 100.00% of Python3 online submissions for Count Negative Numbers in a Sorted Matrix.
    def countNegatives(self, grid: List[List[int]]) -> int:
        return sum(
            bisect.bisect_right(type('', (), {'__getitem__': lambda _, i: r[~i]})(), -1, 0, len(r)) for r in grid)
'''