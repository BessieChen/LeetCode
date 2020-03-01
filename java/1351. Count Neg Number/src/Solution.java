/**
 * @program: 1351. Count Neg Number
 * @description: https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/submissions/
 * @author: Bessie
 * @create: 2020-02-26 15:01
 **/
class Solution {
    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 41.4 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.*/
    public int countNegatives(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        int res = 0, lastNeg = cols - 1;
        for (int row = 0; row < rows; row++) {
            //check edge cases - if first element is < 0 - all elements in row are negative
            if (grid[row][0] < 0) {
                res+=cols;
                continue;
            }
            //if last element is positive - it means there are no negative numbers in a row
            if (grid[row][cols - 1] > 0)
                continue;
            //there is a mix of negative and positive ones, need to find the border. starting
            //binary search
            int l = 0, r = lastNeg;
            while (l <= r) {
                int m = l + (r - l)/2;
                if (grid[row][m] < 0) {
                    r = m - 1;
                } else
                    l = m + 1;
            }
            //l points to the first negative element, which means cols - l is a number of
            //such elements
            res += (cols - l); lastNeg = l;
        }
        return res;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    */
    public int countNegatives_bessie(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        int ret = 0;

        int row = 0;
        int firstNeg = b-1;
        while(row <= a-1 && firstNeg >= 0)
        {
            if(grid[row][0] <= -1)
            {
                ret += b;
                row++;
                continue;
            }

            if(grid[row][b-1] >= 0)
            {
                row++;
                continue;
            }

            int l = 0;
            int r = firstNeg;
            while(l <= r)
            {
                int m = l + (r-l)/2;
                if(grid[row][m] <= -1)
                {
                    r = m - 1;
                }
                else
                {
                    l = m + 1;
                }
            }
            //最后的结局：一定是l == r + 1, 这个l就是所有-1中最左边的那个
            ret += b - l;
            firstNeg = l;
            row++;
        }
        return ret;
    }

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    Memory Usage: 41.6 MB, less than 100.00% of Java online submissions for Count Negative Numbers in a Sorted Matrix.
    */
    public int countNegatives_bessie2(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;

        int ret = 0;

        int row = a - 1;
        int col = 0;

        if(grid[0][0] <= -1 )
            return a*b;
        if(grid[a-1][b-1] >= 0)
            return 0;

        int firstNeg = a-1;
        while(row >= 0 && col <= b-1)
        {
            if(grid[0][col] <= -1)
            {
                ret += a;
                col++;
                continue;
            }

            if(grid[a-1][col] >= 0)
            {
                col++;
                continue;
            }

            int up = 0;
            int down = firstNeg;

            while(up <= down)
            {
                int m = up +(down - up)/2;
                if(grid[m][col] <= -1)
                {
                    down = m - 1;
                }
                else
                {
                    up = m + 1;
                }
            }

            ret += a - up;
            firstNeg = up;
            col++;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        int[][] input = new int[][]{{4,3,2,-1},
                                    {3,2,1,-1},
                                    {1,1,-1,-2},
                                    {-1,-1,-2,-3}};

        Solution m = new Solution();
        int ret = m.countNegatives(input);//should be 8
        System.out.println(ret);

        int ret2 = m.countNegatives_bessie2(input);//should be 8
        System.out.println(ret2);
    }
}