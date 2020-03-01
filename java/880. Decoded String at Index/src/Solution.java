/*
public class Solution {

    */
/*public String decodeAtIndex(String S, int K) {
        StringBuilder res = new StringBuilder();
        for(long i = 0; i < S.length(); i++)
        {
            char c = S.charAt((int)i);
            while(!Character.isDigit(c))
            {
                res.append(c);
                c = S.charAt((int) ++i);
            }

            long round = c - '0';
            String app = res.toString();
            for(long j = 0; j < round-1; j++)
            {
                res.append(app);
            }
        }
        return String.valueOf(res.toString().charAt(K-1));
    }*//*


    public String decodeAtIndex(String S, int K)
    {
        StringBuilder res = new StringBuilder();
        int totalSize = 0;
        for(int i = 0; i < S.length(); i++)
        {
            char c = S.charAt(i);
            while(!Character.isDigit(c))
            {
                res.append(c);
                totalSize++;
                if(K <= totalSize)
                {
                    return String.valueOf(res.toString().charAt(K-1));
                }
                if(i == S.length() - 1) break;
                c = S.charAt(++i);
            }

            int round;
            if(Character.isDigit(c))
            {
                round = c - '0';
                String app = res.toString();
                for(int j = 0; j < round-1; j++)
                {
                    res.append(app);
                }
                totalSize *= round;
                if(K <= totalSize)
                {
                    K %= totalSize;
                    return String.valueOf(res.toString().charAt(K-1));
                }

            }

        }
//        return String.valueOf(res.toString().charAt(K-1));
        return "";
    }

    //老是错
    */
/*
    * "y959q969u3hb22odq595"
        222280369*//*



}


*/
/*
*
*     public String decodeAtIndex(String S, int K) {
        for (int len = 0, i = 0; i < S.length(); i++) {
            if (Character.isDigit(S.charAt(i))) {
                int num = S.charAt(i) - '0', count = 0;
                for (; count < num - 1 && K > len; count++) {
                    K -= len;
                }
                if (count != num - 1) {
                    return decodeAtIndex(S, K);
                } else {
                    len *= num;
                }
            } else {
                len++;
                K--;
                if (K == 0) {
                    return String.valueOf(S.charAt(i));
                }
            }
        }
        return "";
    }
    *
    * */


public class Solution {


    public String decodeAtIndex(String S, int K)
    {
        int index = K-1;
        StringBuilder res = new StringBuilder();
        int[] totalSize = new int[S.length()];//最极端的就是S里面全部都是数字。
        int size = 0;
        int totalSize_index = 0;

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
                totalSize[totalSize_index++] = size;

                int round = c - '0';
                int newSize = size * round;

                String resString = res.toString();
                for(int j = 0; j < round-1; j++)
                {
                    res.append(resString);
                }

                if(index <= newSize-1)
                {
                    while(index >= totalSize[0] && totalSize_index >= 0)
                    {
                        index %= totalSize[totalSize_index--];
                        while(index <= totalSize[totalSize_index] && totalSize_index >= 0)
                        {
                            index %= totalSize[totalSize_index--];
                        }
                    }
                    return String.valueOf(res.toString().charAt(index));
                }

                size = newSize;

            }
        }

        return String.valueOf(res.toString().charAt(K-1));
    }

}
