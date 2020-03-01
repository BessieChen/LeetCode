public class Solution2 {
    public ListNode removeElements(ListNode head, int val)
    {
        while(head != null && head.val == val)
        {
            ListNode del = head;
            head = head.next;
            del.next = null;
        }

        if(head == null)
        {
            return null;
        }

        ListNode prev = head;
        while(prev.next != null)
        {
            if(prev.next.val == val)
            {
                ListNode del = prev.next;
                prev.next = del.next;
                del.next = null;
            }
            else
            {
                prev = prev.next;
            }
        }
        return head;
    }
    public static void main(String[] args)//注意：Leetcode不能提交这个static main，因为这里包含着我自己创建的新的ListNode(arr)的构建函数，但是LeetCode没有，所以就会报错。看来LeetCode会看你的main的代码的。
    {
        ListNode i = new ListNode(1);
        System.out.println(i != null);//验证了一直说的是i.val 是不是null，因为构建函数要求你一定要给val赋值，所以永远都是i != null；
        System.out.println(i.next == null);

        int[] arr = {1,2,3,4,3};
        ListNode aa = new ListNode(arr);

        for(ListNode result = (new Solution2()).removeElements(aa,3); result != null; result = result.next)
        {
            System.out.println(result.val);
        }

        int[] arr2 = {1,2,3,4,3,5,2};
        ListNode aa2 = new ListNode(arr2);

        ListNode res = (new Solution2()).removeElements(aa2,3);//调用了toString()函数
        System.out.println(res);
    }
}
