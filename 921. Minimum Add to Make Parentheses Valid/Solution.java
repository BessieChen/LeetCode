public class Solution {

    /*
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    */
    public int minAddToMakeValid(String S) {
        int len = S.length();
        char[] arr = new char[len];
        int size = 0;

        for(char c : S.toCharArray())
        {
            //method 1:
/*            if(size == 0)
            {
                arr[size++] = c;
            }
            else if(arr[size-1] == '(' && c == ')')
            {
                size--;
            }
            else
            {
                arr[size++] = c;
            }*/

            //method 2: method 1的第一个if和最后一个else的内容重复arr[size++] == c;
            if(size >= 1 && arr[size-1] == '(' && c == ')')
            {
                size--;
            }
            else
            {
                arr[size++] = c;
            }
        }
        return size;//这里不需要size + 1，因为本身size就说明了arr中剩余多少元素。
    }
}
