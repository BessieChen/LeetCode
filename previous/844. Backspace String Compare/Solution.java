class Solution {
    public boolean backspaceCompare(String S, String T) {
        return backspaceCompare5(S, T);
    }
    
   
    public boolean backspaceCompare5(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int sb = 0;
        int tb = 0;
        
        while(i >= 0 || j >= 0)
        {
            while(i >= 0)
            {
                if(S.charAt(i) == '#')
                {
                    sb++;
                    i--;
                }
                else if(sb == 0) break;
                else
                {
                    sb--;
                    i--;
                }
            }
            
            while(j >= 0)
            {
                if(T.charAt(j) == '#')
                {
                    tb++;
                    j--;
                }
                else if(tb == 0) break;
                else
                {
                    tb--;
                    j--;
                }
            }
            
            if((i >= 0) != (j >= 0)) return false;
            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            
            i--;
            j--;
        }
        return true;
    }
    
   
    public boolean backspaceCompare4(String S, String T) {
        int i = S.length() - 1;
        int j = T.length() - 1;
        int sb = 0;
        int tb = 0;
        
        while(i >= 0 || j >= 0)
        {
            while(i >= 0)
            {
                if(sb >= 1)
                {
                    if(S.charAt(i) == '#') {
                        sb++;
                        i--;
                    }
                    else{
                        sb--;
                        i--;
                    }
                }
                else//(sb <= 0)
                {
                    if(S.charAt(i) == '#') {
                        sb++;
                        i--;
                        
                    }
                    else break;
                }
            }
            
            while(j >= 0)
            {
                if(tb >= 1)
                {
                    if(T.charAt(j) == '#') {
                        tb++;
                        j--;
                    }
                    else{
                        tb--;
                        j--;
                        //System.out.println("2"+" j: "+j);
                    }
                }
                else//(tb <= 0)
                {
                    if(T.charAt(j) == '#') {
                        tb++;
                        j--;
                        //System.out.println("3"+" j: "+j);
                    }
                    else break;
                }
            }
            
            //System.out.println("i: "+i+" j: "+j);
            if((i >= 0) != (j >= 0)) return false;
            if(i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) return false;
            
            i--;
            j--;
        }
        return true;
    }
    
   
    public boolean backspaceCompare3(String S, String T)   
    {
        char[] stackS = new char[200];
        int sizeS = 0;
        char[] stackT = new char[200];
        int sizeT = 0;
        
        for(char c : S.toCharArray())
        {
            if(c == '#' && sizeS > 0) sizeS--;
            else if(Character.isLetter(c)) stackS[sizeS++] = c;
        }
        
        for(char c : T.toCharArray())
        {
            if(c == '#' && sizeT > 0) sizeT--;
            else if(Character.isLetter(c)) stackT[sizeT++] = c;
        }
        if(sizeT != sizeS) return false;
        for(int i = 0; i < sizeT; i++) if(stackT[i] != stackS[i]) return false;
        return true;
    }

    
}
