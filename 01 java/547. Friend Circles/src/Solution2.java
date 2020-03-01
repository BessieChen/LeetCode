import java.util.TreeSet;

public class Solution2 {

    private interface UF //注意，里面的装的，不是Element！
    {
        int getSize();
        boolean isConnected(int a, int b);
        void unionElements(int a, int b);
    }

    private class UnionFind2 implements UF //注意，里面的装的，不是Element！
    {
        private int[] parent;//索引值 <-> 第几个元素， 数组内容 <-> 该元素的id //注意不是private Element[] parent;

        public UnionFind2(int size)
        {
            parent = new int[size];

            for(int i = 0; i < size; i++)
            {
                parent[i] = i;
            }
        }

        public UnionFind2()
        {
            this(10);
        }

        private int findID(int i) //这个就是主要区别：i的parent 和 i的ID 是两码事。parent是父亲，ID是祖先。
        {
            if(i < 0 || i >= parent.length)
                throw new IllegalArgumentException("p is out of bound.");

            while(i != parent[i])
            {
                i = parent[i];
            }
            return i;
        }

        @Override
        public int getSize()
        {
            return parent.length;
        }

        @Override
        public boolean isConnected(int a, int b)
        {
            return findID(a) == findID(b);
        }

        @Override
        public void unionElements(int a, int b)
        {
            if(!isConnected(a,b))
            {
                parent[findID(a)] = findID(b); //a的祖先 的父亲 是 b的祖先。
            }
        }


        public int countUnion()//计算有多少个集合。
        {
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < parent.length; i++)
            {
                set.add(findID(i));
            }
            return set.size();
        }

    }

    public int findCircleNum(int[][] M) {

        int size = M.length;
        UnionFind2 uf = new UnionFind2(size);

        for(int i = 0; i < size; i++)
        {
            for(int j = 0 ; j < i ; j++)
            {
                if(M[i][j] == 1)
                {
                    uf.unionElements(i, j);
                }
            }
        }

        return uf.countUnion();
    }
}
