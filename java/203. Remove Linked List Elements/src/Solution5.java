public class Solution5 {
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null)
        {
            return null;
        }
        if(head.val == val)
        {
            head = removeElements(head.next, val);
        }
        else if(head.val != val)
        {
            head.next = removeElements(head.next, val);
        }
        return head;
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,3};
        ListNode aa = new ListNode(arr);

        for(ListNode result = (new Solution5()).removeElements(aa,3); result != null; result = result.next)
        {
            System.out.println(result.val);
        }

        int[] arr2 = {1,2,3,4,3,5,2};
        ListNode aa2 = new ListNode(arr2);

        ListNode res = (new Solution5()).removeElements(aa2,3);//调用了toString()函数
        System.out.println(res);

    }
}
