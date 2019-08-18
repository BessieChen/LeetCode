class Solution {

    public int removeElement(int[] nums, int val) {
        return removeElement3(nums, val);
    }
    
  
    public int removeElement3(int[] nums, int val) {
        int ret = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != val) nums[ret++] = nums[i];
        }
        return ret;
    }
    
 
    public int removeElement4(int[] nums, int val) {
        int size = 0;
        int len = nums.length;
        for(int i = 0; i <= len - (size+1) ; i++)
        {
            while(nums[i] == val && i <= len - (size+1))
            {
                nums[i] = nums[len - ++size];
            }      
        }
        return len-size;
    }

    
   
    public int removeElement1(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
    
    
  
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
