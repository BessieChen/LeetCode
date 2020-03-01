import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        boolean valid = true;
        Stack<Character> stack_of_char = new Stack<>();
        for(int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{')
            {
                stack_of_char.push(c);
            }
            else
            {
                if(stack_of_char.empty())
                {
                    valid = false;
                }
                else if(stack_of_char.peek()=='(' && c == ')'
                        || stack_of_char.peek() == '[' && c == ']'
                        || stack_of_char.peek() == '{' && c == '}')
                {
                    stack_of_char.pop();
                }
                else {
                    valid = false;
                }
            }
        }
        if(!stack_of_char.empty())
        {
            valid = false;
        }
        return valid;
    }

    public static void main(String[] args)
    {
        System.out.println((new Solution()).isValid("()[]{}"));
        System.out.println((new Solution()).isValid("([]{}"));
    }
}
