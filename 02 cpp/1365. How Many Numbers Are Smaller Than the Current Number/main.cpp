#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
//    Runtime: 12 ms, faster than 92.77% of C++ online submissions for How Many Numbers Are Smaller Than the Current Number.
//    Memory Usage: 8.2 MB, less than 100.00% of C++ online submissions for How Many Numbers Are Smaller Than the Current Number.
    vector<int> smallerNumbersThanCurrent(vector<int>& nums) {
        vector<int> map(101);
        for(int i = 0; i < nums.size(); i++)
        {
            map[nums[i]]++;
        }
        for(int i = 1; i < map.size(); i++)
        {
            map[i] += map[i-1];
        }
        vector<int> ret(nums.size());
        for(int i = 0; i < nums.size(); i++)
        {
            if(nums[i] != 0)
            {
                ret[i] = map[nums[i] - 1];
            }
        }
        return ret;
    }

//    Runtime: 12 ms, faster than 92.77% of C++ online submissions for How Many Numbers Are Smaller Than the Current Number.
//    Memory Usage: 8.4 MB, less than 100.00% of C++ online submissions for How Many Numbers Are Smaller Than the Current Number.
    vector<int> smallerNumbersThanCurrent2(vector<int>& nums) {
        vector<int> sortNums(nums);
        sort(sortNums.begin(), sortNums.end());
        vector<int> ret(nums.size());
        for(int i = 0 ; i < ret.size(); i++)
        {
//            auto it = lower_bound(sortNums.begin(), sortNums.end(), nums[i]);
//            ret[i] = it-sorted.begin();
            ret[i] = lower_bound(sortNums.begin(), sortNums.end(), nums[i]) - sortNums.begin();
        }
        return ret;
    }
};

void print(vector<int> input)
{
    for(int i = 0; i < input.size() - 1; i++)
        cout<<input[i]<<"->";
    cout<<input[input.size() - 1]<<endl;
}

int main() {
    vector<int> input({8,1,2,2,3});
    cout<<"#1: "<<endl;
    print(Solution().smallerNumbersThanCurrent(input));

    cout<<"#2: "<<endl;
    print(Solution().smallerNumbersThanCurrent2(input));
    return 0;
}
