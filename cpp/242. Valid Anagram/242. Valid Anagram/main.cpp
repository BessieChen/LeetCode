//
//  main.cpp
//  242. Valid Anagram
//
//  Created by 陈贝茜 on 2019/7/3.
//  Copyright © 2019 Bessie Chen. All rights reserved.
//

#include <iostream>

using namespace std;

/// Sorting
/// Time Complexity: O(nlogn)
/// Space Complexity: O(1)
class Solution {
public:
    bool isAnagram(string s, string t) {
        
        sort(s.begin(), s.end());
        sort(t.begin(), t.end());
        
        return s == t;
    }
};


int main() {
    
    cout << Solution().isAnagram("anagram", "nagaram") << endl;
    cout << Solution().isAnagram("rat", "car") << endl;
    cout << Solution().isAnagram("ab", "a") << endl;
    
    return 0;
}
