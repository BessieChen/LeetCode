class Solution2 {
    public List<Integer> addToArrayForm(int[] A, int K) {
        return addToArrayForm7(A, K);
    }

    public List<Integer> addToArrayForm7(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int i = A.length-1;
        int carry = 0;
        int sum = 0;
        
        while( i >= 0 || K > 0 || carry > 0)
        {
            if(i >= 0)
                sum =  A[i--] + K % 10 + carry;
            else sum = K % 10 + carry;;
            K /= 10;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        Collections.reverse(list);
        return list;
    }
    
    public List<Integer> addToArrayForm6(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int i = A.length-1;
        int carry = 0;
        int sum = 0;
        
        while( i >= 0 || K > 0 || carry > 0)
        {
            int a = i >= 0 ? A[i] : 0;
            int k = K != 0 ? K : 0;
            
            sum = a + k % 10 + carry;
            i--;
            K /= 10;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        Collections.reverse(list);
        return list;
    }
    
    public List<Integer> addToArrayForm5(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int i = A.length-1;
        int carry = 0;
        int sum = 0;
        
        while( i >= 0 || K > 0)
        {
            int a = i >= 0 ? A[i] : 0;
            int k = K != 0 ? K : 0;
            
            sum = a + k % 10 + carry;
            i--;
            K /= 10;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        if(carry == 1) list.add(1);
        Collections.reverse(list);
        return list;
    }
}
