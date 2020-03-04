/**
 * @program: 1221. Split a String in Balanced Strings
 * @description: https://leetcode.com/problems/split-a-string-in-balanced-strings/
 * @author: Bessie
 * @create: 2020-03-04 07:42
 **/
public class Solution {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
//    Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings.
    public int balancedStringSplit(String s) {
        int count = 0;
        int ret = 0;
        for(char c : s.toCharArray())
        {
            if(c == 'R') count++;
            else count--;
            if(count == 0)
            {
                ret++;
            }
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Split a String in Balanced Strings.
//    Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Split a String in Balanced Strings.
    public int balancedStringSplit2(String s) {
        int count = 0;
        int ret = 0;
        for(char c : s.toCharArray())
        {
            count += c == 'R' ? 1 : -1;
            ret += count == 0 ? 1 : 0;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        String s = "RLRRLLRLRL";
        String t = "LLLLRRRR";
        System.out.println("s #1: "+ new Solution().balancedStringSplit(s));
        System.out.println("s #2: "+ new Solution().balancedStringSplit2(s));

        System.out.println("t #1: "+ new Solution().balancedStringSplit(t));
        System.out.println("t #2: "+ new Solution().balancedStringSplit2(t));
    }
}

