/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {

    
    /*
    method 3:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 34.4 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
    */
    public ListNode middleNode3(ListNode head) {
        int count = 0;
        ListNode cur = head;
        ListNode mid = head;
        while(cur != null)
        {
            if(count != 0 && count % 2 != 0)
            {
                mid = mid.next;
            }
            cur = cur.next;
            count++;
        }
        return mid;
    }
    
    
    
}
