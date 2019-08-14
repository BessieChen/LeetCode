class Solution2 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
         return nextGreaterElement1(nums1, nums2);
    }
    
     
    /*
    method 3:
    Runtime: 2 ms, faster than 96.87% of Java online submissions for Next Greater Element I.
    Memory Usage: 37.2 MB, less than 100.00% of Java online submissions for Next Greater Element I.
    */
    private int[] nextGreaterElement3(int[] nums1, int[] nums2) {
        int[] stack = new int[nums2.length];
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(size == 0 || (size > 0 && nums2[i] <= stack[size-1]))
            {
                stack[size++] = nums2[i];
            }
            else if(nums2[i] > stack[size-1])
            {
                while(size > 0 && nums2[i] > stack[size-1])
                {
                    map.put(stack[size-1], nums2[i]);
                    size--;
                }
                stack[size++] = nums2[i];
            }
        }
        
        for(int i = 0; i < nums1.length; i++)
        {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
    
    /*
    method 2:
    Runtime: 2 ms, faster than 96.87% of Java online submissions for Next Greater Element I.
    Memory Usage: 37.6 MB, less than 96.30% of Java online submissions for Next Greater Element I.
    */
    private int[] nextGreaterElement2(int[] nums1, int[] nums2) {
        int[] stack = new int[nums2.length];
        int size = 0;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(size == 0 || (size > 0 && nums2[i] <= nums2[stack[size-1]]))
            {
                stack[size++] = i;
            }
            else if(nums2[i] > nums2[stack[size-1]])
            {
                while(size > 0 && nums2[i] > nums2[stack[size-1]])
                {
                    map.put(nums2[stack[size-1]], nums2[i]);
                    size--;
                }
                stack[size++] = i;
            }
        }
        
        for(int i = 0; i < nums1.length; i++)
        {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        
        return nums1;
    }
    
     /*
    method 1:
    Runtime: 7 ms, faster than 11.60% of Java online submissions for Next Greater Element I.
    Memory Usage: 36.6 MB, less than 100.00% of Java online submissions for Next Greater Element I.
    */
    private int[] nextGreaterElement1(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] ret2 = new int[nums2.length];
        int[] ret1 = new int[nums1.length];
        
        for(int i = 0; i < nums2.length; i++)
        {
            if(stack.empty() || (!stack.empty() && nums2[i] <= nums2[stack.peek()])) //note: <=
            {
                stack.push(i);
            }
            else if(nums2[i] > nums2[stack.peek()])
            {
                while(!stack.empty() && nums2[i] > nums2[stack.peek()])
                {
                    ret2[stack.peek()] = nums2[i];
                    stack.pop();
                }
                stack.push(i);
            }
        }
        
        for(int i = 0 ; i < ret1.length; i++)
        {
            for(int j = 0; j < ret2.length; j++)
            {
                if(nums2[j] == nums1[i])
                {
                    ret1[i] = ret2[j];
                }
            }
            if(ret1[i] == 0) ret1[i] = -1;
        }
        return ret1;
    }
    
}

