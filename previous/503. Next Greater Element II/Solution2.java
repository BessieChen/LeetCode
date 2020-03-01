class Solution2
{
public int[] nextGreaterElements(int[] nums) {
        return nextGreaterElements5(nums);
    }
    /*
    method 1:还是我的最快，其余的都用了Stack，其实用int[] stack就可以了
    Runtime: 2 ms, faster than 100.00% of Java online submissions for Next Greater Element II.
    Memory Usage: 40.7 MB, less than 100.00% of Java online submissions for Next Greater Element II.
    */
    public int[] nextGreaterElements5(int[] nums) {
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        int[] stack = new int[len]; //不会用到格外的空间，因为size + checked == len
        int size = 0;
        int checked = 0;
        
        for(int i = 0; i < len; i++)
        {
            if(size == 0 || (size > 0 && nums[stack[size-1]] >= nums[i]))
                stack[size++] = i;
            else if(nums[stack[size-1]] < nums[i])
            {
                while(size > 0 && nums[stack[size - 1]] < nums[i])
                {
                    ret[stack[size-1]] = nums[i];
                    size--;
                }
                stack[size++] = i;
            }
        }
        
        if(size > 0)
        {
            for(int i = 0; i < len ; i++)
            {
                while(nums[stack[size-1]] < nums[i])//如果是nums[stack[size-1]] >= nums[i], 那么什么都不用做直接i++
                {
                    ret[stack[size-1]] = nums[i];
                    size--;
                }
            }
        }
        
        return ret;
        
    }
    
    
    /*
    method 2:
    Runtime: 32 ms, faster than 55.87% of Java online submissions for Next Greater Element II.
    Memory Usage: 40.6 MB, less than 100.00% of Java online submissions for Next Greater Element II.
    */
    public int[] nextGreaterElements6(int[] nums)
    {
        int len = nums.length;
        int[] nn = new int[len*2];
        for(int i = 0 ; i < len * 2; i++)
        {
            nn[i] = nums[i % len];//易错！不是i % 2,而是 i % len!
        }
              
        int[] ret = new int[len];
        
        for(int i = 0 ; i < len; i++)
        {
            ret[i] = -1;
            for(int j = i + 1; j < len * 2; j++)
            {
                if(nn[i] < nn[j])
                {
                    ret[i] = nn[j];
                    break;
                }
            }
        }
        return ret;
    }
    
    /*
    method 3:
    Runtime: 39 ms, faster than 37.34% of Java online submissions for Next Greater Element II.
    Memory Usage: 42.4 MB, less than 78.57% of Java online submissions for Next Greater Element II.
    */
    public int[] nextGreaterElements7(int[] nums)
    {
        int len = nums.length;
        int[] nn = new int[len*2];
        System.arraycopy(nums, 0, nn, 0, len);//见网页的note，有这个函数的笔记
        System.arraycopy(nums, 0, nn, len, len);        
        
        int[] ret = new int[len];
        
        for(int i = 0 ; i < len; i++)
        {
            ret[i] = -1;
            for(int j = i + 1; j < len * 2; j++)
            {
                if(nn[i] < nn[j])
                {
                    ret[i] = nn[j];
                    break;
                }
            }
        }
        return ret;
    }
}
