public class Solution3 {

    /*
    * 刚刚的Solution2还是由于用了一个StringBuilder会比较慢。
    * 别人的方法，真的还是很快的，那就是采用array数组。不过我的最快！
    * 但是有几点需要注意的：
    * 1. 我之前没有采用数组是因为。感觉只能用动态数组。其实用静态数组也可以，因为已经知道S.length()
    * 2. 既然用了静态数组，那么应该怎么add和remove呢？你也是蠢，你难道忘了，我们是需要设置一个size，也就是指向第一个待添加元素的位置 吗？
    *
    * 3. 最后将char[]转化为String的方法是，使用String的构造函数：
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
            //method 1:
//            if(size == 0)
//                arr[size++] = c;
//            else if(arr[size-1] == c)
//            {
//                size--;
//            }
//            else
//            {
//                arr[size++] = c;
//            }

            //method 2: 上面method 1有两个if主体里面是arr[size++] = c; 太累赘了。可以写成：
            if(size > 0 && arr[size - 1] == c)
            {
                size--;
            }
            else
            {
                arr[size++] = c;
            }

        }
        //所以到了这一步，你的size位置可能还会残留元素，不过没有关系，我们只需要使用从 [0, size-1]部分就可以了。但是注意
        //这里size也可能是0，例如：S = "aaaaa", 那么就res = "", 也就是size == 0。
        //但是我们的new String构造函数，只是需要startIndex = 0， 以及新的String的长度，也就是我们这里的size。就是res的长度。
        return new String(arr, 0, size);
    }


}

/*
*     public String removeDuplicates(String S) {
        int i = 0, n = S.length();
        char[] stack = new char[n];
        for (int j = 0; j < n; ++j)
            if (i > 0 && stack[i - 1] == S.charAt(j))
                --i;
            else
                stack[i++] = S.charAt(j);
        return new String(stack, 0, i);
    }
    * */