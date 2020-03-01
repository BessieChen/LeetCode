public class Solution2
{
    /*
    * 借鉴别人的更新想法：
    * 1. 之前的问题是，我们想用stack的结构来实现删除重复元素，但是最后剩余在stack里面的我们pop出来的顺序就是和原先顺序颠倒的了
    * 2. 现在我们可以不需要stack结构，依旧实现。那就是用arr，其中index指向第一个空元素。
    *    感觉很像我们设计的动态array中的removeLast()，我们不是真的remove掉了最后一个元素，而是让index--，之后想再add()的时候，直接把之前的元素覆盖就好了。
    *    这里也是，如果发现重复元素，那就index--，等价于我们删除了那个元素。之后需要push的时候，直接在index上加元素就好了
    * 3. 这里先采用StringBuilder来实现array的作用。
    *    其实也是挺蠢的，那就是：
    *    如果res是空的，那么没得说的，append(c)
    *    剩下情况就是res是非空的：
    *                         -- 如果最后一个元素和c一致，那就delete最后一个，c也不需要append了
    *                         -- 如果最后一个元素和c不一致，那就append(c)
    * 4. 主要是会使用StringBuilder：
    *    -- 长度： res.length()
    *    -- 查找最后一个： 也是res.charAt(i)
    *    -- 删除一个char： deleteCharAt(i)
    *
    * 5. 复习一个：for(char c : S.toCharArray())
    * */

    public String removeDuplicates(String S)
    {
        StringBuilder res = new StringBuilder();

        for(char c : S.toCharArray())
        {
            if(res.length() == 0)
                res.append(c);
            else if(res.charAt(res.length()-1) == c)
            {
                res.deleteCharAt(res.length()-1);
            }
            else
            {
                res.append(c);
            }
        }
        return res.toString();
    }
}
