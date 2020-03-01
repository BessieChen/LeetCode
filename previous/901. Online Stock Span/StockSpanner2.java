/*
method 2:
Runtime: 74 ms, faster than 98.82% of Java online submissions for Online Stock Span.
Memory Usage: 69.7 MB, less than 10.00% of Java online submissions for Online Stock Span.
*/
class StockSpanner2 {

    private int[] pr = new int[10001];
    private int[] fl = new int[10001];
    private int size = 0;
    
    public int next(int price) {
        int ret;
        pr[size] = price;
        ifStatement:
        {
            if(size == 0)
            {
                fl[size] = -1;
            }
            else
            {
                if(pr[size-1] > price)
                {
                    fl[size] = size-1; 
                    break ifStatement;   
                }

                int jump = fl[size-1];
                if(jump == -1)
                {
                    fl[size] = -1;
                    break ifStatement;   
                }

                while(pr[jump] <= pr[size])
                {
                    if(fl[jump] == -1)
                    {
                        fl[size] = -1;
                        break ifStatement; 
                    }
                    jump = fl[jump];
                }
                fl[size] = jump;
            }
        }
        
        size++;
        return fl[size-1] == -1 ? size : (size-1) - fl[size-1];
    }
}




/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
