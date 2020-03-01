public class Solution2 {


    public String decodeAtIndex(String S, int K)
    {
        int index = K-1;
        StringBuilder res = new StringBuilder();
        int[] totalSize = new int[S.length()];//最极端的就是S里面全部都是数字。
        int size = 0;
        int totalSize_index = -1;

        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            while( Character.isLetter(c) )
            {
                size++;
                res.append(c);
                if(index <= size-1)
                {
                    return String.valueOf(res.toString().charAt(index));
                }
                if(i == S.length()-1) break;
                c = S.charAt(++i);
            }

            if(i != S.length()-1 || Character.isDigit(c))//所以排除在if之外的就是： i是最后一个index，并且c依旧是字母，不是数字。
            {
                totalSize[++totalSize_index] = size;

                int round = c - '0';
                int newSize = size * round;

                String resString = res.toString();
                for(int j = 0; j < round-1; j++)
                {
                    res.append(resString);
                }

                if(index <= newSize-1)
                {
                    /*
                    index %= totalSize[totalSize_index--];
                    if(index >= totalSize[0] && totalSize_index >= 0)
                    {
                        // System.out.println("res = "+res);
                        // System.out.println("soze = "+totalSize[totalSize_index]);
                        index %= totalSize[totalSize_index--];
                        while(totalSize_index >= 0 && index < totalSize[totalSize_index]-1)
                        {

                            index %= totalSize[totalSize_index--];
                            ?System.out.println("index = "+ index);
                        }
                    }
                    */
                    System.out.println("res = "+res);
                    index %= totalSize[totalSize_index--];
                    while(totalSize_index >= 0 && index < totalSize[totalSize_index]-1)
                    {

                        index %= totalSize[totalSize_index--];
                        //System.out.println("index = "+ index);
                    }

                    System.out.println(index);
                    return String.valueOf(res.toString().charAt(index));
                }

                size = newSize;

            }
        }

        return String.valueOf(res.toString().charAt(K-1));
    }

    //aabaabaab

}


/*
*
* class Solution {
    public String decodeAtIndex(String S, int K) {
        long size = 0;
        int N = S.length();

        // Find size = length of decoded string
        for (int i = 0; i < N; ++i) {
            char c = S.charAt(i);
            if (Character.isDigit(c))
                size *= c - '0';
            else
                size++;
        }

        for (int i = N-1; i >= 0; --i) {
            char c = S.charAt(i);
            K %= size;
            if (K == 0 && Character.isLetter(c))
                return Character.toString(c);

            if (Character.isDigit(c))
                size /= c - '0';
            else
                size--;
        }

        throw null;
    }
}
*
* */