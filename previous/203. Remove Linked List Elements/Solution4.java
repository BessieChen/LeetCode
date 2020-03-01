public class Solution4
{
    public ListNode removeElements(ListNode head, int val)
    {

        while(head != null && head.val == val)
        {
            ListNode del = head;
            head = del.next;
            del.next = null;
        }
        if(head == null)
        {
            return null;
        }

        for(ListNode cur = head.next, prev = head; cur != null; )
        {
            if(cur.val == val)
            {
                ListNode del = cur;
                prev.next = cur.next;
                cur = cur.next;
                del.next = null;
            }
            else
            {
                cur = cur.next;
                prev = prev.next;
            }
        }
        return head;
    }


    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,3};
        ListNode aa = new ListNode(arr);

        for(ListNode result = (new Solution4()).removeElements(aa,3); result != null; result = result.next)
        {
            System.out.println(result.val);
        }

        int[] arr2 = {1,2,3,4,3,5,2};
        ListNode aa2 = new ListNode(arr2);

        ListNode res = (new Solution4()).removeElements(aa2,3);//调用了toString()函数
        System.out.println(res);

    }

}
