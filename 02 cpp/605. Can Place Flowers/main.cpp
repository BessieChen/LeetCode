#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    bool canPlaceFlowers2(vector<int>& f, int n) {
        int cnt = 0;
        for(int i = 0; i < f.size(); i++)
        {
            if(f[i] == 0 && (i == 0 || f[i-1] != 1) && (i == f.size()-1 || f[i+1] != 1))
                //这里说的是：需要看左右的位置有没有种花，但是如果index是0，就不需要看左边，如果index是最后一个，就不需要看右边。
                //注意不能写成：f[i] == 0 && (i-1>=0 && f[i-1] != 1)//因为我们不是要保证 f[i-1]的index的合法性。
            {
                f[i] = 1;
                cnt ++;
                i++; //因为种了一朵花，就应该走两步，而不是走一步。
            }
            if(cnt >= n) return true;
        }
        return false;
    }

    bool canPlaceFlowers(vector<int>& flowerbed, int n) {
        int current = 0; const int size = flowerbed.size();
        for(int i = 0; i <= size; i++) {
            if (i < size && flowerbed[i] == 0) {
                current++;
                if (i == 0) current++;
                if (i == size - 1) current++;
            } else {
                n -= (current - 1) / 2;
                if (n <= 0) return true;
                current = 0;
            }
        }
        return false;
    }
};

int main() {
    vector<int> input = {1,0,0,1,0,1};
    int n = 2;
    cout<<Solution().canPlaceFlowers(input, n)<<endl; //false
    cout<<Solution().canPlaceFlowers2(input, n)<<endl; //false
    //std::cout << "Hello, World!" << std::endl;
    return 0;
}
