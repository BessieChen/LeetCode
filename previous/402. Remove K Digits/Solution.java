public class Solution {
    public String removeKdigits(String num, int k) {
        int remain = num.length() - k;
        char[] numArray = num.toCharArray(), res = new char[remain];
        int index = 0;
        for(int i = 0; i < numArray.length; i++) {

            while((numArray.length - i > remain - index) && (index > 0 && numArray[i] < res[index - 1])) index--;
            if(index < remain) res[index++] = numArray[i];
        }
        
        // check leading zeroes
        index = -1;
        while(++index < remain) {
            if(res[index] != '0') break;
        }
        String s = new String(res).substring(index);
        
        return s.length() == 0 ? "0" : s;
    }
}
