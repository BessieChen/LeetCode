class Solution {
    public int triangleNumber(int[] S) {
        return triangleNumber4(S);
    }
    
    
    public int triangleNumber4(int[] S) {
        Arrays.sort(S);
        int ret = 0;
        for(int i = S.length-1; i >= 2; i--)
        {
            int l = 0;
            int r = i-1;
            while(l < r)
            {
                if(S[l] + S[r] > S[i])
                {
                    ret += r-l;
                    r--;
                }
                else
                {
                    l++;
                }
            }
        }
        return ret;
    }
    
}
