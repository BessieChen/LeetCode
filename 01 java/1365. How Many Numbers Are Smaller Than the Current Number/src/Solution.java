import java.util.Arrays;

/**
 * @program: 1365. How Many Numbers Are Smaller Than the Current Number
 * @description: https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/
 * @author: Bessie
 * @create: 2020-03-11 10:12
 **/
public class Solution {
//    Runtime: 1 ms, faster than 99.67% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
//    Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] ret = new int[nums.length];
        int[] map = new int[101];
        for(int i : nums)
        {
            map[i] += 1;
        }
        for(int i = 1 ; i < map.length; i ++)
        {
            map[i] += map[i-1];
        }
        for(int i = 0; i < ret.length; i++)
        {
            if(nums[i] != 0)
                ret[i] = map[nums[i] - 1];
        }
        return ret;
    }

//    Runtime: 1 ms, faster than 99.67% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
//    Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
    public int[] smallerNumbersThanCurrent2(int[] nums) {
        int[] ret = new int[nums.length];
        int[] map = new int[101];
        int max = -1;
        for(int i : nums)
        {
            map[i] += 1;
            max = i > max ? i : max;
        }
        for(int i = 1 ; i <= max; i ++)
        {
            map[i] += map[i-1];
        }
        for(int i = 0; i < ret.length; i++)
        {
            if(nums[i] != 0)
                ret[i] = map[nums[i] - 1];
        }
        return ret;
    }

//    Runtime: 4 ms, faster than 63.66% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
//    Memory Usage: 41.8 MB, less than 100.00% of Java online submissions for How Many Numbers Are Smaller Than the Current Number.
    public int[] smallerNumbersThanCurrent3(int[] nums) {
        int[] numsCopy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(numsCopy);
        int[] ret = new int[nums.length];
        for(int i = 0; i < ret.length; i++)
        {
            ret[i] = binary_search(numsCopy, nums[i]);
        }
        return ret;
    }

    private int binary_search(int[] numsCopy, int num) {
        int l = 0;
        int r = numsCopy.length - 1;
        while(l < r)
        {
            int mid = l + (r - l)/2;
            if(numsCopy[mid] >= num)
            {
                r = mid;
            }
            else
            {
                l = mid + 1;
            }
        }
        //return l - 1;
        return l;
    }



    public static void main(String[] args)
    {
        int[] input = new int[]{8,1,2,2,3};
        int[] output = new Solution().smallerNumbersThanCurrent(input);
        for(int i : output)
        {
            System.out.print(i);
        }
        System.out.println();
        int[] output2 = new Solution().smallerNumbersThanCurrent2(input);
        for(int i : output2)
        {
            System.out.print(i);
        }
        System.out.println();
        int[] output3 = new Solution().smallerNumbersThanCurrent3(input);
        for(int i : output3)
        {
            System.out.print(i);
        }
    }
}
