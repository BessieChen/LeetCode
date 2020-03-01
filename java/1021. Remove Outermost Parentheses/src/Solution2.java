public class Solution2 {

    //借鉴别人的，做几点提升：
    /*
    * 1.首先，不需要for(int i = 0; i < S.length(); i++) 在char c = S.charAt(i) 太慢了。而是直接
    *   for(char c : S.toCharArray() )
    * 2.这一道题目，不需要使用stack，因为你需要的操作就是简单的：
    *   是 '(' 就push
    *   是 ')' 就pop
    *   当然也要看stack.size() == 0吗？所以其实只需要一个计数器，记录目前有几个元素就可以了。不需要设置stack
    *   */

    public String removeOuterParentheses(String S) {
        StringBuilder res = new StringBuilder();

        int count = 0;
        for(char c : S.toCharArray())
        {
            if(c == '(' && count++ != 0) res.append('('); //等价于：如果是(并且stack中已经有元素了, 说明这个(就不是outermost，可以append。并且之后多记录一个元素count++;
            if(c == ')' && --count != 0) res.append(')'); //等价于：找到了一对，--count意味着 stack中pop了那个(, 如果pop完了stack中还是有元素，即--count != 0, 说明这个)就不是outermost，可以append
        }
        return res.toString();
    }
}


//以下是别人的原文。
/*
* public String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) s.append(c);
            if (c == ')' && opened-- > 1) s.append(c);
        }
        return s.toString();
    }
*/