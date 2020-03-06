#include <iostream>
#include <string>

using namespace std;

class Solution{
public:
//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Defanging an IP Address.
//    Memory Usage: 7.3 MB, less than 100.00% of C++ online submissions for Defanging an IP Address.
    string defangIPaddr(string address) {
        string s = "";
        for(const char& c : address)
        {
            if( c == '.')
            {
                s += "[.]";
            } else{
                s += c;
            }
        }
        return s;
    }
    /* 不能用三目：
    string defangIPaddr6(string address) {
        string s = "";
        for(char c : address)
        {
            这个不报错，但是不是我们要的：s += (c == '.') ? 'x' : c;
            这个报错：s += (c == '.') ? "[.]" : c; //? 处报错：incompatible operand types for const char* and char, 其中 const char* 指的是 "[.]", char 指的是 c 或者 '.'
        }
        return s;
    }
     */

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Defanging an IP Address.
//    Memory Usage: 7.3 MB, less than 100.00% of C++ online submissions for Defanging an IP Address.
    string defangIPaddr2(string address) {
        for(int i = 0 ; i < address.size(); )
        {
            if(address[i] == '.')
            {
                address.replace(i, 1, "[.]");
                i += 2;
            } else{
                i++;
            }
        }
        return address;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Defanging an IP Address.
//    Memory Usage: 7.6 MB, less than 100.00% of C++ online submissions for Defanging an IP Address.
    string defangIPaddr3(string address) {
        for(int i = address.size()-1; i >= 0 ; i --)
        {
            if(address.at(i) == '.')
            {
                address.replace(i, 1, "[.]");
            }
        }
        return address;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Defanging an IP Address.
//    Memory Usage: 7.4 MB, less than 100.00% of C++ online submissions for Defanging an IP Address.
    string defangIPaddr4(string address) {
        for(int i = 1; i < address.size(); )
        {
            if(address.at(i) == '.')
            {
                address = address.substr(0, i) + "[.]" + address.substr(i+1);
                i += 3;
            }
            else i++;
        }
        return address;
    }

//    Runtime: 0 ms, faster than 100.00% of C++ online submissions for Defanging an IP Address.
//    Memory Usage: 7.7 MB, less than 100.00% of C++ online submissions for Defanging an IP Address.
    string defangIPaddr5(string address) {
        for(int i = address.size()-2; i >= 0 ; i--)
        {
            if(address.at(i) == '.')
            {
                address = address.substr(0, i) + "[.]" + address.substr(i+1);
            }
        }
        return address;
    }
};

void testString()
{
    string test = "abc";
    cout<<test.size()<<endl;
    cout<<test[test.size()]<<endl;
}
int main() {
    testString();
    string s = "255.100.50.0";
    cout<<"#1: "<<Solution().defangIPaddr(s)<<endl;
    cout<<"#2: "<<Solution().defangIPaddr2(s)<<endl;
    cout<<"#3: "<<Solution().defangIPaddr3(s)<<endl;
    cout<<"#4: "<<Solution().defangIPaddr4(s)<<endl;
    cout<<"#5: "<<Solution().defangIPaddr5(s)<<endl;
    return 0;
}
