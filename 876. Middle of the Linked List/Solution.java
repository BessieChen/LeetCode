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
    method 2:
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Middle of the Linked List.
    Memory Usage: 33.9 MB, less than 100.00% of Java online submissions for Middle of the Linked List.
    */
    public ListNode middleNode(ListNode head) {
        ListNode[] array = new ListNode[100];
        int size = 0;
        ListNode cur = head;
        while(cur != null)
        {
            array[size++] = cur;
            cur = cur.next;
        }
        System.out.print((size-1)/2);
        return array[size/2];
    }
}
