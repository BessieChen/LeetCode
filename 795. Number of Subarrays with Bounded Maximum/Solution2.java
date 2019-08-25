class Solution2 {
    
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int ans=0,maxIndex=-1,mins=0;
        
        for(int i=0;i<A.length;i++){
            if(A[i]<L)mins+=1;
            else mins=0;
            if(A[i]>R)maxIndex=i;
            ans+=(i-maxIndex-mins);
        }
        return ans;
    }
    
    
}
