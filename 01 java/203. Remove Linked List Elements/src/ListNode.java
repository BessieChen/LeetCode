//Definition for singly-linked list.
  public class ListNode {
      public int val;
      public ListNode next;
      public ListNode(int x) { val = x; }

      //链表节点的构造函数
      //使用arr为参数，创建一个链表，当前的ListNode为链表的头结点
      public ListNode (int[] arr)
      {
          if(arr.length == 0 || arr == null)
          {
              throw new IllegalArgumentException("Array cannot be empty.");
          }
          this.val = arr[0];
          ListNode aa = this;
          for(int i = 1; i < arr.length; i++)
          {
              aa.next = new ListNode(arr[i]);
              aa = aa.next;
          }
      }

      //以当前节点为头结点的链表信息字符串
    @Override
    public String toString()
    {
        StringBuilder res = new StringBuilder();
        ListNode cur = this;
        res.append("head ");
        while(cur != null)
        {
            res.append(cur.val + " -> ");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

 }

