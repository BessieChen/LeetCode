public class Solution {
    public String decodeAtIndex(String S, int K)
    {
        long size = 0;//这里不能用int size = 0; 否则会溢出，因为题目的size有时会非常大。
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            if(Character.isLetter(c))
            {
                size++;
            }
            else
            {
                int round = c - '0';
                size *= round;
            }
        }
        
        for(int i = S.length() -1 ; i >= 0; i--)
        {
            char c = S.charAt(i);

            
            K %= size;//如果K<size就没起作用，如果K>=size; 就会起作用。
            if( K == 0 && Character.isLetter(c))
                return String.valueOf(c);

            if(Character.isLetter(c))
            {
                size--;
            }
            else
            {
                int round = c - '0';
                size /= round;
            }
        }
        
        return "";
    }
}
