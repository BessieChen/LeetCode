import java.util.TreeSet;

class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};

        TreeSet<String> set = new TreeSet<>();
        int index;
        for(String word : words)
        {
            StringBuilder res = new StringBuilder();
            //String res = new String();//String类型没有append
            for(int i = 0; i < word.length(); i++)
            {
                index = word.charAt(i)-'a';
                res.append(codes[index]);
            }
            set.add(res.toString());
        }
        return set.size();
    }
}