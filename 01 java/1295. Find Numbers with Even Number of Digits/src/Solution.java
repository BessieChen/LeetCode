/**
 * @program: 1295. Find Numbers with Even Number of Digits
 * @description: https://leetcode.com/problems/find-numbers-with-even-number-of-digits/
 * @author: Bessie
 * @create: 2020-03-04 13:55
 **/

/*
* Constraints:
1 <= nums.length <= 500
1 <= nums[i] <= 10^5
* */
public class Solution {
//    Runtime: 1 ms, faster than 94.24% of Java online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 38.8 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
    public int findNumbers(int[] nums) {
        int ret = 0;
        for(int i : nums){
            if((i >= 10 && i <= 99) | (i >= 1000 && i <= 9999) | i == 100000)
                ret++;
        }
        return ret;
    }

//    Runtime: 1 ms, faster than 94.24% of Java online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 41.5 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
    public int findNumbers2(int[] nums) {
        int ret = 0;
        for(int i : nums)
        {
            ret += Integer.toString(i).length() % 2 == 0 ? 1 : 0;
        }
        return ret;
    }

//    Runtime: 1 ms, faster than 94.24% of Java online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 40.9 MB, less than 100.00% of Java online submissions for Find Numbers with Even Number of Digits.
    public int findNumbers3(int[] nums) {
        int ret = 0;
        for(int i : nums)
        {
            ret += 1 - Integer.toString(i).length() % 2 ;//注意不是Integer.toString(i).length() % 2 - 1;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        int[] n1 = new int[]{12,345,2,6,7896,100000};
        int[] n2 = new int[]{555,901,482,1771};
        System.out.println("n1, #1: " + new Solution().findNumbers(n1));
        System.out.println("n2, #1: " + new Solution().findNumbers(n2));
        System.out.println("----------");
        System.out.println("n1, #2: " + new Solution().findNumbers2(n1));
        System.out.println("n2, #2: " + new Solution().findNumbers2(n2));
        System.out.println("----------");
        System.out.println("n1, #3: " + new Solution().findNumbers3(n1));
        System.out.println("n2, #3: " + new Solution().findNumbers3(n2));
    }
}
