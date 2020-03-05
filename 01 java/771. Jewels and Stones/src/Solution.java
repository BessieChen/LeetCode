import java.util.HashSet;
import java.util.Set;

/**
 * @program: 771. Jewels and Stones
 * @description: https://leetcode.com/problems/jewels-and-stones/
 * @author: Bessie
 * @create: 2020-03-05 14:37
 **/
public class Solution {
//    Runtime: 1 ms, faster than 77.42% of Java online submissions for Jewels and Stones.
//    Memory Usage: 38.2 MB, less than 5.05% of Java online submissions for Jewels and Stones.
    public int numJewelsInStones(String J, String S) {
        Set<Character> setJ = new HashSet<>();
        int ret = 0;
        for(char c : J.toCharArray())
        {
            setJ.add(c);
        }
        for(char c : S.toCharArray())
        {
            if(setJ.contains(c)) ret++;
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Jewels and Stones.
//    Memory Usage: 38.2 MB, less than 5.05% of Java online submissions for Jewels and Stones.
    public int numJewelsInStones2(String J, String S) {
        int ret = 0;
        int[] set = new int[58];
        for(char c : J.toCharArray())
            set[c - 'A']++;
        for(char c : S.toCharArray())
            ret += set[c - 'A'];
        return ret;
    }

    public static void main(String[] args)
    {
//        String J = new String("Aa");
//        String S = new String("aAAbbbb");

        String J = "Aa";
        String S = "aAAbbbb";

        System.out.println("#1: "+ new Solution().numJewelsInStones(J, S));
        System.out.println("#2: "+ new Solution().numJewelsInStones2(J, S));
    }


}
