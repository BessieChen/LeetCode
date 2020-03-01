class Solution {
    public int[] dailyTemperatures(int[] T) {
        return dailyTemperatures1(T);
    }
    
    /*
    method 1:
    Runtime: 69 ms, faster than 24.67% of Java online submissions for Daily Temperatures.
    Memory Usage: 42.2 MB, less than 94.92% of Java online submissions for Daily Temperatures.
    */
    private int[] dailyTemperatures1(int[] T) {
        Stack<Integer> stack = new Stack<>();
        int[] ret = new int[T.length];
        
        for(int i = 0; i < T.length; i++)
        {
            if(stack.empty() || (!stack.empty() && T[i] <= T[stack.peek()])) //note: <=
                stack.push(i);//no: T[i];
            else if(T[i] > T[stack.peek()])
            {
                while(!stack.empty() && T[i] > T[stack.peek()])//note
                {
                    ret[stack.peek()] = i - stack.peek();
                    stack.pop();
                }
                stack.push(i);
            }
        }
        return ret;
    }
    
    
   
    
}
