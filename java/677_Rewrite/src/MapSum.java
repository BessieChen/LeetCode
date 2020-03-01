import java.util.TreeMap;

class MapSum {

    private class Node
    {
        public int val;//如果有val那就一定是有节点的，如果val=0那就是没有节点，或者有节点但是是一个不会影响结果的节点。

        public TreeMap<Character, Node> next;

        public Node(int val)
        {
            next = new TreeMap<>();
            this.val = val;
        }

        public Node()//如果 不是word的结尾，那就是一个普通的字符/节点，val == 0
        {
            this(0);
        }

    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for(int i = 0; i < key.length(); i++)
        {
            char c = key.charAt(i);
            if(cur.next.get(c) == null)
            {
                cur.next.put(c, new Node());//todo 这句的第二个参数 new Node()我老是卡主
            }
            cur = cur.next.get(c);
            if(i == key.length()-1)//如果满足这个if，说明前面的c已经是最后一个字母了,所以cur此时也是代表最后一个字母c的节点
            {
                cur.val = val;
            }
        }
    }

    public int sum(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
            {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node node)
    {
        int sum = node.val;

        for(Character key : node.next.keySet())
        {
            sum += sum(node.next.get(key));
        }
        return sum;
    }

}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */