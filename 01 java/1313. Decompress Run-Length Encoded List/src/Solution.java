import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: 1313. Decompress Run-Length Encoded List
 * @description: https://leetcode.com/problems/decompress-run-length-encoded-list/
 * @author: Bessie
 * @create: 2020-03-01 15:14
 **/
class Solution {
//    Runtime: 1 ms, faster than 98.51% of Java online submissions for Decompress Run-Length Encoded List.
//    Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
    public int[] decompressRLElist(int[] nums) {
        int len = 0;
        for(int i = 0; i <= nums.length - 1; i += 2)
        {
            len += nums[i];
        }
        int[] ret = new int[len];
        int index = 0;
        for(int i = 1; i < nums.length; i += 2)
        {
            for(int j = 0 ; j < nums[i-1]; j++)
            {
                ret[index++] = nums[i];
            }
        }
        return ret;
    }

//    Runtime: 6 ms, faster than 25.60% of Java online submissions for Decompress Run-Length Encoded List.
//    Memory Usage: 41.7 MB, less than 100.00% of Java online submissions for Decompress Run-Length Encoded List.
    public int[] decompressRLElist2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i += 2)
        {
            for(int j = 0; j < nums[i]; j++)
                list.add(nums[i+1]);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args)
    {
        int[] input = new int[]{3,4,5,1};
        int[] ret = new Solution().decompressRLElist(input);
        System.out.println(Arrays.toString(ret));

        int[] ret2 = new Solution().decompressRLElist2(input);
        System.out.println(Arrays.toString(ret2));
    }
}
