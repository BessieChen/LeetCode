public class Solution
{
    public ListNode removeElements_old2(ListNode head, int val)
    {
        while(head!=null && head.val == val)
        {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if(head == null)
        {
            return head;
        }

        ListNode prev = head;//找到待删除的前一个。
        while(prev.next != null)
        {
            if(prev.next.val == val)
            {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            else
            {
                prev = prev.next;
            }
        }

        return head;
    }


    public ListNode removeElements(ListNode head, int val)
    {
        while(head!=null && head.val == val)
        {
            head = head.next;
        }

        if(head == null)
        {
            return head;
        }

        ListNode prev = head;//找到待删除的前一个。
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

        return head;
    }

    public static void main(String[] args)
    {
        int[] nums = {2,2,1,2,3,4,2,3,4,2,3,2,3,5};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution()).removeElements(head, 2);
        System.out.println(res);
    }
}