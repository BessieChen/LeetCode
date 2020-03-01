
/*
method 1:
Runtime: 73 ms, faster than 99.64% of Java online submissions for Online Stock Span.
Memory Usage: 70 MB, less than 10.00% of Java online submissions for Online Stock Span.
*/
class StockSpanner {

    private int[] pr = new int[10001];
    private int[] fl = new int[10001];
    private int size = 0;
    
    
    public int next(int price) {
        int ret;
        if(size == 0)
        {
            pr[size] = price;
            fl[size] = -1;
            ret = size + 1;
            //System.out.println("1size: "+(size)+" fl[size]: "+fl[size]);
            size++;
            return ret;
        }
        
        pr[size] = price;
        if(pr[size-1] > price)
        {
            fl[size] = size-1;
            ret = size - fl[size];
            //System.out.println("2size: "+(size)+" fl[size]: "+fl[size]);
            size++;
            return ret;
        }
        
        int jump = fl[size-1];
        if(jump == -1)
        {
            fl[size] = -1;
            ret = size + 1;
            //System.out.println("3size: "+(size)+" fl[size]: "+fl[size]);
            size++;
            return ret;
        }
        
        while(pr[jump] <= pr[size])
        {
            if(fl[jump] == -1)
            {
                fl[size] = -1;
                ret = size + 1;
                //System.out.println("3size: "+(size)+" fl[size]: "+fl[size]);
                size++;
                return ret;
            }
           
            jump = fl[jump];
        }
        fl[size] = jump;
        //System.out.println("4size: "+(size)+" fl[size]: "+fl[size]);
        ret = size - fl[size];
        size++;
        return ret;
    }
}




/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
