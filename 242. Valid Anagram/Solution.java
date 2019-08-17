class Solution {
    public boolean isAnagram(String s, String t) {
        return isAnagram1(s,t);
    }
    
    /*
    method 2:
    Runtime: 3 ms, faster than 94.35% of Java online submissions for Valid Anagram.
    Memory Usage: 37.1 MB, less than 97.42% of Java online submissions for Valid Anagram.
    */
    private boolean isAnagram2(String s, String t) {
        int[] map = new int[26];
        if(s.length() != t.length()) return false;
        for(int i = 0; i < s.length(); i++)
        {
            map[s.charAt(i) - 'a']++;
            map[t.charAt(i) - 'a']--;
        }
        for(int i : map)
            if(i != 0) return false;
        return true;
    }
    
    /*
    method 1:
    Runtime: 4 ms, faster than 78.74% of Java online submissions for Valid Anagram.
    Memory Usage: 36.2 MB, less than 98.06% of Java online submissions for Valid Anagram.
    */
    private boolean isAnagram1(String s, String t) {
        int[] map = new int[26];
        if(s.length() != t.length()) return false;
        for(char c : s.toCharArray())
        {
            map[c - 'a']++;
        }
        for(char c : t.toCharArray())
        {
            map[c - 'a']--;
        }
        for(int i : map)
            if(i != 0) return false;
        return true;
    }
    
    
}
