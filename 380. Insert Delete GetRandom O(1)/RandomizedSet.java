//用HashMap来实现：
/*
* 1.看上去题目只是需要给一个集合set添加和删除，但是，这里需要实现一个 以相同概率 抽取某个值
*   我能想到的方法就是 用random随机选取一个index，然后根据这个index来抽取对应的值。
*   所以，这里用HashMap实现会更好。我们存key，是为了可以随机抽取一个key，然后找出它对应的value
*
* 2.然后最开始我犯了一个低级错误：那就是我直接 Random rand = new Random(); int i = rand.nextInt(map.size()); map.get(i);
*   我想当然的以为：这样int i就可以是随机的一个key，但其实这个想法是错的，例如：
*   存入的key有 10，33，59
*   我们的map.size()就==3，所以int i只可能是[0,3)即[0,2], 假如 i = 2，则很明显map.get(i)是错的。
*
* 2.2 我将这样的错误代码提交时，遇到的结果是Runtime error, 而不是Wrong answer。我认为，可能是由于
*    其实我的insert(), remove()都没有错，是getRandom()的问题，可是要检测getRandom()可能需要比较长的时间。
*    如果我的getRandom()是对的，那么应该很快满足leetcode的，比如说 对key的累加都是差不多的，所以是均匀抽取
*    但如果我getRandom()是错的，leetcode可能觉得目前的数据量还不够，再多测试几次，可能试多几次就会发现均匀了。所以就超时了。
*
* 3.你在这里又开始想了，那我直接设置两个array：
*   一个array里面存的是key，假如说array[0] = 10, array[1] = 33, array[2] = 59
*   然后一个array2里面存的是val，假如说array2[10] = 10, array2[33] = 33, array2[59] = 59
*   然后int i = rand.nextInt(array.size()); return array2[i];
*   可是，问题就在于，你不知道的array多长。而且这样的array会很稀疏。
*   虽然我们第一个array存key是没错的，因为key是可以从array[0]开始一次存入的，然后我们通过array的index随机获取key
*   但是第二个array存值就不行了，所以引入了HashMap，依旧可以用key很快以O(1)的速度获取val，速度和array的随机索引一样，但是免去了很长很稀疏的array。
*
* 4.所以正确的做法是：将key存入一个array里面，int i = rand.nextIndex(array.size());
*   这样我们就可以array.get(i)从而随机调用一个key了
*   再用这个key取得val：map.get(key)
*
* 5.我之前的想法是：用HashMap<Integer, Integer> map;
*   这么做我可以 map.put(val, val);
*   java不需要我将int val强制类型转换，java会帮我转换，所以不必写成：map.put((Integer) val, (Integer) val);
*   但是老师倾向的做法是设置
*   HashMap<String, Integer> map;
*   将String keyString = Integer.toString(val);
*   之后map.put(keyString, val);
*   我觉得两种方法都可以，我可以练一下。
*
* */

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {

    HashMap<Integer, Integer> map;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val))//java提示不需要cast to (Integer)
            return false;//说明不需要insert，因为已经存在

        map.put(val, val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(map.containsKey(val))
        {
            map.remove(val);
            return true;
        }
        return false;
    }

    /** Get a random element from the set. */
    public int getRandom() {
//        if(map.size() == 0)

        Random rand = new Random();
        int i = rand.nextInt(map.size());
        //return map.get(i);
        return i;
    }

    public static void main(String[] args){

        RandomizedSet rs = new RandomizedSet();
        System.out.println(rs.insert(9));
//        System.out.println(rs.remove(0));
        System.out.println(rs.insert(-1));
//        System.out.println(rs.remove(0));
        System.out.println(rs.getRandom());
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */