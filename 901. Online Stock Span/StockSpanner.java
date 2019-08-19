
class StockSpanner2 {
    Stack<int[]> stack = new Stack<>();
    public int next(int price) {
        int res = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price)
            res += stack.pop()[1];
        stack.push(new int[]{price, res});
        return res;
    }
}


class StockSpanner3{
        Stack<Item> s = new Stack<>();

        public int next(int price) {
            int lessOrEqual = 1;
            while (!s.isEmpty() && s.peek().price <= price)
                lessOrEqual += s.pop().lessOrEqual;
            s.push(new Item(lessOrEqual, price));
            return s.peek().lessOrEqual;
        }

        class Item {
            final int lessOrEqual, price;

            Item(int lessCount, int val) {
                this.lessOrEqual = lessCount;
                this.price = val;
            }
        }
    }


class StockSpanner {
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
