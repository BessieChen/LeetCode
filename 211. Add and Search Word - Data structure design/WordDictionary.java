import java.util.TreeMap;

class WordDictionary {

    private class Node
    {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new TreeMap<>();//todo 是null还是别的？
        }

        public Node()
        {
            this(false);
        }
    }

    private Node root;
    private int size;//因为不像数组，我们可以直接用data.length作为size，这里的节点Node是灵活分散的，所以应该额外设置一个size变量
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new Node();
        size = 0;
    }

    /** Adds a word into the data structure. */
    public void addWord(String word)//不是Character word！因为Character是字符，不是字符串！
    {
        Node cur = root;
        for(int i = 0; i < word.length(); i++)
        {
            char c = word.charAt(i);
            if(cur.next.get(c) == null)
            {
                cur.next.put(c, new Node());
                //错误：size++; todo 我一定是傻了，怎么是加一个char就size++呢？应该是加了一个word才size++!!
            }
            cur = cur.next.get(c);
            if(i == word.length()-1)
            {
                //错误：todo 也不是每次到了word末尾，就在trie上size++，因为可能这个word已经在trie里面了！
                /*cur.isWord = true;
                size++;*/

                if(!cur.isWord)
                {
                    cur.isWord = true;
                    size++;
                }
            }
        }
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word)
    {
        return search(root, word, 0);

    }

    private boolean search(Node node, String word, int index)
    {
        if(index == word.length())
        {
            return node.isWord;
        }

        char c =  word.charAt(index);
        if( c != '.')
        {
            if(node.next.get(c) != null)
            {
                return search(node.next.get(c), word, index+1);
            }
            return false;
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

        //return search(node.next.get(c), word, index+1, end);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
