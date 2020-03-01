public class Solution {

    /*
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Baseball Game.
    Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Baseball Game.
    */

    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int size = 0;

        //第一次错在了，以为ops里面的每一个String都是char，就是我直接认为 "3"这样的，其实可能是 "98"， 所以不能直接设置char c = ..., 而是直接用String
/*        for(int i = 0; i < ops.length; i++)
        {
            char c = ops[i].charAt(0);
            if(Character.isDigit(c))
            {
                arr[size++] = c - '0';
            }
            else if(Character.isLetter(c))
            {
                if(c == 'C') size--;
                if(c == 'D') arr[size++] = arr[size-1]*2;
            }
            else
            {
                arr[size++] = arr[size-1] + arr[size-2];
            }
        }*/

        //正确：
        /*for(String s : ops)
        {
            if(s.equals("C"))
            {
                if(size >= 1) size--;
            }
            else if(s.equals("D"))
            {
                if(size >= 1) arr[size++] = arr[size-1]*2;
            }
            else if(s.equals("+"))
            {
                if(size >= 2) arr[size++] = arr[size-1] + arr[size-2];
                else if(size == 1) arr[size++] = arr[size-1];
            }
        }*/

        //正确：
        for(String s : ops)
        {
            if(s.equals("C"))
            {
                size--;
            }
            else if(s.equals("D"))
            {
                //arr[size++] = arr[size-1]*2;
                arr[size] = arr[size-1]*2;
                size++;
            }
            else if(s.equals("+"))
            {
                //arr[size++] = arr[size-1] + arr[size-2];
                arr[size] = arr[size-1] + arr[size-2];
                size++;
            }
            else
            {
                arr[size++] = Integer.valueOf(s);
            }
        }

        int sum = 0;
        for(int i = 0; i < size; i++)
        {
            sum += arr[i];
        }

        return sum;
    }
}
