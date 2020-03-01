import java.util.ArrayList;
import java.util.Stack;

//Definition for singly-linked list.
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

class Solution {
    public int[] nextLargerNodes(ListNode head) {

        /*
        1.首先先将listNode遍历，并且将所有元素存进array，因为不知道listNode的size
        所以使用java的动态数组
        
        2.注意，java动态数组只能装Integer，而不能装int。因为需要的是返回的是int[]，所以我们不能用stack来装动态数组中的Integer，所以我们还需要设一个arr2数组，装的是int，开辟静态大小是arr.size(). 然后用stack来装arr2中的int。哦不对，stack也只能装Integer，所以最好的方法是，将要返回的答案，也就是ret，先装Integer，最后再遍历转化成int。还是不对，stack装的Integer是index，所以直接让返回的答案，也就是ret，装int就好了。不需要现状Integer再遍历转化成int。
        
        3.采用笔记中的方法。使用stack。
        */

        ArrayList<Integer> arr = new ArrayList<>();
        ListNode cur = head;
        while(cur != null)
        {
            arr.add(cur.val);
            cur = cur.next;
        }

        int[] ret = new int[arr.size()];
        Stack<Integer> stack = new Stack<>();

        //遍历arr，要么pop，要么push进stack。注意进入出来的是arr的index，而不是arr的内容。todo 之所以是pop进去index是因为我们for loop遍历index比较容易。然后ret[xx]中xx也不是按从0-(size-1)的顺序来找到答案的。
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


// leetcode其他人答案
// public int[] nextLargerNodes(ListNode head) {
//         ArrayList<Integer> A = new ArrayList<>();
//         for (ListNode node = head; node != null; node = node.next)
//             A.add(node.val);
//         int[] res = new int[A.size()];
//         Stack<Integer> stack = new Stack<>();
//         for (int i = 0; i < A.size(); ++i) {
//             while (!stack.isEmpty() && A.get(stack.peek()) < A.get(i))
//                 res[stack.pop()] = A.get(i);
//             stack.push(i);
//         }
//         return res;
//     }