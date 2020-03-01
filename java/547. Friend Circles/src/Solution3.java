import java.util.TreeSet;

public class Solution3 {

    private interface UF //注意，里面的装的，不是Element！
    {
        int getSize();
        boolean isConnected(int a, int b);
        void unionElements(int a, int b);
    }

    //基于size的优化
    private class UnionFind3 implements UF //注意，里面的装的，不是Element！
    {
        private int[] parent;//索引值 <-> 第几个元素， 数组内容 <-> 该元素的id //注意不是private Element[] parent;
        private int[] unionSize;//记录某个元素所属集合的祖先的大小。

        public UnionFind3(int size)
        {
            parent = new int[size];
            unionSize = new int[size];

            for(int i = 0; i < size; i++)
            {
                parent[i] = i;
                unionSize[i] = 1;
            }
        }

        public UnionFind3()
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

        //注意：尽可能的将调用相同函数的部分提取出来，否则消耗性能，例如下面的code一直在调用findID(a), findID(b)
        //错误示范：
    /*@Override
    public void unionElements(int a, int b)
    {
        if(!isConnected(a,b))
        {
            if(unionSize[findID(a)] <= unionSize[findID(b)]) //没有等于号也可以。这里是a所属集合更小，所以a臣服于b
            {
                parent[findID(a)] = findID(b);
                unionSize[findID(b)] += unionSize[findID(a)];
            }
            else
            {
                parent[findID(b)] = findID(a);
                unionSize[findID(a)] += unionSize[findID(b)];
            }
        }
    }*/

        public void unionElements(int a, int b)
        {
            if(!isConnected(a,b))
            {
                int aID = findID(a);
                int bID = findID(b);
                if(unionSize[aID] <= unionSize[bID]) //没有等于号也可以。这里是a所属集合更小，所以a臣服于b
                {
                    parent[aID] = bID;
                    unionSize[bID] += unionSize[aID];
                }
                else
                {
                    parent[bID] = aID;
                    unionSize[aID] += unionSize[bID];
                }
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
        UnionFind3 uf = new UnionFind3(size);

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
