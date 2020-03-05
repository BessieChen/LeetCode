#include <iostream>
#include <string>
#include <unordered_set>

using namespace std;

class Solution{
public:
//    Runtime: 4 ms, faster than 65.80% of C++ online submissions for Jewels and Stones.
//    Memory Usage: 8 MB, less than 100.00% of C++ online submissions for Jewels and Stones.
    int numJewelsInStones(string J, string S) {
        //unordered_set<char> set = unordered_set(J.begin(), J.end());
        unordered_set<char> set(J.begin(), J.end());
        int ret = 0;
        for(char c : S)
        {
            ret += set.count(c);
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Jewels and Stones.
//    Memory Usage: 7.8 MB, less than 100.00% of C++ online submissions for Jewels and Stones.
    int numJewelsInStones2(string J, string S) {
        int ret = 0;
        int set[58] = {0};
        for(char c : J) set[c - 'A']++;
        for(char c : S) ret += set[c - 'A'];
        return ret;
    }
};
int main() {
    string J = "Aa";
    string S = "aAAbbbb";
    cout<<"#1: "<<Solution().numJewelsInStones(J, S)<<endl;
    cout<<"#2: "<<Solution().numJewelsInStones2(J, S)<<endl;
    return 0;
}
