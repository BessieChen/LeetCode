public class Solution3 {
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

        for(ListNode cur = head.next, prev = head; cur != null;)
        {
            if(cur.val == val)
            {
                prev.next = cur.next;
                cur = cur.next;
            }
            else
            {
                prev = prev.next;
                cur = cur.next;
            }
        }

        return head;
    }
}

//如果从dummyHead开始的话：其实所有关于head的判断部分都可以没有了，其实这个反而更简单：
class Solution_dummy3 {
    public ListNode removeElements(ListNode head, int val)
    {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        for(ListNode cur = dummyHead.next, prev = dummyHead; cur != null;)
        {
            if(cur.val == val)
            {
                prev.next = cur.next;
                cur = cur.next;
            }
            else
            {
                prev = prev.next;
                cur = cur.next;
            }
        }

        return dummyHead.next;//别忘了是next！
    }
}