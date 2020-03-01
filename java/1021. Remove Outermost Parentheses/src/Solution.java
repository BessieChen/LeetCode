import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String S) {
        /*
        我的想法：
        那就是你会发现，当找到匹配的()，pop完之后stack.size() == 0的时候
        那就是找到一个outer括号的时候。例如：
        ( () () )这里有一个outermost括号
        ( () )( (() ()) )这里有两个outermost括号
        不过都是pop完之后stack.size() == 0的时候
        因为题目要返回的是里面的括号。我的方法：
        当pop完的stack.size() != 0的时候，我们string上面append一次"()"//但这个后面被证明是错的，详情参见正确算法。

        这里我假设题目不会给那种不匹配的情况。所以我就不进行是否匹配的判断。因为这个判断可以见第20题。
        */

        //第一次错误：
        /*
        input : "(()())(())(()(()))"
        output: "()()()()()()"
        expected:"()()()()(())"

        错在了，我以为pop完如果stack.size() != 0就可以res.append("()"),可是忘记了这种(())
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++)
        {
            if(S.charAt(i) == '(')
                stack.push('(');
            else
            {
                stack.pop();
                if(stack.size() != 0)
                {
                    res.append("()");
                }
            }
        }
        return res.toString();
        */

        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++) //for(char c : S.toCharArray())
        {
            if(S.charAt(i) == '(')
            {
                if(!stack.empty()) //说明此时的"(”一定是一个outermost括号。
                {
                    res.append('(');
                }
                stack.push('(');
            }
            else
            {
                stack.pop();
                if(!stack.empty())//说明此时pop的')'不是outermost括号。
                {
                    res.append(')');
                }
            }
        }
        return res.toString();
    }
}
