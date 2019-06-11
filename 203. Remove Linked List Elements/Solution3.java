public class Solution3
{
    public ListNode removeElements(ListNode head, int val)
    {
        if(head == null)
        {
            return null;
        }
        //method 1:
//         ListNode res = removeElements(head.next, val);
//         if(head.val == val)
//         {
//             return res;
//         }
//         else
//         {
//             head.next = res;
//             return head;
//         }
       //method 2:
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,2,3,4,2,3,4,2,3};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution3()).removeElements(head, 2);
        System.out.println(res);
    }

}
