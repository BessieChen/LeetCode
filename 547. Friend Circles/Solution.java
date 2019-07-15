import java.util.TreeSet;

class Solution {

    private interface UF //注意，里面的装的，不是Element！
    {
        int getSize();
        boolean isConnected(int a, int b);
        void unionElements(int a, int b);
    }

    //第一版Union-Find：记录id
    private class UnionFind1 implements UF //注意，里面的装的，不是Element！
    {
        private int[] id;//索引值 <-> 第几个元素， 数组内容 <-> 该元素的id //注意不是private Element[] id;

        public UnionFind1(int size)
        {
            id = new int[size];

            for(int i = 0; i < size; i++)
            {
                id[i] = i;
            }
        }

        public UnionFind1()
        {
            this(10);
        }

        @Override
        public int getSize()
        {
            return id.length;
        }

        @Override
        public boolean isConnected(int a, int b)
        {
            return id[a] == id[b];
        }

        @Override
        public void unionElements(int a, int b)
        {
            if(!isConnected(a,b))
            {
                for(int i = 0; i < getSize(); i++)
                {
                    if(id[i] == id[a])//任何和a的id相同的元素的id改成b的id
                    {
                        id[i] = id[b];
                    }
                }
            }
        }

        public int countUnion()//计算有多少个集合。
        {
            TreeSet<Integer> set = new TreeSet<>();
            for(int i = 0; i < id.length; i++)
            {
                set.add(id[i]);
            }
            return set.size();
        }

    }

    public int findCircleNum(int[][] M) {

        int size = M.length;
        UnionFind1 uf = new UnionFind1(size);
        //我们需要扫描的是（不 包 括）对角线在内的上三角元素//todo + 复制
        for(int i = 0; i < size; i++)
        {
            //method 1:
            //for(int j = i+1; j < size; j++)

            //method 2:
            for(int j = 0 ; j < i ; j++)
            {
                if(M[i][j] == 1)
                {
                    uf.unionElements(i, j);
                }
            }
        }

        for(int i = 0; i < size-1; i++)//从第0行到size-2行，即第1行 到 第倒数第二行//todo wrong! + 复制
        {
            for(int j = i+1; j < size; j++)
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
