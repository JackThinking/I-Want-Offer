package nowcoder;

import java.util.*;

/**
 * Created by Citrix on 2019-04-10.
 */
public class BucketSort {
    /*
    * Input:
    "tree"
    Output:
    "eert"
    * */
    /*
     * 桶排序方法
     * */
    public String frequencySort_1(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character>[] buckets = new List[s.length() + 1]; //这个是因为不考虑0的情况，最差从1开始，所以要加1
        for (char c : map.keySet()) {
            int fre = map.get(c);
            if (buckets[fre] == null) {
                buckets[fre] = new ArrayList<>();
            }
            buckets[fre].add(c);
        }
        StringBuffer sb = new StringBuffer();
        for (int i = buckets.length - 1; i >= 0; i--) {
            if (buckets[i] != null) {
                for (char c : buckets[i]) {
                    for (int j = 0; j < map.get(c); j++) {
                        sb.append(c);
                    }
                }
            }
        }
        return sb.toString();
    }

    /*
     * 堆排序法：其效果差了很多
     * */
    public String frequencySort_2(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());//这里使用了Lambda表达式
        pq.addAll(map.entrySet());//addAll的操作有点骚
        StringBuffer sb = new StringBuffer();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int) e.getValue(); i++) {
                sb.append(e.getKey());
            }
        }
        return sb.toString();
    }
}
