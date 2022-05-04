import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

/**
 * @author cz
 * @Description
 * @date 2022/4/27 11:07
 **/
public class No50 {
    // 大写字母 ASCII 65-90 小写字母 ASCII 97-122  所以定义 position长度为58
    public int FirstNotRepeatingChar(String str) {
        int res=-1;
        int[] position = new int[58];
        for (int i = 0; i < 58; i++) {
            position[i]=-1;
        }
        for (int i = 0; i < str.length(); i++) {
            int index= str.charAt(i)-'A';
            if (position[index]==-1){
                position[index]=i;
            }else{
                position[index]=10001;
            }
        }
        for (int i = 0; i < 58; i++) {
            if (position[i]!=-1 && position[i]!=10001){
                if (res==-1) res = position[i];
                else res =  Math.min(res, position[i]);
            }
        }
        return res;
    }
}
