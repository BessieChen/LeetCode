class Solution2 {
    public int[] intersect(int[] nums1, int[] nums2) {
        return intersect8(nums1, nums2);
    }
   
    public int[] intersect8(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length) return intersect8(nums2, nums1);
        
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int l = 0;
        int r = nums2.length-1;
        for(int i = 0; i < nums1.length; )
        {
            
            int check = -1;
            check = bs(nums2, nums1[i], l, r);
            if(check != -1)
            {
                list.add(nums1[i]);
                i++;
                l = check + 1;
            }
            else
            {
                i++;
            }
        }
        
        
        int[] res = new int[list.size()];
        for(int k = 0; k < res.length; k++){
            res[k] = list.get(k);
        }
        return res;
        
    }
    
    public int bs(int[] nums2, int target, int l, int r)
    {
        int oldL = l;
        while(l < r)
        {
            int m = l + (r - l)/2;
            if(nums2[m] >= target)
            {
                r = m-1;
            }
            else if(nums2[m] < target)
            {
                l = m+1;
            }
        }
        if(r >= oldL && nums2[r] == target) return r;
        else if(r+1 <= nums2.length-1 && nums2[r+1] == target) return r+1;
        else return -1;
    }
    
   
    public int[] intersect7(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        
        int i = 0;
        int j = 0;
        
        while(i < nums1.length && j < nums2.length)
        {
            while(i < nums1.length && j < nums2.length && nums1[i] == nums2[j])
            {
                list.add(nums1[i]);
                i++;
                j++;
            }
            
            if(i < nums1.length && j < nums2.length && nums1[i] < nums2[j] )
            {
                i++;
            }
            else if(i < nums1.length && j < nums2.length && nums1[i] > nums2[j] )
            {
                j++;
            }
        }
        
        Iterator iter = list.iterator();
        int[] ret = new int[list.size()];
        int size = 0;
        while(iter.hasNext())
        {
            ret[size++] = (int)iter.next();
        }
        return ret;
    }
    
    
   
    
}
