public class Solution4 {
    public ListNode removeElements(ListNode head, int val)
    {
        while(head != null && head.val == val)
        {
            head = head.next;
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
                prev.next = prev.next.next;
            }
            else
            {
                prev = prev.next;
            }
        }
        return head;
    }
}

//如果从dummyHead开始的话：其实所有关于head的判断部分都可以没有了，其实这个反而更简单：
class Solution_dummy4 {
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
}
