/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution2 {
    /*
    method 1:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 34.1 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
    */
    public ListNode middleNode(ListNode head) {
        int count = 0;
        ListNode cur = head;
        while(cur != null)
        {
            count++;
            cur = cur.next;
        }
        
        if(count == 1 || count == 0) return head;
        int half = count / 2;
        cur = head;
        
        for(int i = 0; i < half; i++)
        {
            cur = cur.next;
        }
        return cur;
    }
