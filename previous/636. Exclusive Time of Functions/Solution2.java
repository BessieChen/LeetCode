class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        return exclusiveTime7(n, logs);
    }
    
    
    /*
    method 3: 
    Runtime: 12 ms, faster than 98.13% of Java online submissions for Exclusive Time of Functions.
    Memory Usage: 38.3 MB, less than 100.00% of Java online submissions for Exclusive Time of Functions.
    */
    public int[] exclusiveTime7(int n, List<String> logs) {
        int[] ret = new int[n];//每个id的时间
        int[] stack = new int[10*n];//记录没完成的id,可能重复
        int size = 0;
        int lastTime = 0;
        for(String s : logs)
        {
            String[] content = s.split(":");
            int id = Integer.parseInt(content[0]);
            int timeStamp = Integer.parseInt(content[2]);
            boolean start = content[1].equals("start");

            if(start)
            {
                if(size > 0) ret[stack[size-1]] += (timeStamp - lastTime);
                stack[size++] = id;
            }
            else
            {
                timeStamp++;
                ret[stack[--size]] += (timeStamp - lastTime);
            }
            lastTime = timeStamp; 
        }
        return ret;
    }

    /*
    method 2:
    Runtime: 13 ms, faster than 96.89% of Java online submissions for Exclusive Time of Functions.
    Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Exclusive Time of Functions.
    */
    public int[] exclusiveTime6(int n, List<String> logs) {
        int[] ret = new int[n];
        int[] stack = new int[10*n];
        int size = 0;
        int lastTime = 0;
        
        for(String s : logs)
        {
            String[] content = s.split(":");
            int id = Integer.parseInt(content[0]);
            int timeStamp = Integer.parseInt(content[2]);
            boolean start = content[1].equals("start");
            if(start)
            {
                if(size > 0) ret[stack[size-1]] += (timeStamp - lastTime);
                stack[size++] = id;
                lastTime = timeStamp; 
            }
            else
            {
                ret[stack[size-1]] += (timeStamp+1 - lastTime);
                size--;
                lastTime = timeStamp+1; 
            }
        }
        return ret;
    }

    
    /*
    method 1: 
    Runtime: 12 ms, faster than 98.15% of Java online submissions for Exclusive Time of Functions.
    Memory Usage: 39 MB, less than 92.86% of Java online submissions for Exclusive Time of Functions.
    */
    public int[] exclusiveTime5(int n, List<String> logs) {
        int[] res = new int[n];
        int ptime = 0, running = 0;
        int[] stack = new int[10*n];
        int size = 0;

        for (String log : logs) {
            String[] split = log.split(":");
            int func = Integer.parseInt(split[0]);
            boolean start = split[1].equals("start");
            int time = Integer.parseInt(split[2]);
            
            if (!start)
                time++;
            res[running] += (time - ptime);//one bug:
            // 1
            // ["0:start:1","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"]
            // Output [8] , Expected [7]
            
            if (start) {
                stack[size++] = running;
                running = func;
            } else {
                running = stack[size-1];
                size--;
            }
            
            
            ptime = time;
        }
        return res;
    }

}

