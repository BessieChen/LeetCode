import java.util.Stack;

public class Solution {
    public String removeDuplicates(String S) {
        Stack<Character> stack = new Stack<>();
        for(char c : S.toCharArray())
        {
            if(stack.empty() || c != stack.peek())
            {
                stack.push(c);
            }
            else
            {
                stack.pop();
            }
        }

        //不能这么return： return stack.toString();因为假如答案是"ca", 你输出的会是："[c, a]"
        //第一次犯错：
        /*
        这么写的话：
        input : "abbaca"
        output: "ac"
        expected: "ca"
        错误部分：
        StringBuilder res = new StringBuilder();
        while(!stack.empty())
        {
            res.append(stack.pop());
        }
        return res.toString();

        */

        //我的方法很蠢，那就是用另一个stack再倒一次。
        Stack<Character> stack2 = new Stack<>();
        StringBuilder res = new StringBuilder();
        while(!stack.empty())
        {
            stack2.push(stack.pop());
        }
        while(!stack2.empty())
        {
            res.append(stack2.pop());
        }
        return res.toString();

    }
}

