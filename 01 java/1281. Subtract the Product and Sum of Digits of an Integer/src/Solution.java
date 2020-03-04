/**
 * @program: 1281. Subtract the Product and Sum of Digits of an Integer
 * @description: https://leetcode.com/problems/subtract-the-product-and-sum-of-digits-of-an-integer/
 * @author: Bessie
 * @create: 2020-03-04 11:41
 **/
public class Solution {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
//    Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Subtract the Product and Sum of Digits of an Integer.
    public int subtractProductAndSum(int n) {
        int prod = 1;
        int sum = 0;
        while(n > 0)
        {
            int rem = n % 10;
            prod *= rem;
            sum += rem;
            n /= 10;
        }
        return prod - sum;
    }

    public static void main(String[] args)
    {
        //constraint: 1 <= n <= 10^5
        int n1 = 234;//15
        int n2 = 4421;//21
        System.out.println("n1, #1: "+ new Solution().subtractProductAndSum(n1));
        System.out.println("n2, #1: "+ new Solution().subtractProductAndSum(n2));
    }
}
