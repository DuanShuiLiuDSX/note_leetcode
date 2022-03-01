package order.hashMap;

import java.util.*;

/**
 * @author cz
 * @Description 字母异位分组
 * @date 2022/2/23 9:35
 **/
public class No49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> res = new HashMap<String, List<String>>();
        for (String str: strs){
            char[] chars = str.toCharArray();
            // 将字符串排序 abc, bca, cba 排序之后的 abc设为键
            Arrays.sort(chars);
            String key = new String(chars);
            // 从map中取出已经存入的 键值对, 再将新的值put
            List<String> list = res.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            res.put(key, list);
        }
        return new ArrayList<List<String>>(res.values());
    }
}
