#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool checkPossibility(vector<int>& nums) {
        int cnt = 0;
        for(int i = 0; i < nums.size()-1; i++)
        {
            if(nums[i] <= nums[i+1])
                continue;
            else if(cnt == 0)
            {
                if(i-1 >= 0)
                {
                    if(nums[i-1] > nums[i+1]) nums[i+1] = nums[i]; // case 2
                    else nums[i] = nums[i+1];     // case 1
                }
                else nums[i] = nums[i+1]; //case 3

                cnt ++;
            }
            else return false;
        }
        return true;
    }
};



int main() {
    vector<int> input = {3,4,2,3};
    std::cout << Solution().checkPossibility(input)<<endl; //false;
    return 0;
}
