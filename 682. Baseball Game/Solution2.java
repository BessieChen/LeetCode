class Solution2 {
    
    public int calPoints(String[] ops) {
        return calPoints3(ops);
    }
    
    /*
    method 3:
    Runtime: 2 ms, faster than 94.47% of Java online submissions for Baseball Game.
    Memory Usage: 36.4 MB, less than 100.00% of Java online submissions for Baseball Game.
    */
    private int calPoints3(String[] ops) {   
        int[] arr = new int[ops.length];//no:ops.length()
        int[] sum = new int[ops.length];
        int size = 0;
        
        for(String s : ops)
        {
            char c = s.charAt(0);
            if(Character.isLetter(c))
            {
                if(c == 'C')
                {
                    if(size > 0)
                    {
                        size--;
                    } 
                }
                else// c == 'D'
                {
                    if(size > 0)
                    {
                        
                        arr[size] = arr[size-1]*2;
                        sum[size] = sum[size-1] + arr[size];
                        size++;
                    }
                }
            }
            else if(Character.isDigit(c) || c == '-')
            {
                arr[size] = Integer.valueOf(s);//no:s.toDigit(); 
                sum[size] = size == 0 ? arr[size] : sum[size-1] + arr[size];//note!
                size++;
            }
            else
            {
                if(size > 1)
                {
                    
                    arr[size] = arr[size-1] + arr[size-2];   
                    sum[size] = sum[size-1] + arr[size];
                    size++;
                }
            }
        }
        return size == 0 ? 0 : sum[size-1];
    }
    
    
     /*
    method 2:
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Baseball Game.
    Memory Usage: 36 MB, less than 100.00% of Java online submissions for Baseball Game.
    */
    private int calPoints2(String[] ops) {
        int[] arr = new int[ops.length];
        int size = 0;
        int sum = 0;
        
        for(String s : ops)
        {
            switch(s)
            {
                case "C":
                    {
                        sum -= arr[--size];
                        break;
                    }
                case "D":
                    {
                        arr[size] = arr[size-1]*2;
                        sum += arr[size];
                        size++;
                        break;
                    }
                case "+":
                    {
                        arr[size] = arr[size-1]+arr[size-2];
                        sum += arr[size];
                        size++;
                        break;
                    }
                default:
                {
                    arr[size] = Integer.valueOf(s);
                    sum += arr[size];
                    size++;
                    break;
                }
            }
        }
        return sum;
    }
    
    
    /*
    method 1:
    Runtime: 1 ms, faster than 100.00% of Java online submissions for Baseball Game.
    Memory Usage: 35.8 MB, less than 100.00% of Java online submissions for Baseball Game.
    */
    private int calPoints1(String[] ops) {
        int[] arr = new int[ops.length];
        int[] sum = new int[ops.length];
        int size = 0;
        
        for(String s : ops)
        {
            if(s.equals("C"))
            {
                if(size>0)
                {
                    size--;
                }
            }
            else if(s.equals("D"))
            {
                if(size > 0)
                {
                    arr[size] = arr[size-1]*2;
                    sum[size] = sum[size-1]+arr[size];
                    size++;
                }
            }
            else if(s.equals("+"))
            {
                if(size > 1)
                {
                    arr[size] = arr[size-1]+arr[size-2];
                    sum[size] = sum[size-1]+arr[size];
                    size++; 
                }
            }
            else
            {
                arr[size] = Integer.valueOf(s);
                sum[size] = size == 0 ? arr[size] : sum[size-1]+arr[size];
                size++;
            }
        }
        return sum[size-1];
    }
    
    //wrong:
//     private int calPointsWrong(String[] ops) {
//         int[] arr = new int[ops.length];//no:ops.length()
//         int[] sum = new int[ops.length];
//         int size = 0;
        
//         for(String s : ops)
//         {
//             char c = s.charAt(0);
//             if(Character.isLetter(c))
//             {
//                 if(c == 'C')
//                 {
//                     if(size > 0)
//                     {
//                         size--;
//                     } 
//                 }
//                 else// c == 'D'
//                 {
//                     if(size > 0)
//                     {
                        
//                         arr[size] = arr[size-1]*2;
//                         sum[size] = sum[size-1] + arr[size];
//                         size++;
//                     }
//                 }
//             }
//             else if(Character.isDigit(c))
//             {
//                 arr[size] = Integer.valueOf(s);//no:s.toDigit(); 
//                 sum[size] = size == 0 ? arr[size] : sum[size-1] + arr[size];//note!
//                 size++;
//             }
//             else
//             {
//                 if(size > 1)
//                 {
                    
//                     arr[size] = arr[size-1] + arr[size-2];   
//                     sum[size] = sum[size-1] + arr[size];
//                     size++;
//                 }
//             }
//         }
//         return sum[size-1];
//     }
}
