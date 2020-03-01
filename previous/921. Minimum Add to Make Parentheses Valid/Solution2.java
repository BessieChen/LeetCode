import java.util.Stack;

public class Solution2{

    /*
    * Runtime: 2 ms, faster than 40.11% of Java online submissions for Minimum Add to Make Parentheses Valid.
    Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    * */

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray())
        {

            //method 1:
            /*if(stack.empty() || c == '(')
            {
                stack.push(c);
            }
            else if(c == ')' && stack.peek() == '(')
            {
                stack.pop();
            }
            else//stack.peek == ')' && c == '(';
            {
                stack.push(c);
            }
            */

            //method 2:
            if(!stack.empty() && c == ')' && stack.peek() == '(')
            {
                stack.pop();
            }
            else//stack.peek == ')' && c == '(';
            {
                stack.push(c);
            }
        }
        return stack.size();
    }
}
