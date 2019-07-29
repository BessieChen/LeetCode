/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
