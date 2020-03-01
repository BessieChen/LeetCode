/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public int[] nextLargerNodes(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null)
        {
            arr.add(cur.val);
            cur = cur.next;
        }
        
        int[] ret = new int[arr.size()];
        Stack<Integer> stack = new Stack<>();
        
        //遍历arr，要么push，要么pop进stack。注意进入出来的是arr的index，而不是arr的内容。
        for(int i = 0; i < arr.size(); i++ )
        {
            while(!stack.empty() && arr.get(stack.peek()) < arr.get(i))
            {
                ret[stack.pop()] = arr.get(i);//最上面的index已经找到了next greater node.可以pop了，并且ret中对应的index的答案就是arr.get(i);
            }
            stack.push(i);//push的是index。
        }
        
        return ret;
        
        
        
    }
}

