import re
class Solution:
    '''Runtime: 28 ms, faster than 56.98% of Python3 online submissions for Defanging an IP Address.
    Memory Usage: 12.7 MB, less than 100.00% of Python3 online submissions for Defanging an IP Address.'''
    def defangIPaddr(self, address: str) -> str:
        return address.replace('.', "[.]")

    # def defangIPaddr2(self, address: str) -> str:
    #     return address.replaceAll('\\.', "[.]")

    '''Runtime: 16 ms, faster than 99.49% of Python3 online submissions for Defanging an IP Address.
    Memory Usage: 12.8 MB, less than 100.00% of Python3 online submissions for Defanging an IP Address.'''
    def defangIPaddr2(self, address: str) -> str:
        return "[.]".join(address.split("."))

    '''Runtime: 28 ms, faster than 56.98% of Python3 online submissions for Defanging an IP Address.
    Memory Usage: 12.7 MB, less than 100.00% of Python3 online submissions for Defanging an IP Address.'''
    def defangIPaddr3(self, address: str) -> str:
        return "".join(["[.]" if e == '.' else e for e in address])

    '''Runtime: 28 ms, faster than 56.98% of Python3 online submissions for Defanging an IP Address.
    Memory Usage: 12.7 MB, less than 100.00% of Python3 online submissions for Defanging an IP Address.'''
    def defangIPaddr4(self, address: str) -> str:
        return re.sub("\.", "[.]", address)

    '''Runtime: 28 ms, faster than 56.98% of Python3 online submissions for Defanging an IP Address.
    Memory Usage: 12.6 MB, less than 100.00% of Python3 online submissions for Defanging an IP Address.'''
    def defangIPaddr5(self, address: str) -> str:
        s = ""
        for c in address:
            if c == '.':
                s += "[.]"
            else:
                s += c
        return s

if __name__ == "__main__":
    s = "255.100.50.0" #255[.]100[.]50[.]0
    print("#1:", Solution().defangIPaddr(s))
    print("#2:", Solution().defangIPaddr2(s))
    print("#3:", Solution().defangIPaddr3(s))
    print("#4:", Solution().defangIPaddr4(s))
    print("#5:", Solution().defangIPaddr5(s))


'''
不需要正则：
str.replace()
str.split()

需要正则：
re.sub()
'''



