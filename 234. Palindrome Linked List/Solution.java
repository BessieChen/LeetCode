/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        
        ListNode cur = head;
        while(cur != null)
        {
            arr.add(cur.val);
            cur = cur.next;
        }
        
        int len = arr.size();
        if(len == 0) return true;
        
        //method 1:
        for(int i = 0; i <= (len-1)/2; i++)
        {
            if(arr.get(i).compareTo(arr.get(len-1-i)) != 0) return false;
        }
        
        //method 2:
        for(int i = 0, j = len-1; i < j ; i++, j--)
        {
            if(arr.get(i).compareTo(arr.get(len-1-i)) != 0)  return false;
        }
        return true;
    }
}
