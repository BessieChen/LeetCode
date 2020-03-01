class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
        return addToArrayForm4(A, K);
    }

    public List<Integer> addToArrayForm4(int[] A, int K) {
        List<Integer> list = new ArrayList<>();
        int i = A.length-1;
        int carry = 0;
        int sum = 0;
        
        while( i >= 0 && K > 0)
        {   
            sum = A[i] + K % 10 + carry;
            i--;
            K /= 10;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        
        while( i >= 0)
        {
            sum = A[i] + carry;
            i--;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        
        while(K > 0)
        {
            sum = K % 10 + carry;
            K /= 10;
            
            list.add(sum % 10);
            carry = sum/10 == 0 ? 0 : 1;            
        }
        
        
        if(carry == 1) list.add(1);
        Collections.reverse(list);
        return list;
    }
    
}
