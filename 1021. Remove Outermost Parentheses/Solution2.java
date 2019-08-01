public class Solution2 {

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
