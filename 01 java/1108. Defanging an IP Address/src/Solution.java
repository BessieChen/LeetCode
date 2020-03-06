/**
 * @program: 1108. Defanging an IP Address
 * @description: https://leetcode.com/problems/defanging-an-ip-address/
 * @author: Bessie
 * @create: 2020-03-06 11:00
 **/
public class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]"); //TODO: 错误：address.replace('.', "[.]"); 一定要target也必须是String而不是char
    }

    public String defangIPaddr2(String address) {
        return address.replaceAll("\\.", "[.]");
    }

    public String defangIPaddr3(String address) {
        String s = "";
        for(char c : address.toCharArray())
        {
            s += "[.]" if 
        }
    }


    public static void main(String[] args)
    {

    }

}
