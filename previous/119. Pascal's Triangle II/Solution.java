class Solution {
    
    public List<Integer> getRow(int rowIndex) {
        return getRow6(rowIndex);
    }

    public List<Integer> getRow5(int rowIndex) {
        Integer[] ret = new Integer[rowIndex+1];
        int size = 0;
        ret[size++] = 1;
        for(int i = 0; i < rowIndex; i++)//todo ? rowIndex + 1
        {
            ret[size++] = 1;
            for(int j = size - 2; size >= 3 && j >= 1; j--) ret[j] = ret[j]+ret[j-1];
        }
        return Arrays.asList(ret);
    }

    public List<Integer> getRow6(int rowIndex) {
        int len = rowIndex+1;
        Integer[] ret = new Integer[len];
        int size = 0;
        ret[len - ++size] = 1; //记录：++size此时是1，然后刚好len-1也就是最后一个。
        for(int i = 0; i < rowIndex; i++)//todo ? rowIndex + 1
        {
            ret[len - ++size] = 1;
            for(int j = (len-size) + 1; size >= 3 && j + 1 < len; j++) ret[j] = ret[j]+ret[j+1];
            //观察：那就是从index==1开始：自己=自己+自己的右侧； 自己=自己的右侧； 自己=自己+自己的右侧；
            //解释：为什么是(len-size) + 1: 因为走到len-size的含义就是左边空的个数，然后这个也是右边第一个非空的index。所以右边第二个非空的index == (len-size)+1;
        }
        return Arrays.asList(ret);
    }
    
    /*
    other 1: math: https://leetcode.com/problems/pascals-triangle-ii/discuss/38513/My-clean-O(k)-java-solution
    Runtime: 0 ms, faster than 100.00% of Java online submissions for Pascal's Triangle II.
    Memory Usage: 33.8 MB, less than 6.17% of Java online submissions for Pascal's Triangle II.
    */
    public List<Integer> getRow1(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(0,1);
        for(int i=1;i<=rowIndex;i++){
            row.add(i,(int)((long)row.get(i-1)*(rowIndex-i+1)/i));
        }
        return row;
    }
    

     public List<Integer> getRow2(int k) {
        Integer[] arr = new Integer[k + 1];
        Arrays.fill(arr, 0);
        arr[0] = 1;
        
        for (int i = 1; i <= k; i++) 
            for (int j = i; j > 0; j--) 
                arr[j] = arr[j] + arr[j - 1];
        
        return Arrays.asList(arr);
    }
    

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> list = new ArrayList<Integer>();
        if (rowIndex < 0)
            return list;

        for (int i = 0; i < rowIndex + 1; i++) {
            list.add(0, 1);
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public List<Integer> getRow4(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        for(int i = 0;i<rowIndex+1;i++) {
                res.add(1);
                for(int j=i-1;j>0;j--) {
                    res.set(j, res.get(j-1)+res.get(j));
                }
        }
        return res;
    }
    
    
}
