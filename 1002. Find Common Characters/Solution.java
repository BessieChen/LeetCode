class Solution {
    public List<String> commonChars(String[] A) {
        if(A == null || A.length == 0) return null;
        
        int[] init = new int[26];
        for(char c : A[0].toCharArray())
        {
            init[ c - 'a']++;
        }
        
        for(int i = 1; i < A.length; i++)
        {
            int[] word = new int[26];
            for(char c : A[i].toCharArray())
            {
                word[c - 'a']++;
            }
            for(int j = 0; j < 26; j++)
            {
                if(word[j] < init[j]) init[j] = word[j];
            }
        }
        
        List<String> ret = new ArrayList<>();
        char letter = 'a';
        for(int i = 0; i < 26; i++)
        {
            if(init[i] > 0)
            {
                for(int j = 0; j < init[i]; j++)
                {
                    ret.add("" + letter);
                }
            }
            letter++;
        }
        
        return ret;
    }
    
}
