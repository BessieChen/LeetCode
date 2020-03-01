class Solution {
    public String removeDuplicates(String S) {
        return removeDuplicates1(S);
    }
    
    /*Array
    method 1:
    Runtime: 5 ms, faster than 95.47% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 38.1 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    */
    private String removeDuplicates1(String S) {
        char[] stack = new char[S.length()];
        int size = 0;
        
        for(char c : S.toCharArray())
        {
            if(size == 0 || (size > 0 && c != stack[size-1]))
                stack[size++] = c;
            else if(c == stack[size-1])
                size--;
        }
        return new String(stack, 0, size);
    }
    
    
    /*Stack
    method 2.1:
    Runtime: 64 ms, faster than 32.66% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    
    method 2.2:
    Runtime: 40 ms, faster than 55.71% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 38.5 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    */
    private String removeDuplicates2(String S) {
        Stack<Character> stack = new Stack<>();
        
        for(char c : S.toCharArray())
        {
            if(stack.empty() || (!stack.empty() && c != stack.peek()))
                stack.push(c);
            else if(c == stack.peek())
                stack.pop();
        }
        
        StringBuilder ret = new StringBuilder();
        
        //method 1:
        // while(!stack.empty())
        // {ret.append(stack.pop());}
        // return ret.reverse().toString();
        
        //method 2:
        for(char c : stack){ret.append(c);}//第一个char c是stack的底部。
        return ret.toString();  
    }
    
    
    /*Queue
    method 3.1:
    Runtime: 15 ms, faster than 71.97% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    method 3.2:
    Runtime: 18 ms, faster than 69.59% of Java online submissions for Remove All Adjacent Duplicates In String.
    Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Remove All Adjacent Duplicates In String.
    */
    private String removeDuplicates3(String S)
    {
        Deque<Character> queue = new ArrayDeque<>();
        for(char c : S.toCharArray())
        {
            if(queue.isEmpty() || (!queue.isEmpty() && c != queue.peekLast()))
                queue.offer(c);
            else if(c == queue.peekLast())
                queue.pollLast();
        }
        StringBuilder ret = new StringBuilder();
        
        //method 1:
        for(char c : queue) ret.append(c);
        
        //method 2:
        // while(!queue.isEmpty()) ret.append(queue.pollFirst());
        
        return ret.toString();
    }
    
}
