class Solution3{

    public int minAddToMakeValid(String S) {
        int ind = 0;
        int minus = 0;

        for(char c : S.toCharArray())
        {
            if(c == '(') ind++;
            if(c == ')')
            {
                ind--;
                if(ind < 0)
                {
                    minus += 1;
                    ind = 0;
                }

            }
        }
        return minus + ind;
    }
}