
 //Definition for singly-linked list.
 class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }

public class Solution {
    /*
    我最开始的想法：
    在Solution类里面添加一个成员变量int size，每次遍历head就size++, 一边遍历一边讲值推入一个array中
    因为这样做之后调用middle就可以直接使用array的随机访问。
    后来觉得连size都不需要了，直接用array的length?
    
    不过问题是：array如果是使用的是java的话，就不能够动态扩容。
    还好题目说了，只会有从1-100个。
    
    出错的地方：
    题目需要返回的是ListNode，所以我应该返回的是ListNode！所以其实cur.val是用不到的！
    如果是size == 3，返回的是index == 1；
    如果是size == 4，返回的是index == 2；
    如果是size == 6，返回的是index == 3；
    
    注意：这里如果size == 6， (size-1)/2 = 5/2 = 2.5 = 2!!不是==3！！
    所以我这里的正确答案是size/2
    3/2 = 1.5 = 1
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