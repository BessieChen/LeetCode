import java.util.Stack;

/*
Runtime: 52 ms, faster than 51.66% of Java online submissions for Daily Temperatures.
Memory Usage: 42.9 MB, less than 81.35% of Java online submissions for Daily Temperatures.
* */
public class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];

        for(int i = 0; i < T.length; i++)
        {
            while(!stack.empty() && T[stack.peek()] < T[i])
            {
                ret[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);//所以走到这里的就是：1.stack为空 2.刚刚pop掉最后匹配的，然后push进本轮的index。
        }

        return ret;
    }
}
