#include <iostream>
#include <cmath>

//https://leetcode.com/problems/number-of-steps-to-reduce-a-number-to-zero/
class Solution {
public:
//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 7.4 MB, less than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
    int numberOfSteps (int num) {
        int ret = 0;
        while(num > 0)
        {
            if(num % 2 == 0)
                num /= 2;
            else
                num -= 1;
            ret++;
        }
        return ret;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 7.2 MB, less than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
    int numberOfSteps2 (int num) {
        if(!num) return 0;//TODO
        int ret = 0;
        while(num)
        {
            ret += num & 1 ? 2 : 1;
            num >>= 1;
        }
        return ret - 1;
    }

    int numberOfSteps3 (int num) {
        return std::bitset<32>(num).size() - std::bitset<32>(num).count(); //std::bitset<32>(num).size() == 32
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
//    Memory Usage: 7.6 MB, less than 100.00% of C++ online submissions for Number of Steps to Reduce a Number to Zero.
    int numberOfSteps4 (int num) {
        return log2(num) + std::bitset<32>(num).count(); //std::bitset<32>(num).size() == 32
    }
};

int main() {
    int input = 14;
    std::cout<<"#1: " <<Solution().numberOfSteps(input)<<std::endl;
    std::cout<<"#2: " <<Solution().numberOfSteps2(input)<<std::endl;
    std::cout<<"#3: wrong! " <<Solution().numberOfSteps3(input)<<std::endl;
    std::cout<<"#4: " <<Solution().numberOfSteps4(input)<<std::endl;
    std::cout<<log2(14)<<std::endl;//3.80735
    std::cout<<(int)(log2(14))<<std::endl;//3
    std::cout<<"-----"<<std::endl;
    std::cout<<log2(16)<<std::endl;//4
    std::cout<<(int)(log2(16))<<std::endl;//4
    std::cout<<"-----"<<std::endl;
    std::cout<<(int)(log2(14))+1<<std::endl;//4, 14: 0b 1110;
    std::cout<<(int)(log2(16))+1<<std::endl;//5, 16: 0b 10000
    return 0;
}
