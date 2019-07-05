//
//  Solution3.h
//  922. Sort Array By Parity II
//
//  Created by 陈贝茜 on 2019/7/3.
//  Copyright © 2019 Bessie Chen. All rights reserved.
//

#ifndef Solution3_h
#define Solution3_h

/// Make the change in place
/// Time Complexity: O(n)
/// Space Complexity: O(1)
class Solution3_v1 {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        
        for(int i = 0; i < A.size(); i ++)
            if(i % 2 == 0 && A[i] % 2){
                int j = i + 1;
                for(; j < A.size(); j += 2)
                    if(A[j] % 2 == 0)
                        break;
                swap(A[i], A[j]);
            }
            else if(i % 2 && A[i] % 2 == 0){
                int j = i + 1;
                for(; j < A.size(); j += 2)
                    if(A[j] % 2)
                        break;
                swap(A[i], A[j]);
            }
        return A;
    }
};

/// Make the change in place
/// and the code clearer :-)
///
/// Time Complexity: O(n)
/// Space Complexity: O(1)
class Solution3_v2 {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        
        int j = 1;
        for(int i = 0; i < A.size(); i += 2)
            if(A[i] % 2){
                for(; j < A.size(); j += 2)
                    if(A[j] % 2 == 0)
                        break;
                swap(A[i], A[j]);
            }
        return A;
    }
};

class Solution3_v3 {
public:
    vector<int> sortArrayByParityII(vector<int>& A) {
        for (int i = 0, j = 1; i < A.size(); i += 2, j += 2) {
            while (i < A.size() && A[i] % 2 == 0) i += 2;
            while (j < A.size() && A[j] % 2 == 1) j += 2;
            if (i < A.size()) swap(A[i], A[j]);
        }
        return A;
    }
};

#endif /* Solution3_h */
