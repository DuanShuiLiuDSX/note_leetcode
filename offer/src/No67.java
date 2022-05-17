import com.sun.javafx.image.BytePixelSetter;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;

/**
 * @author cz
 * @Description
 * @date 2022/5/5 11:00
 **/
public class No67 {
    public int StrToInt (String s) {
        // write code here
        s = s.trim();
        if(s==null || s.length()==0 ) return 0;

        long res = 0;
        Boolean flag=true;
        if (s.charAt(0)=='+' ){
            res=0;
        }else if(s.charAt(0)=='-'){
            flag=false;
            res=0;
        }else if(s.charAt(0)>='0' && s.charAt(0)<='9'){
            res = s.charAt(0)-'0';
        }else {
            return (int) res;
        }

        int temp, power;
        if (res==0) power=0;
        else power=1;

        for(int i=1; i<s.length(); i++){
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
                temp = s.charAt(i) - '0';
                if (!flag){
                    if (power==0)
                    res = (int)(res*Math.pow(10, power++)) - temp;
                    else
                        res = (long)(res*Math.pow(10, 1)) - temp;
                }else {
                    if (power==0)
                        res = (int)(res*Math.pow(10, power++)) + temp;
                    else
                    res = (long)(res*Math.pow(10, 1)) + temp;
                }
                System.out.println(Integer.MAX_VALUE);
                System.out.println(Integer.MIN_VALUE);
                if (res>=Integer.MAX_VALUE) return Integer.MAX_VALUE;
                if (res<=Integer.MIN_VALUE) return Integer.MIN_VALUE;
            }else {
                break;
            }
        }

        return (int) res;
    }

    @Test
    public void test(){
        No67 no67 = new No67();
        no67.StrToInt("-987654321111");
    }
}
