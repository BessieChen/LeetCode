import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        /*
        我的想法：
        那就是先不管nums1，直接处理nums2
        如果nums2中如果某个数字eg.1存在下一个Next Greater Element，eg.99，那么就存入HashMap(1,99)
        如果某个数字eg.100不存在Next Greater Element，那就留在Stack中，也不存入HashMap。
        
        之后再找nums1，如果nums1的数字在HashMap的keySet中，那就对应存HashMap中的value
        如果nums1的某个数不存在HashMap的keySet中，那就对应-1

        然后关于nums的size：
        锤子，你忘了吗？java就可以直接用nums.length!!

        todo 这里关键胜在了HashMap的getOrDefault函数！就是找不到key就是默认-1
        */

        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int num2 : nums2)
        {
            while(!stack.empty() && stack.peek() < num2)
            {
                map.put(stack.pop(), num2);
            }
            stack.push(num2);
        }

        int[] ret = new int[nums1.length];
        for(int i = 0; i < ret.length; i++)
        {
            ret[i] = map.getOrDefault(nums1[i], -1);
        }

        return ret;
    }
}