#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
class Solution{
public:
//    Runtime: 8 ms, faster than 75.44% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 8 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            if((i >= 10 && i <= 99) || (i >= 1000 && i <= 9999) || i == 100000)
                ret++;
        }
        return ret;
    }

//    Runtime: 8 ms, faster than 75.44% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 7.9 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers2(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            ret += to_string(i).length() % 2 == 0 ? 1 : 0;
        }
        return ret;
    }

//    Runtime: 8 ms, faster than 75.44% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 8.2 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers3(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            ret += 1 - to_string(i).length() % 2;
        }
        return ret;
    }

//    Runtime: 8 ms, faster than 75.44% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 7.9 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers4(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            ret += 1 - countDigit(i) % 2;
        }
        return ret;
    }

    int countDigit(int i)
    {
        if(i == 0) return 1;
        int ret = 0;
        while(i)
        {
            i /= 10;
            ret++;
        }
        return ret;
    }

//    Runtime: 4 ms, faster than 98.44% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 8.3 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers5(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            ret += 1 - (int)(log10(i) + 1) % 2 ;
            //ret += 1 - (int)std::floor(log10(i) + 1) % 2 ;
            /*
             * 错误代码：因为 % 以及 & 的左右都必须是int
             * ret += 1 - std::floor(log10(i) + 1) % 2 ;
             * ret += 1 - std::floor(log10(i) + 1) & 1 ;
             * */
        }
        return ret;
    }
//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
//    Memory Usage: 8.3 MB, less than 100.00% of C++ online submissions for Find Numbers with Even Number of Digits.
    int findNumbers6(vector<int>& nums) {
        int ret = 0;
        for(const auto& i : nums)
        {
            ret += 1 - (int)(log10(i) + 1) & 1 ;
            //ret += 1 - (int)std::floor(log10(i) + 1) & 1 ;
            /*
             * 错误代码：因为 % 以及 & 的左右都必须是int
             * ret += 1 - std::floor(log10(i) + 1) % 2 ;
             * ret += 1 - std::floor(log10(i) + 1) & 1 ;
             * */
        }
        return ret;
    }

};
int main() {
//    int n1[] = {12,345,2,6,7896,100000};
//    int n2[] = {555,901,482,1771};
    vector<int> n1 = {12,345,2,6,7896,100000};
    vector<int> n2 = {555,901,482,1771};
    cout<<"n1, #1: "<<Solution().findNumbers(n1)<<endl;
    cout<<"n2, #1: "<<Solution().findNumbers(n2)<<endl;
    cout<<"-----------"<<endl;
    cout<<"n1, #2: "<<Solution().findNumbers2(n1)<<endl;
    cout<<"n2, #2: "<<Solution().findNumbers2(n2)<<endl;
    cout<<"-----------"<<endl;
    cout<<"n1, #3: "<<Solution().findNumbers3(n1)<<endl;
    cout<<"n2, #3: "<<Solution().findNumbers3(n2)<<endl;
    cout<<"-----------"<<endl;
    cout<<"n1, #4: "<<Solution().findNumbers4(n1)<<endl;
    cout<<"n2, #4: "<<Solution().findNumbers4(n2)<<endl;
    cout<<"-----------"<<endl;
    cout<<"n1, #5: "<<Solution().findNumbers5(n1)<<endl;
    cout<<"n2, #5: "<<Solution().findNumbers5(n2)<<endl;
    cout<<"-----------"<<endl;
    cout<<"n1, #6: "<<Solution().findNumbers6(n1)<<endl;
    cout<<"n2, #6: "<<Solution().findNumbers6(n2)<<endl;
    cout<<"-----------"<<endl;

    return 0;
}
