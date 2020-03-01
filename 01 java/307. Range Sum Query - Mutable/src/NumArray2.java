public class NumArray2 {
    private SegmentTree<Integer> tree;
    public NumArray2(int[] nums) {

        if(nums.length > 0)
        {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++)
                data[i] = nums[i];
            tree = new SegmentTree<>(data, new Merger<Integer>() {
                @Override
                public Integer merge(Integer a, Integer b) {
                    return a+b;//自定义的。
                }
            });
        }
    }

    public int sumRange(int i, int j) {
        if(tree == null)
            throw new IllegalArgumentException("Segment Tree is null");

        return tree.query(i,j);
    }

    public void update(int index, int val) {
        if(tree == null)
            throw new IllegalArgumentException("Segment Tree is null");
        tree.set(index, val);
    }
}
