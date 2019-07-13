import java.util.TreeMap;

public class MapSum {

    public class Node
    {
        public boolean isWord;
        public int value;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord, int value)
        {
            this.isWord = isWord;//这个isWord在这道题其实没用到。
            this.value = value;
            next = new TreeMap<>();
        }

        public Node(int value)
        {
            this(false, value);
        }

        public Node()
        {
            this(false, 0);//注意，value应该是0，因为我们最终要算加和，所以设成0就什么都不会影响到。
        }
    }

    private Node root;

    /** Initialize your data structure here. */
    public MapSum() {
        root = new Node();
    }

    public MapSum(int value) //如果传进来value的话。
    {
        root = new Node(value);
    }

    public void insert(String word, int value) {
        Node cur = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
            {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = value;
    }

    public int sum(String prefix) {
        Node cur = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            char c = prefix.charAt(i);
            if(cur.next.get(c) == null)
            {
                //throw new IllegalArgumentException("Prefix doesn't exist.");//不要选择报错，应该选择返回sum==0，等同于没找到。
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
    }

    private int sum(Node cur)
    {
//        //line73-76是我写的终止条件：
//        if(cur.next.keySet() == null)//不能写成if(cur.next.keySet().size() == 0)，因为我发现，即便keySet()不为空，size也是==0的。
//        {
//            return 0;
//        }
//
//        //line79-82是老师写的终止条件，你也发现了，这个终止条件，其实不写也可以，因为后面就已经有了int sum = cur.value;
//        if(cur.next.size() == 0)
//        {
//            return cur.value;
//        }

        int sum = cur.value;
        for(Character key : cur.next.keySet())
        {
            sum += sum(cur.next.get(key));
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