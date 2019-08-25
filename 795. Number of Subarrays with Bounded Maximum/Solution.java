class Solution {
   
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        return numSubarrayBoundedMax(A, 0, A.length-1,L, R);
    }

    public int numSubarrayBoundedMax(int[] A, int start, int end , int L, int R) {
        int ans = 0;
        for (int i=start;i<=end;i++){
            if (A[i]>R){
                return numSubarrayBoundedMax(A, start, i-1, L, R) + numSubarrayBoundedMax1(A, i+1, end, L, R);
            }
        }
        int prev = 0;
        for (int i=start;i<=end;i++){
            if (A[i]>=L){
                ans += i-start+1;
                prev = i-start+1;
            }else if (A[i] < L) {
                ans += prev;
            }
        }
        return ans;
    }
}
