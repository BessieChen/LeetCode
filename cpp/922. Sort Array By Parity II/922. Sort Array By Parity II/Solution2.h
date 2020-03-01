//
//  Solution2.h
//  922. Sort Array By Parity II
//
//  Created by 陈贝茜 on 2019/7/3.
//  Copyright © 2019 Bessie Chen. All rights reserved.
//

#ifndef Solution2_h
#define Solution2_h

class Solution2_v1 {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        
        // int len = A.len;//TODO
        // vector<int> ret = vactor<int>[len];//TODO
        int len = A.size();
        vector<int> ret(len);
        
        int odd = 1;
        int even = 0;
        for(int k = 0; k < len; k++)
        {
            if(A[k] % 2 == 0)
            {
                ret[even] = A[k];
                even = min(even+2, len-1);
            }
            else
            {
                ret[odd] = A[k];
                odd = min(odd+2, len-1);
            }
        }
        return ret;
    }
};


/// Two pass to deal with odd and even elements seperately
/// Time Complexity: O(n)
/// Space Complexity: O(n)
class Solution2_v2 {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        
        vector<int> ret(A.size());
        int p_even = 0;
        for(int a: A)
            if(a % 2 == 0){
                ret[p_even] = a;
                p_even += 2;
            }
        
        int p_odd = 1;
        for(int a: A)
            if(a % 2){
                ret[p_odd] = a;
                p_odd += 2;
            }
        return ret;
    }
};


#endif /* Solution2_h */
