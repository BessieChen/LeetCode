/**
 * @program: 1108. Defanging an IP Address
 * @description: https://leetcode.com/problems/defanging-an-ip-address/
 * @author: Bessie
 * @create: 2020-03-06 11:00
 **/
public class Solution {
//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
//    Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]"); //TODO: 错误：address.replace('.', "[.]"); 一定要target也必须是String而不是char
    }

//    Runtime: 2 ms, faster than 34.68% of Java online submissions for Defanging an IP Address.
//    Memory Usage: 38 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");// "\." -> "."
    }

//    Runtime: 1 ms, faster than 41.74% of Java online submissions for Defanging an IP Address.
//    Memory Usage: 37.7 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    public String defangIPaddr3(String address) {
        String s = "";
        for(char c : address.toCharArray())
        {
            s += c == '.' ? "[.]" : c;
        }
        return s;
    }

//    Runtime: 0 ms, faster than 100.00% of Java online submissions for Defanging an IP Address.
//    Memory Usage: 37.8 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    public String defangIPaddr4(String address) {
        StringBuilder s = new StringBuilder();
        for(char c : address.toCharArray())
        {
            s.append(c == '.' ? "[.]" : c);
        }
        return s.toString();
    }

//    Runtime: 1 ms, faster than 41.74% of Java online submissions for Defanging an IP Address.
//    Memory Usage: 37.5 MB, less than 100.00% of Java online submissions for Defanging an IP Address.
    public String defangIPaddr5(String address) {
        return String.join("[.]", address.split("\\."));
    }

    public static void main(String[] args)
    {
        String s = "255.100.50.0";
        System.out.println("#1: "+ new Solution().defangIPaddr(s));
        System.out.println("#1: "+ new Solution().defangIPaddr2(s));
        System.out.println("#1: "+ new Solution().defangIPaddr3(s));
        System.out.println("#1: "+ new Solution().defangIPaddr4(s));
        System.out.println("#1: "+ new Solution().defangIPaddr5(s));
    }

}
