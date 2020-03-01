//#https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
#include <algorithm>
#include <iostream>
#include <iterator>
#include <vector>

using namespace std;

class Solution {
public:
    /*
    Runtime: 20 ms, faster than 62.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 10.3 MB, less than 100.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    */
    // Brute Force: O(mn) - check if negative
    int countNegatives(vector<vector<int>>& grid) {
        int cnt = 0;
        for(std::vector<int> &row : grid)
        {
            for(int e : row)
            {
                if(e < 0)
                    cnt++;
            }
        }
        return cnt;
    }

    /*
    Runtime: 20 ms, faster than 62.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 10.3 MB, less than 100.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.*/
    // Search Break Points: O(m + n) - traverse from lower left to upper right
    int countNegatives1(vector<vector<int>>& grid) {
        //犯错：1. int r = a - 1; 不是 int r = a;
        // 2. cnt += b - c; 不是 cnt = b - c;
        int cnt = 0;

        int a = grid.size();
        int b = grid[0].size();

        int r = a - 1;
        int c = 0;
        while(r >= 0 && c <= b - 1)
        {
            if(grid[r][c] < 0)
            {
                cnt += b - c;
                r--;
            }
            else
                c++;
        }
        return cnt;
    }

    /*
    Runtime: 20 ms, faster than 62.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 10.2 MB, less than 100.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    */
    // Search Break Points: O(m + n) - traverse from upper right to lower left
    int countNegatives2(vector<vector<int>>& grid) {
        //犯错：c--; r++；所属if语句反了
        int cnt = 0;
        int a(grid.size()), b(grid[0].size()), r(0), c(b-1);
        while(r <= a - 1 && c >= 0)
        {
            if(grid[r][c] < 0)
            {
                //std::cout<<a-r<<" ";
                cnt += a - r;
                c--;
            }
            else
            {
                r++;
            }
        }
        return cnt;
    }

    /*
    Runtime: 20 ms, faster than 61.56% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 10.4 MB, less than 100.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
    */
    // Binary Search: O(m lg(n)) or equivalently O(n lg(m)) - look for break point of each row / column
    int countNegatives3(vector<vector<int>>& grid) {
        int ret = 0;
        for(const vector<int>& row : grid)
        {
            ret += upper_bound(row.rbegin(), row.rend(), -1) - row.rbegin();
        }
        return ret;
    }

    /*
   Runtime: 20 ms, faster than 61.56% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
   Memory Usage: 10.3 MB, less than 100.00% of C++ online submissions for Count Negative Numbers in a Sorted Matrix.
   */
    // Binary Search: O(m lg(n)) or equivalently O(n lg(m)) - look for break point of each row / column
    int countNegatives4(vector<vector<int>>& grid) {
        int ret = 0;
        for(const vector<int>& row : grid)
        {
            ret += lower_bound(row.rbegin(), row.rend(), 0) - row.rbegin();
        }
        return ret;
    }

    int printIndex(vector<vector<int>> grid)
    {
        vector<int>& row = grid[0];
        int ret = upper_bound(row.rbegin(), row.rend(), -1) - row.rbegin();
        return ret;
    }
};

int main()
{
    vector<vector<int>> input = {{4,3,2,-1},
                                 {3,2,1,-1},
                                 {1,1,-1,-2},
                                 {-1,-1,-2,-3}};
    int ret = Solution().countNegatives(input);
    cout<<"Answer is "<<ret<<endl;

    vector<vector<int>> test_print = {{-1,0,3,2}};
    int ret2 = Solution().printIndex(test_print);
    cout<<"print is "<<ret2<<" ";

}

/*
 * others: https://en.cppreference.com/w/cpp/algorithm/upper_bound
 * https://www.cnblogs.com/Tang-tangt/p/9291018.html
 * https://www.cnblogs.com/cobbliu/archive/2012/05/21/2512249.html
 * https://blog.csdn.net/kjing/article/details/6936325
 *
 * */