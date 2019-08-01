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
