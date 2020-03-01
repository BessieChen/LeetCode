public class Solution6 {
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null)
        {
            return null;
        }
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;//这个写的真的很厉害！
    }

    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,3};
        ListNode aa = new ListNode(arr);

        for(ListNode result = (new Solution6()).removeElements(aa,3); result != null; result = result.next)
        {
            System.out.println(result.val);
        }

        int[] arr2 = {1,2,3,4,3,5,2};
        ListNode aa2 = new ListNode(arr2);

        ListNode res = (new Solution6()).removeElements(aa2,3);//调用了toString()函数
        System.out.println(res);

    }
}
