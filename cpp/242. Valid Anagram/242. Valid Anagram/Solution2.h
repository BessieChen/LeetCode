//
//  Solution2.h
//  242. Valid Anagram
//
//  Created by 陈贝茜 on 2019/7/3.
//  Copyright © 2019 Bessie Chen. All rights reserved.
//

#ifndef Solution2_h
#define Solution2_h
#include <iostream>

using namespace std;

/// Using Hashtable
/// Time Complexity: O(n)
/// Space Complexity: O(26)
class Solution {
public:
    bool isAnagram(string s, string t) {
        
        if( s.size() != t.size() )
            return false;
        
        int freq[26] = {0};
        for( int i = 0 ; i < s.size() ; i ++ )
            freq[s[i]-'a'] ++;
        
        for( int i = 0 ; i < t.size() ; i ++ ){
            freq[t[i]-'a'] --;
            if( freq[t[i]-'a'] < 0 )
                return false;
        }
        
        return true;
    }
};


int main2() {
    
    cout << Solution().isAnagram("anagram", "nagaram") << endl;
    cout << Solution().isAnagram("rat", "car") << endl;
    cout << Solution().isAnagram("ab", "a") << endl;
    
    return 0;
}

#endif /* Solution2_h */
