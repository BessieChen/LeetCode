import java.util.Stack;

public class Solution {
    public int[] nextGreaterElements(int[] nums) {

        /*
        我的想法：
        和以前很像，那就是如果找到Next Greater Element的元素就从stack里面pop出来
        如果没有就push进去。

        这里和以前不一样的是，以前在stack中剩余的元素，那就是找不到NGE的。也就是说，后面的数字都比自己小。
        例如：
        [1,6,8,5,7,2,4,3]
        可以看出stack中会剩余8,7,4因为以他们为起点的后续序列都是没他们大的。
        所以这道题需要的就是如何处理剩余的stack中元素。

        于是，我的想法：
        从头开始寻找。
        你可以发现6比4大，所以4从stack中pop出来，然后再检查7
        检查7的时候，就不是从头开始了。而是从6开始，为什么呢？
        因为之前stack剩余的，就已经保证了是8,7,4是降序的。所以7一定大于4
        又因为4一定大于开头元素1，所以7一定大于1.
        所以我们只需要从6开始判断。

        不过需要注意的是如果stack只剩一个元素的时候，这个元素一定是原始数组nums中最大的。它一定对应着-1.

        */

        Stack<Integer> stack = new Stack<>();

        //遍历nums，要么pop，要么push进stack。注意进入出来的是arr的index，而不是arr的内容。
        //Note：之所以是pop进去index是因为我们for loop遍历index比较容易。然后ret[xx]中xx也不是按从0-(size-1)的顺序来找到答案的。
        int[] ret = new int[nums.length];
        if(nums.length == 0)
            return ret;

        for(int i = 0; i < nums.length; i++)
        {
            while(!stack.empty() && nums[stack.peek()] < nums[i])
            {
                ret[stack.pop()] = nums[i];
            }
            stack.push(i);
        }

        for(int i = 0; i < nums.length; i++)
        {
            while(stack.size() >= 2 && nums[stack.peek()] < nums[i])
            {
                ret[stack.pop()] = nums[i];
            }
        }

        //走到这里stack可以只剩一个元素，也可以剩余许多个。
        while(!stack.empty())
        {
            ret[stack.pop()] = -1;
        }

        return ret;
    }
}
