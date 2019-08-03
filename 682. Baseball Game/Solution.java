class Solution {

/*
Runtime: 1 ms, faster than 100.00% of Java online submissions for Baseball Game.
Memory Usage: 36.3 MB, less than 100.00% of Java online submissions for Baseball Game.
*/
    public int calPoints(String[] ops) {
        int[] arr = new int[ops.length];
        int size = 0;

        
        for(String s : ops)
        {
            if(s.equals("C"))
            {
                size--;
            }
            else if(s.equals("D"))
            {
                arr[size] = arr[size-1]*2;
                size++;
            }
            else if(s.equals("+"))
            {
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
