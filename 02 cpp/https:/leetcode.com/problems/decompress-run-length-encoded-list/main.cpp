//https://leetcode.com/problems/decompress-run-length-encoded-list/
#include <iostream>
#include <vector>

using namespace std;

class Solution{
public:
    //Complexity: Time - O(n), and Space - O(1)
    //insert(end, times, value):  For each pair of the form (a, b), append 'b' to the resulting vector 'a' tim
//    Runtime: 36 ms, faster than 99.93% of C++ online submissions for Decompress Run-Length Encoded List.
//    Memory Usage: 10 MB, less than 100.00% of C++ online submissions for Decompress Run-Length Encoded List.
    vector<int> decompressRLElist(vector<int>& nums) {
        vector<int> ret;
        for(int i = 0; i < nums.size(); i += 2)
        {
            ret.insert(ret.end(), nums[i], nums[i+1]);
        }
        return ret;
    }

    //Complexity: Time - O(n), and Space - O(1)
//    Runtime: 40 ms, faster than 98.49% of C++ online submissions for Decompress Run-Length Encoded List.
//    Memory Usage: 9.9 MB, less than 100.00% of C++ online submissions for Decompress Run-Length Encoded List.
    vector<int> decompressRLElist2(vector<int>& nums) {
        vector<int> ret;
        for(int i = 0; i < nums.size(); i += 2)
        {
            for(int j = 0; j < nums[i]; j++)
                ret.push_back(nums[i+1]);
        }
        return ret;
    }

    //Complexity: Time - O(n), and Space - O(1)
    vector<int> decompressRLElist3(vector<int>& nums) {
        vector<int> ret;
        for(int i = 0; i < nums.size()/2 ; i++)
        {
            for(int j = 0; j < nums[i*2]; j++)
                ret.push_back(nums[i*2+1]);
        }
        return ret;
    }
};

//Runtime: 40 ms, faster than 98.49% of C++ online submissions for Decompress Run-Length Encoded List.
//Memory Usage: 9.8 MB, less than 100.00% of C++ online submissions for Decompress Run-Length Encoded List.
void print(vector<int> input)
{
    cout<<"Print result: ";
    for(int i = 0; i < input.size(); i++)
    {
        cout<<input.at(i);
        if(i != input.size()-1)
            cout<<", ";
    }
    cout<<endl;
}

int main() {
    vector<int> input = {3,4,2,1,4,5};
    vector<int> ret = Solution().decompressRLElist(input);
    print(ret);

    vector<int> ret2 = Solution().decompressRLElist2(input);
    print(ret2);

    vector<int> ret3 = Solution().decompressRLElist3(input);
    print(ret3);
    return 0;
}
