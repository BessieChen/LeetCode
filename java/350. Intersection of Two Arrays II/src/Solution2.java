import java.util.ArrayList;
import java.util.TreeMap;

public class Solution2 {

    public int[] intersect(int[] nums1, int[] nums2) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int i = 0; i < nums1.length; i++)
        {
            if(map.containsKey(nums1[i]))
            {
                map.put(nums1[i], map.get(nums1[i])+1);
            }
            else
            {
                map.put(nums1[i],1);
            }
        }

        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++)
        {
            if(map.containsKey(nums2[i]))
            {
                ret.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
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