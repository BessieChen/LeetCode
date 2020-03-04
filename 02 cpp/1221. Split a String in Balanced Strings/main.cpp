#include <iostream>
#include <string>


class Solution{
public:
//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Split a String in Balanced Strings.
//    Memory Usage: 7.6 MB, less than 100.00% of C++ online submissions for Split a String in Balanced Strings.
    int balancedStringSplit(std::string s) {
        int cnt(0);
        int ret(0);

        for(char c : s)
        {
            cnt += c == 'R' ? 1 : -1;
            ret += cnt == 0 ? 1 : 0;
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Split a String in Balanced Strings.
//    Memory Usage: 7.6 MB, less than 100.00% of C++ online submissions for Split a String in Balanced Strings.
    int balancedStringSplit2(std::string s) {
        int cnt(0);
        int ret(0);

        for(const auto& c : s)//TODO
        {
            cnt += c == 'R' ? 1 : -1;
            ret += cnt == 0 ? 1 : 0;
        }
        return ret;
    }
};

int main() {
    std::string s = "RLRRLLRLRL";
    std::string t = "LLLLRRRR";
    std::cout<<"s, #1: "<<Solution().balancedStringSplit(s)<<std::endl;
    std::cout<<"s, #2: "<<Solution().balancedStringSplit2(s)<<std::endl;
    std::cout<<"t, #1: "<<Solution().balancedStringSplit(t)<<std::endl;
    std::cout<<"t, #2: "<<Solution().balancedStringSplit2(t)<<std::endl;
    return 0;
}
