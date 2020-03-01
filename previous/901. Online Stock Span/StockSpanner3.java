
/*
other 3:
Runtime: 81 ms, faster than 88.29% of Java online submissions for Online Stock Span.
Memory Usage: 70.1 MB, less than 10.00% of Java online submissions for Online Stock Span.
*/
class StockSpanner3 {
    private List<Integer> list = new ArrayList<>();
    private List<Integer> prev = new ArrayList<>();

    public int next(int price) {
        list.add(price);
        int i = list.size() - 2;
        while (!prev.isEmpty() && i >= 0 && list.get(i) <= price) i = prev.get(i);
        prev.add(i);
        return list.size() - 1 - i;
    }
}



/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
