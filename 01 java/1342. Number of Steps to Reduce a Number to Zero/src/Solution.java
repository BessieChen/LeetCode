/**
 * @program: 1342. Number of Steps to Reduce a Number to Zero
 * @description: https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
 * @author: Bessie
 * @create: 2020-03-03 08:19
 **/
public class Solution {

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
    public int numberOfSteps(int num) {
        int ret = 0;
        while(num > 0)
        {
            if(num % 2 == 0)
            {
                num /= 2;
            }
            else
            {
                num -= 1;
            }
            ret++;
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 36.7 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
    public int numberOfSteps2(int num) {
        int ret = 0;
        while(num > 0)
        {
            if((num & 1) == 1)
                num &= ~1;
            else
                num = num >> 1;
            ret++;
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Number of Steps to Reduce a Number to Zero.
    public int numberOfSteps3(int num) {
        int ret = 0;
        while(num > 0)
        {
            ret += (num & 1) == 1? 2 : 1;
            num >>= 1;
        }
        return ret - 1;
    }

    public static void main(String[] args)
    {
        int input = 14;
        System.out.println("#1: " + new Solution().numberOfSteps(input));
        System.out.println("#2: " + new Solution().numberOfSteps2(input));
        System.out.println("#3: " + new Solution().numberOfSteps3(input));
    }
}


