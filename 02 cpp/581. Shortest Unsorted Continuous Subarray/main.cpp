#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int findUnsortedSubarray2(vector<int>& nums) {
        vector<int> copy(nums);
        sort(copy.begin(), copy.end());
        int startIndex;
        int endIndex;
        bool find = false;
        for(int i = 0 ; i < nums.size(); i++)
        {
            if(copy[i] == nums[i])
                continue;
            else
            {
                startIndex = i;
                find = true;
                break;
            }
        }
        for(int i = nums.size()-1; i >= 0 ; i--)
        {
            if(copy[i] == nums[i])
                continue;
            else
            {
                endIndex = i;
                find = true;
                break;
            }
        }

        return find? endIndex - startIndex + 1 : 0;
    }

    int findUnsortedSubarray(vector<int>& nums) //O(n)
    {
        int start = -1;
        int end = -1;
        int minInRange = INT_MAX; //start和end包括在Range里面
        int maxInRange = INT_MIN;

        for(int i = 0 ; i < nums.size()-1; i++)
        {
            if(nums[i] > nums[i+1]){
                if(start == -1)
                    start = i;
                end = i+1;
                minInRange = min(minInRange, nums[i+1]); //注意：end可能是最小值
                maxInRange = max(maxInRange, nums[i]); //注意：start可能是最大值
            }
        }

        if(start == -1) return 0;
        for(int i = 0; i < start; i++){
            if(nums[i] > minInRange)
            {
                start = min(start, i);
            }
        }

        for(int i = end+1; i < nums.size(); i++){
            if(nums[i] < maxInRange){
                end = max(end, i);
            }
        }

        return end - start + 1;
    }
};

int main() {
    vector<int> input = {2,3,4,5,4,3,2,1,6,7};
    cout<<Solution().findUnsortedSubarray(input)<<endl;//expected: 8
    cout<<Solution().findUnsortedSubarray2(input)<<endl;
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
