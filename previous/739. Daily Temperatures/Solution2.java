class Solution2 {
    public int[] dailyTemperatures(int[] T) {
        return dailyTemperatures2(T);
    }
    
    /*
    method 2:
    Runtime: 4 ms, faster than 95.48% of Java online submissions for Daily Temperatures.
    Memory Usage: 42 MB, less than 94.92% of Java online submissions for Daily Temperatures.
    */
    private int[] dailyTemperatures2(int[] T) {
        int[] stack = new int[T.length];
        int[] ret = new int[T.length];
        int size = 0;
        
        for(int i = 0; i < T.length; i++)
        {
            if(size == 0 || (size > 0 && T[i] <= T[stack[size-1]]))
                stack[size++] = i;
            else if(T[i] > T[stack[size-1]])
            {
                while(size > 0 && T[i] > T[stack[size-1]])
                {
                    ret[stack[size-1]] = i - stack[size-1];
                    size--;
                }
                stack[size++] = i;
            }
        }
        
        return ret;
    }
    
    
    
   
    
}
