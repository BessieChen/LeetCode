class Solution {
    public int findLengthOfLCIS(int[] nums) {
        return findLengthOfLCIS2(nums);
    }
    
    public int findLengthOfLCIS3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int max = 1;
        int count = 1;
        for(int i = 1 ; i < nums.length; i++)
        {
            if(nums[i-1] < nums[i])
            {
                count++;
                if(max < count) max = count;
            }
            else count = 1;
        }
        return max;
    }
    

    public int findLengthOfLCIS1(int[] nums) {
        int ans = 0, anchor = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i-1] >= nums[i]) anchor = i;
            ans = Math.max(ans, i - anchor + 1);
        }
        return ans;
    }
    

    public int findLengthOfLCIS2(int[] a) {
        int mx = 0;
        for (int i = 0, j = 0; j < a.length; i = (j == 0 || a[j-1] >= a[j]) ? j : i, mx = Math.max(mx, j - i + 1), j++) { }
        return mx;
    
    }
}
