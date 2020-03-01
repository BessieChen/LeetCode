import java.util.Stack;

class SolutionAll {

    /*
    method 1:
    Runtime: 2 ms, faster than 39.55% of Java online submissions for Minimum Add to Make Parentheses Valid.
    Memory Usage: 34.6 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.*/
    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();

        for(char c : S.toCharArray())
        {
            if(c == '(')
            {
                stack.push(c);
            }
            else
            {
                if(!stack.empty() && stack.peek() == '(') stack.pop();
                else stack.push(c);
            }
        }
        return stack.size();
    }

    /*
    method 2:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    Memory Usage: 34.2 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    */
    public int minAddToMakeValid2(String S) {
        int unbal = 0;
        int neg = 0;
        for(char c : S.toCharArray())
        {
            if(c == '(')
                unbal++;
            else
            {
                unbal--;
                if(unbal < 0)
                {
                    neg++;
                    unbal = 0;
                }
            }
        }
        return unbal + neg;
    }

    /*
    method 3:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    Memory Usage: 34.5 MB, less than 100.00% of Java online submissions for Minimum Add to Make Parentheses Valid.
    */
    public int minAddToMakeValid3(String S) {
        char[] arr = new char[S.length()];
        int size = 0;
        for(char c : S.toCharArray())
        {
            if(c == '(')
            {
                arr[size++] = c;
            }
            else
            {
                if(size > 0 && arr[size-1] == '(')
                    size--;
                else
                    arr[size++] = c;
            }
        }
        return size;
    }

}