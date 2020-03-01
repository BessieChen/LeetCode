public class Solution3 {

    /*
    * 最后将char[]转化为String的方法是，使用String的构造函数：
    * • String (char [] chArr, int startIndex, int count):
    * It constructs a new String object whose contents are the same as
    * the character array, chArr,
    * starting from index startlndex upto a maximum of count characters.
    * For example: Consider the following statements
    * char[] str = {'W','e','l','c','o','m','e'};
    * String s3 = new String(str,5,2);
    * */


    /*
    * Runtime: 4 ms, faster than 98.17% of Java online submissions for Remove All Adjacent Duplicates In String.
    * Memory Usage: 37.6 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    * */

    public String removeDuplicates(String S) {
        int len = S.length();

        char[] arr = new char[len];
        int size = 0;

        for(char c : S.toCharArray())
        {
            if(size > 0 && arr[size - 1] == c)
            {
                size--;
            }
            else
            {
                arr[size++] = c;
            }

        }
        return new String(arr, 0, size);
    }


}
