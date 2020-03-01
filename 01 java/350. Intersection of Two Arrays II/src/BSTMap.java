public class BSTMap<K extends Comparable<K>, V> implements Map<K, V>
{
    private class Node
    {
        private K key;
        private V value;
        private Node left;
        private Node right;

        public Node(K key, V value, Node left, Node right)
        {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }

        public Node(K key, V value)
        {
            this(key, value, null, null);
        }

        public Node()
        {
            this(null, null, null, null);
        }

        @Override
        public String toString()
        {
            return key.toString() + " : " + value.toString();
        }
    }

    private Node root;
    private int size;


    @Override
    public void add(K key, V value)
    {
        root = add(root, key, value);
    }

    private Node add(Node node, K key, V value)
    {
        if(node == null)
        {
            size++;
            return new Node(key, value);
        }
        if(node.key.compareTo(key)==0)//compareTo是key拥有的函数，因为K extends Comparable<K>
        {
            node.value = value;//相当于更新了node之前的value
            return node;
        }
        else if(key.compareTo(node.key)>0)
        {
            node.right = add(node.right, key, value);
        }
        else
        {
            node.left = add(node.left, key, value);
        }
        return node;
    }

    private Node getNode(Node node, K key)
    {
        if(node == null)
        {
            return null;
        }
        if(key.compareTo(node.key)==0)
        {
            return node;
        }
        else if(key.compareTo(node.key)>0)
        {
            return getNode(node.right, key);
        }
        else
        {
            return getNode(node.left, key);
        }
    }

    @Override
    public V remove(K key)
    {
        if(!contains(key))
        {
            throw new IllegalArgumentException("Key "+ key + "doesn't exist.");
        }
        V ret = getNode(root, key).value;
        root = remove(root, key);
        return ret;
    }

    private Node remove(Node node, K key)
    {
        if(key.compareTo(node.key) > 0)
        {
            node.right = remove(node.right, key);
        }
        else if(key.compareTo(node.key) < 0)
        {
            node.left = remove(node.left, key);
        }
        else
        {
            if(node.left == null)
            {
                Node rightNode = node.right;
                node.right = null;
                size--;
                return rightNode;
            }
            else if(node.right == null)
            {
                Node leftNode = node.left;
                node.left = null;
                size--;
                return leftNode;
            }
            else//相当于(node.left != null && node.right != null)
            {
                Node successor = removeMaximum(node.right);
                node.value = successor.value;
                return node;
            }
        }
        return node;
    }

    //------------------------------------teacher's remove starts---------------------------------------------------------------
    private Node minimum_teacher(Node node){
        if(node.left == null)
            return node;
        return minimum_teacher(node.left);
    }

    // 删除掉以node为根的二分搜索树中的最小节点
    // 返回删除节点后新的二分搜索树的根
    private Node removeMin_teacher(Node node){

        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size --;
            return rightNode;
        }

        node.left = removeMin_teacher(node.left);
        return node;
    }

    // 从二分搜索树中删除键为key的节点
    public V remove_teacher(K key){

        Node node = getNode(root, key);
        if(node != null){
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    private Node remove_teacher(Node node, K key){

        if( node == null )
            return null;

        if( key.compareTo(node.key) < 0 ){
            node.left = remove_teacher(node.left , key);
            return node;
        }
        else if(key.compareTo(node.key) > 0 ){
            node.right = remove_teacher(node.right, key);
            return node;
        }
        else{   // key.compareTo(node.key) == 0

            // 待删除节点左子树为空的情况
            if(node.left == null){
                Node rightNode = node.right;
                node.right = null;
                size --;
                return rightNode;
            }

            // 待删除节点右子树为空的情况
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                return leftNode;
            }

            // 待删除节点左右子树均不为空的情况

            // 找到比待删除节点大的最小节点, 即待删除节点右子树的最小节点
            // 用这个节点顶替待删除节点的位置
            Node successor = minimum_teacher(node.right);
            successor.right = removeMin_teacher(node.right);
            successor.left = node.left;

            node.left = node.right = null;

            return successor;
        }
    }
    //------------------------------------teacher's remove ends---------------------------------------------------------------


    //------------------------------------get minimum/maximum starts---------------------------------------------------------------
    public V minimum()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("BST is empty");
        }
        return minimum(root).value;
    }

    private Node minimum(Node node)
    {
        if(node.left == null)
        {
            return node;
        }
        else
        {
            return minimum(node.left);//这里就是一股气的return，return值的就刚好是终止条件return的值
        }
    }


    public V maximum()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException("BST is empty");
        }
        return maximum(root).value;
    }

    private Node maximum(Node node)
    {
        if(node.right == null)
        {
            return node;
        }
        else
        {
            return maximum(node.right);
        }
    }

    //------------------------------------get minimum/maximum ends---------------------------------------------------------------

    //------------------------------------remove minimum/maximum starts---------------------------------------------------------------

    public V removeMinimum()
    {
        V ret = minimum();
//        wrong:
//        Node res = removeMinimum(root);
        root = removeMinimum(root);
        return ret;
    }

    private Node removeMinimum(Node node)
    {
        if(node.left == null)
        {
            size--;
            return node.right; //如果node.right==null那就是return null，如果不是null就return不是null的node.right.
        }
        else
        {
            node.left = removeMinimum(node.left);
        }
        return node;
    }

    public V removeMaximum()
    {
        V ret = maximum();
        root = removeMaximum(root);
        return ret;
    }

    private Node removeMaximum(Node node)
    {
        if(node.right == null)
        {
            size--;
            return node.left; //如果node.right==null那就是return null，如果不是null就return不是null的node.right.
        }
        else
        {
            node.right = removeMaximum(node.right);
        }
        return node;
    }
    //------------------------------------remove minimum/maximum ends---------------------------------------------------------------


    @Override
    public void set(K key, V newValue)
    {
        if(!contains(key))
        {
            throw new IllegalArgumentException("Key "+ key + "doesn't exist.");
        }
        Node res = getNode(root, key);
        res.value = newValue;
    }

    @Override
    public boolean contains(K key)
    {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key)
    {
        Node res = getNode(root, key);
        //method 1:
        if(res != null)
        {
            return res.value;
        }
        else
        {
            return null;
        }
        //method 2:
//        return res == null ? null : res.value;
    }

    @Override
    public int getSize()
    {
        return size;
    }

    @Override
    public boolean isEmpty()
    {
        return size==0;
    }
}
