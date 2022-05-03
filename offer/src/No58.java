import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 左旋转字符串
 * @date 2022/5/3 10:37
 **/
public class No58 {

        public String LeftRotateString(String str,int n) {
            if(str.length()==0) return "";
            n = n % str.length();
            String res = str.substring(n, str.length());
            res = res.concat(str.substring(0, n));
            return res;
        }

    @Test
    public void test(){
        No58 no58 = new No58();
        no58.LeftRotateString("abcXYZdef", 3);
    }
}


