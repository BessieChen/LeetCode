public class Solution3 {
    public String decodeAtIndex(String S, int K)
    {
        long size = 0;//todo long!
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


            K %= size;//如果K<size就没起作用，如果K>=size; 就会起作用。//todo 这里不需要担心size == 0.因为肯定不可能==0.
            if( K == 0 && Character.isLetter(c))//todo 一定注意是&& Character.isLetter(c)，例如 a12324827349.
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
