public class Solution7 {
    public ListNode removeElements(ListNode head, int val, int depth)
    {
        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+ val + " in " + head);//这里的head会打印成head 1 -> 2 -> 4 -> 5 -> 2 -> NULL的样子，因为调用了之前的toString()函数

        if(head == null)
        {
            System.out.print(depthString);
            System.out.println("Return "+ head);//这里相当于写了"Return" + null;
            return null;
        }
        ListNode result = removeElements(head.next, val, depth+1);
        System.out.print(depthString);
        System.out.println("After remove "+ val+" : "+ result);

        ListNode ret;
        if(head.val == val)
        {
            ret = result;
        }
        else
        {
            head.next = result;
            ret = head;
        }

        System.out.print(depthString);
        System.out.println("Return "+ret);
        return ret;//这个写的真的很厉害！
    }

    private String generateDepthString(int depth)
    {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < depth; i++)
        {
            res.append("--|");
        }
        return res.toString();
    }
    public static void main(String[] args)
    {
        int[] arr = {1,2,3,4,3};
        ListNode aa = new ListNode(arr);

        for(ListNode result = (new Solution7()).removeElements(aa,3, 0); result != null; result = result.next)
        {
            System.out.println(result.val);
        }

        int[] arr2 = {1,2,3,4,3,5,2};
        ListNode aa2 = new ListNode(arr2);

        ListNode res = (new Solution7()).removeElements(aa2,3, 0);//调用了toString()函数
        System.out.println(res);

    }
}

//
///Library/Java/JavaVirtualMachines/jdk-12.0.1.jdk/Contents/Home/bin/java "-javaagent:/Applications/IntelliJ IDEA CE.app/Contents/lib/idea_rt.jar=50488:/Applications/IntelliJ IDEA CE.app/Contents/bin" -Dfile.encoding=UTF-8 -classpath "/Users/bessie/Downloads/ByB/LeetCode/203. Remove Linked List Elements/out/production/203. Remove Linked List Elements" Solution7
//        Call: remove 3 in head 1 -> 2 -> 3 -> 4 -> 3 -> NULL
//        --|Call: remove 3 in head 2 -> 3 -> 4 -> 3 -> NULL
//        --|--|Call: remove 3 in head 3 -> 4 -> 3 -> NULL
//        --|--|--|Call: remove 3 in head 4 -> 3 -> NULL
//        --|--|--|--|Call: remove 3 in head 3 -> NULL
//        --|--|--|--|--|Call: remove 3 in null
//        --|--|--|--|--|Return null
//        --|--|--|--|After remove 3 : null
//        --|--|--|--|Return null
//        --|--|--|After remove 3 : null
//        --|--|--|Return head 4 -> NULL
//        --|--|After remove 3 : head 4 -> NULL
//        --|--|Return head 4 -> NULL
//        --|After remove 3 : head 4 -> NULL
//        --|Return head 2 -> 4 -> NULL
//        After remove 3 : head 2 -> 4 -> NULL
//        Return head 1 -> 2 -> 4 -> NULL
//        1
//        2
//        4
//        Call: remove 3 in head 1 -> 2 -> 3 -> 4 -> 3 -> 5 -> 2 -> NULL
//        --|Call: remove 3 in head 2 -> 3 -> 4 -> 3 -> 5 -> 2 -> NULL
//        --|--|Call: remove 3 in head 3 -> 4 -> 3 -> 5 -> 2 -> NULL
//        --|--|--|Call: remove 3 in head 4 -> 3 -> 5 -> 2 -> NULL
//        --|--|--|--|Call: remove 3 in head 3 -> 5 -> 2 -> NULL
//        --|--|--|--|--|Call: remove 3 in head 5 -> 2 -> NULL
//        --|--|--|--|--|--|Call: remove 3 in head 2 -> NULL
//        --|--|--|--|--|--|--|Call: remove 3 in null
//        --|--|--|--|--|--|--|Return null
//        --|--|--|--|--|--|After remove 3 : null
//        --|--|--|--|--|--|Return head 2 -> NULL
//        --|--|--|--|--|After remove 3 : head 2 -> NULL
//        --|--|--|--|--|Return head 5 -> 2 -> NULL
//        --|--|--|--|After remove 3 : head 5 -> 2 -> NULL
//        --|--|--|--|Return head 5 -> 2 -> NULL
//        --|--|--|After remove 3 : head 5 -> 2 -> NULL
//        --|--|--|Return head 4 -> 5 -> 2 -> NULL
//        --|--|After remove 3 : head 4 -> 5 -> 2 -> NULL
//        --|--|Return head 4 -> 5 -> 2 -> NULL
//        --|After remove 3 : head 4 -> 5 -> 2 -> NULL
//        --|Return head 2 -> 4 -> 5 -> 2 -> NULL
//        After remove 3 : head 2 -> 4 -> 5 -> 2 -> NULL
//        Return head 1 -> 2 -> 4 -> 5 -> 2 -> NULL
//        head 1 -> 2 -> 4 -> 5 -> 2 -> NULL
//
//        Process finished with exit code 0