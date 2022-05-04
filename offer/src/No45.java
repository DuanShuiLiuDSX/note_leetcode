import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author cz
 * @Description 把数组排成最小的数
 * @date 2022/4/26 9:15
 **/
public class No45 {
    /**
     *  优先队列
     * @param numbers
     * @return
     */
    public String PrintMinNumber(int [] numbers) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length()==o2.length()) return Integer.valueOf(o1)-Integer.valueOf(o2);
                else if (o1.length()> o2.length()){
                    int len = o2.length();
                    for (int i=0; i<len; i++){
                        if (o1.charAt(i)-'0' > o2.charAt(i)-'0'){
                            return 1;
                        }else if (o1.charAt(i)-'0' < o2.charAt(i)-'0'){
                            return -1;
                        }
                    }
                    for (int i=len; i<o1.length(); i++){
                        if (o1.charAt(i) -'0' > o2.charAt(0)-'0'){
                            return 1;
                        }
                    }
                    return -1;
                }else {
                    int len = o1.length();
                    for (int i=0; i<len; i++){
                        if (o2.charAt(i)-'0' > o1.charAt(i)-'0'){
                            return -1;
                        }else if (o2.charAt(i)-'0' < o1.charAt(i)-'0'){
                            return 1;
                        }
                    }
                    for (int i=len; i<o2.length(); i++){
                        if (o2.charAt(i)-'0' > o1.charAt(0)-'0'){
                            return -1;
                        }
                    }
                    return 1;
                }
            }
        });

        for (int i=0; i<numbers.length; i++){
            priorityQueue.offer(String.valueOf(numbers[i]));
        }
        String res = new String();
        while (priorityQueue.isEmpty()==false){
            res = res.concat(priorityQueue.poll());
        }
        return res;
    }

    public String PrintMinNumber1(int [] numbers) {
        PriorityQueue<String> priorityQueue = new PriorityQueue<String>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.valueOf(o1)-Integer.valueOf(o2);
            }
        });

        for (int i=0; i<numbers.length; i++){
            priorityQueue.offer(String.valueOf(numbers[i]));
        }
        String res = new String();
        while (priorityQueue.isEmpty()==false){
            res = res.concat(priorityQueue.poll());
        }
        return res;
    }

    /**
     *   题解
     * @param numbers
     * @return
     */
    public String PrintMinNumber2(int[] numbers){
        if (numbers==null || numbers.length==0)
            return "";
        String[] strNums = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            strNums[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNums, new Comparator<String>() {
            // 比较方法 直接 比较拼接后的 字符串 的数值大小即可
            // PrintMinNumber 中 比较方法 太麻烦
            @Override
            public int compare(String o1, String o2) {
                return  Integer.valueOf( o1.concat(o2)) - Integer.valueOf(o2.concat(o1));
            }
        });
        String res=new String();
        for (String s : strNums){
            res = res.concat(s);
        }
        return res.toString();
    }

    @Test
    public void test(){
        No45 no45 = new No45();
        no45.PrintMinNumber1(new int[]{321, 3,32 ,344});
    }
}


