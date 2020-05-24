#include <iostream>
#include <map>
#include <vector>
using namespace std;

class Solution {
public:
    int thirdMax(vector<int>& nums) {
        map<int,int> m;
        for(int i = 0 ; i < nums.size(); i ++)
        {
            m[nums[i]]++; //如果之前没有的元素，现在创建变成1；如果已有的，就+1
        }

        int size = m.size();
        map<int,int>::iterator it;
        if(size < 3)
        {
            it = m.end();
            it--;
        }
        else
        {
            int target = size - 3;
            for(it = m.begin(); it != m.end() && target > 0; it++, target--)  ;
        }

        return it->first;
    }
};


int main() {
    vector<int> input = {3,2,3,4,2,1};
    cout<<Solution().thirdMax(input)<<endl;//2
    return 0;
}
