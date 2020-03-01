class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        return exclusiveTime1(n, logs);
    }

    public int[] exclusiveTime1(int n, List < String > logs) {
        Stack < Integer > stack = new Stack < > ();
        int[] res = new int[n];
        String[] s = logs.get(0).split(":");
        stack.push(Integer.parseInt(s[0]));
        int i = 1, prev = Integer.parseInt(s[2]);
        while (i < logs.size()) {
            s = logs.get(i).split(":");
            if (s[1].equals("start")) {
                if (!stack.isEmpty())
                    res[stack.peek()] += Integer.parseInt(s[2]) - prev;
                stack.push(Integer.parseInt(s[0]));
                prev = Integer.parseInt(s[2]);
            } else {
                res[stack.peek()] += Integer.parseInt(s[2]) - prev + 1;
                stack.pop();
                prev = Integer.parseInt(s[2]) + 1;
            }
            i++;
        }
        return res;
    }
    

    public int[] exclusiveTime2(int n, List<String> logs) {
        Deque<Log> stack = new ArrayDeque<>();
        int[] result = new int[n];
        for (String content : logs) {
            Log log = new Log(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log top = stack.pop();
                result[top.id] += (log.time - top.time + 1);
                if (!stack.isEmpty()) {
                    result[stack.peek().id] -= (log.time - top.time + 1);
                }
            }
        }
        
        return result;
    }
    
    public static class Log {
        public int id;
        public boolean isStart;
        public int time;
        
        public Log(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
        }
    }
    
    public int[] exclusiveTime3(int n, List<String> logs) {
        Deque<Log2> stack = new ArrayDeque<>();
        int[] result = new int[n];
        int duration = 0;
        for (String content : logs) {
            Log2 log = new Log2(content);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log2 top = stack.pop();
                result[top.id] += (log.time - top.time + 1 - top.subDuration);
                if (!stack.isEmpty()) {
                    stack.peek().subDuration += (log.time - top.time + 1);
                }
            }
        }
        
        return result;
    }
    
    public static class Log2 {
        public int id;
        public boolean isStart;
        public int time;
        public int subDuration;
        
        public Log2(String content) {
            String[] strs = content.split(":");
            id = Integer.valueOf(strs[0]);
            isStart = strs[1].equals("start");
            time = Integer.valueOf(strs[2]);
            subDuration = 0;
        }
    }
    
    public int[] exclusiveTime4(int n, List<String> logs) {
        int[] res = new int[n];
        int ptime = 0, running = 0;
        Stack<Integer> stack = new Stack<>();
        for (String log : logs) {
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int time = Integer.parseInt(split[2]);
            if (!start)
                time++;

            res[running] += (time - ptime);
            if (start) {
                stack.push(running);
                running = func;
            } else {
                running = stack.pop();
            }
            ptime = time;
        }
        return res;
    }
}

