import java.util.ArrayList;

import static java.lang.Integer.min;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new BSTMap<>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.contains(nums1[i]))
            {
                map.set(nums1[i], map.get(nums1[i])+1);
            }
            else
            {
                map.add(nums1[i],1);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.contains(nums2[i]))
            {
                ret.add(nums2[i]);
                map.set(nums2[i], map.get(nums2[i])-1);
                if(map.get(nums2[i])==0)
                {
                    map.remove(nums2[i]);
                }
            }
        }

        int[] ret_array = new int[ret.size()];
        for(int i = 0; i < ret_array.length; i++)
        {
            ret_array[i] = ret.get(i);
        }
        return ret_array;
    }


}