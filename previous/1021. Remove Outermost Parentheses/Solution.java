import java.util.Stack;

public class Solution {
    public String removeOuterParentheses(String S) {
      
        StringBuilder res = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++)
        {
            if(S.charAt(i) == '(')
            {
                if(stack.empty()) //说明此时的"(”一定是一个outermost括号。
                {
                    stack.push('(');
                }
                else
                {
                    stack.push('(');
                    res.append('(');
                }
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
