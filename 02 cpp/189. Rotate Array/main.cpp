#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void rotate2(vector<int>& nums, int k) {
        k = k % nums.size();
        if(k == 0) return;//小心k需要加工一下。不然会TLE

        vector<int> result;
        int size = nums.size();
        for(int i = 0; i < size; i++){
            int index = i - k >= 0? i - k  : i - k + size;
            //不能用这个，因为负数求模是负数：index = (i - k) % size;
            cout<<index<<endl;
            result.push_back(nums[index]);//因为是个像右移动，所以原先的偏左，结果偏右。所以结果的第i个，对应的是原先里面偏左的那个，所以是 i - k;
        }
        nums = result;
    }

    //最慢的做法：O(k*n), O(1): TLE
    void rotate3(vector<int>& nums, int k){
        k = k % nums.size();
        if(k == 0) return;

        for(int i = 0; i < k ; i++){
            int previous = nums[nums.size()-1];
            for(int j = 0; j < nums.size(); j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
    }


    void rotate4(vector<int>& nums, int k){
        k = k % nums.size();
        if(k == 0) return;

        vector<int> result(nums.size());
        for(int i = 0 ; i < nums.size(); i++){
            result[(i+k) % nums.size()] = nums[i];
            //不能用：result[i] = nums[(i - k) % nums.size()] //因为负数的模依旧是负数。
        }
        nums = result;
    }

    //super fast!
    /*
    Runtime: 8 ms, faster than 99.21% of C++ online submissions for Rotate Array.
    Memory Usage: 9.9 MB, less than 22.22% of C++ online submissions for Rotate Array.
    */
    void rotate5(vector<int>& nums, int k){
        k = k % nums.size();
        if(k == 0) return;

        //如果需要向左移动k位，那就是可以:
        //k = nums.size() - k;

        int start_index = 0;//起始点
        int count = 0;//完成转移的元素的个数

        /*
        以下这些不能写在for loop外面，因为有可能要更新起始点的索引start_index，一旦更新了，那所有的cur_index，等四个元素都要根据新的start_index更新
        int cur_index = 0;//要发送的元素的index
        int next_index = (cur_index + k) % nums.size();//即将被挤走的元素的index

        int cur_ele = nums[cur_index];//要发送的元素
        int next_ele = nums[next_index];//即将被挤走的元素
        */

        for(; count < nums.size(); start_index++)
        {
            int cur_index = start_index;//要发送的元素的index
            int next_index = (cur_index + k) % nums.size();//即将被挤走的元素的index

            int cur_ele = nums[cur_index];//要发送的元素
            int next_ele = nums[next_index];//即将被挤走的元素
            do{
                //进行交换：
                nums[next_index] = cur_ele;
                count++;

                //指向下k个元素：
                cur_ele = next_ele;//之前被挤走的元素next_ele,现在变成要发送的元素
                cur_index = next_index;
                next_index = (cur_index + k) % nums.size();

                //不能这么写，因为之前nums[next_index] = cur_ele, 如果继续cur_index = next_index，cur_ele = nums[cur_index]，你会发现cur_ele根本没变！
                // cur_ele = nums[cur_index];//要发送的元素
                // next_ele = nums[next_index];//即将被挤走的元素

                //之前被挤走的元素next_ele变成了新的要发送的元素
                cur_ele = next_ele;

                //记录新的即将被挤走的元素
                next_ele = nums[next_index];

            }
            while(cur_index != start_index && count < nums.size());//当要发送的元素的索引cur_index，又变成了起始点的index，就终止。因为如果要发送的元素又是原先起始点，说明你要兜第二圈。
            //注意不能写成：while(next_index != start_index)（这里的语意是：被接受的元素的索引不能是起始点，可实际上是可以的！）
            //注意需要一个新的条件(count < nums.size())，可以提前终止循环。否则像是case01，可能即便都完成了任务，但依旧cur_index != start_index
        }

        /*
        case01:
        [-1,-100,3]
        2*/

    }

    void rotate(vector<int>& nums, int k){
        k = k % nums.size();
        if(k == 0) return;

        //如果需要向左移动k位，那就是可以:
        //k = nums.size() - k;

        reverse(nums, 0, nums.size()-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.size()-1);
    }

    void reverse(vector<int>& nums, int b, int e)
    {
        //方法1：
        // int len = e - b + 1;
        // for(int i = 0; i < len/2; i++)
        // {
        //     int temp = nums[b+i];
        //     nums[b+i] = nums[b+(len-1)-i];
        //     nums[b+(len-1)-i] = temp;
        // }

        //方法二：简单
        while(b < e)
        {
            int temp = nums[b];
            nums[b] = nums[e];
            nums[e] = temp;
            e--;
            b++;
        }
    }

};

int main() {
    std::cout << "Hello, World!" << std::endl;
    return 0;
}
