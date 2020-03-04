#include <iostream>

class Solution{
public:
//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
//    Memory Usage: 7.5 MB, less than 100.00% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
    int subtractProductAndSum(int n) {
        if(n / 10 == 0) return 0;
        int prod = 1;
        int sum = 0;
        while(n) //注意不能写成while(!n), 能进入的时候说明n == 0. 你是之前有做过if(!n) return 0; 这个是说n == 0时候进入if
        {
            int rem = n % 10;
            prod *= rem;
            sum += rem;
            n /= 10;
        }
        return prod - sum;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
//    Memory Usage: 7.3 MB, less than 100.00% of C++ online submissions for Subtract the Product and Sum of Digits of an Integer.
    int subtractProductAndSum2(int n) {
        if(n / 10 == 0) return 0;
        int prod = 1, sum = 0;
        while(n) //注意不能写成while(!n), 能进入的时候说明n == 0. 你是之前有做过if(!n) return 0; 这个是说n == 0时候进入if
        {
            int rem = n % 10;
            prod *= rem;
            sum += rem;
            n /= 10;
        }
        return prod - sum;
    }

};
int main() {
    int n1 = 234;
    int n2 = 4421;
    std::cout<<"n1, #1: "<<Solution().subtractProductAndSum(n1)<<std::endl;
    std::cout<<"n2, #1: "<<Solution().subtractProductAndSum(n2)<<std::endl;
    std::cout<<"n1, #2: "<<Solution().subtractProductAndSum2(n1)<<std::endl;
    std::cout<<"n2, #2: "<<Solution().subtractProductAndSum2(n2)<<std::endl;
    return 0;
}
