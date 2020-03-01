import java.util.TreeMap;

public class WordDictionary {
    /** Initialize your data structure here. */

    public class Node
    {
        boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node()
        {
            this(false);//不能是 this(null);
        }
    }

    private Node root;

    public WordDictionary() {

        root = new Node();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
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
        if(!cur.isWord)
        {
            cur.isWord = true;
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    //我觉得这个不好用非递归的方法写，因为是'.'和不是'.'的处理差距很大，而且可能会跳来跳去的。
    public boolean search(String word) {
        return search(root, word, 0);
    }

    //递归都是单线程的。
    private boolean search(Node node, String word, int index)
    {
        if(index == word.length())//这个index是否存在，已经在上一步if(node.next.get(c)!=null)判断了.
        {
            //Wrong:
            //return true;不能直接返回true！
            return node.isWord;
        }
        char c = word.charAt(index);
        if(c != '.')
        {
            if(node.next.get(c) == null)
            {
                return false;
            }
            return search(node.next.get(c), word, index+1);
        }
        else
        {
            for(Character key : node.next.keySet())
            {
                if(search(node.next.get(key), word, index+1))
                {
                    return true;
                }
            }
            return false;
        }
    }


}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */