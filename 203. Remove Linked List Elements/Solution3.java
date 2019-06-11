public class Solution3
{
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null)
        {
            return null;
        }
        ListNode res = removeElements(head.next, val);
        if(head.val == val)
        {
            return res;
        }
        else
        {
            head.next = res;
            return head;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,2,3,4,2,3};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution2()).removeElements(head, 2);
        System.out.println(res);
    }

}
