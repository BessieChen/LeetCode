public class Solution2
{
    public ListNode removeElements(ListNode head, int val)
    {
        ListNode dummyHead = new ListNode(-1);

        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null)
        {
            if(prev.next.val == val)
            {
                prev.next = prev.next.next;
            }
            else
            {
                prev = prev.next;
            }
        }
        return dummyHead.next;
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