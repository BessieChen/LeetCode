/*
    method 2:
    Runtime: 3 ms, faster than 91.37% of Java online submissions for Find Common Characters.
    Memory Usage: 37.9 MB, less than 82.76% of Java online submissions for Find Common Characters.*/
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
                if(init[j] != 0 && word[j] < init[j]) init[j] = word[j];
            }
        }
        
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < 26; i++)
        {
            if(init[i] > 0)
            {
                for(int j = 0; j < init[i]; j++)
                {
                    ret.add("" + (char)( 'a' + i));
                }
            }
        }
        
        return ret;
    }
