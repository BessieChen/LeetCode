import java.util.ArrayList;

public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new BSTSet<>();
        //Set<Integer> duplicate = new BSTSet<>();

        for(int i = 0 ; i < nums1.length ; i++)
        {
            set.add(nums1[i]);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++)
        {
            if(set.contains(nums2[i]) && !ret.contains(nums2[i]))
            {
                ret.add(nums2[i]);
            }
        }

        //Wrong:
        //return (int[]) ret;

        int[] ret_array = new int[ret.size()];
        for(int i = 0; i < ret_array.length; i++)
        {
            ret_array[i] = ret.get(i);//我之前本来想把ret设成Set<Integer> ret = new BSTSet<>();但是这么做的话ret就没有get这个函数了。因为BSTSet没有index，也无从说get index。
        }

        return ret_array;
    }
}