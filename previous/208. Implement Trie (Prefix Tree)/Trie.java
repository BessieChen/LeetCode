//下面是我的答案：代码通过leetCode
import java.util.TreeMap;
class Trie {

    private class Node
    {
        public boolean isWord;
        public TreeMap<Character, Node> next;

        public Node(boolean isWord)
        {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        public Node()
        {
            this(false);
        }
    }

    private Node root;
    private int size;

    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
        size = 0;
    }

    /** Inserts a word into the trie. */
    public void insert(String word)
    {
        add(root, word, 0);
    }

    private void add(Node node, String word, int index)
    {
        if(index == word.length())//说明从上一轮过来的是时候，那个char c已经是最后一个字母了
            return;
        char c = word.charAt(index);
        if(node.next.get(c) == null)
        {
            node.next.put(c, new Node());
        }
        Node nextLetter = node.next.get(c);
        if(index == word.length() - 1 && !nextLetter.isWord )
        {
            nextLetter.isWord = true;
            size++;
        }
        add(nextLetter, word, index+1);
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        return contains(root, word, 0);
    }

    private boolean contains(Node node, String word, int index)
    {
        if(index == word.length())
            return node.isWord; //说明已经遍历完了，此时参数给的node就是最后一个字母对应的节点。

        char c = word.charAt(index);
        if(node.next.get(c) == null)
        {
            return false;
        }
        return contains(node.next.get(c), word, index+1);
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {

        return isPrefix(root, prefix, 0);
    }

    private boolean isPrefix(Node node, String prefix, int index)
    {
        if(index == prefix.length())
            return true;

        char c = prefix.charAt(index);
        if(node.next.get(c) == null)
            return false;

        return isPrefix(node.next.get(c), prefix, index+1);
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */