import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;

/**
 * @author cz
 * @Description 丑数
 * @date 2022/4/27 9:44
 **/
public class No49 {
    // Out of time
    public int nthUglyNumber(int n) {
        HashSet<Integer> set = new HashSet<>();
        if (n==1) return 1;
        if (n==2) return 2;
        if (n==3) return 3;
        if (n==4) return 4;
        if (n==5) return 5;

        set.add(1);
        set.add(2);
        set.add(3);
        set.add(5);
        int res=1, count=0;
        while(count<n){
            Iterator<Integer> iterator = set.iterator();
            while (iterator.hasNext() && count<n){
                int next = iterator.next();
                int tempBalance = res % next;
                int tempShang = res / next;
                if (tempBalance==0){
                    if (set.contains(tempShang)){
                        set.contains(tempShang);
                        set.add(res);
                        count++;
                        break;
                    }
                }
            }
            if (count==n) return res;
            if (count<n) res++;

        }
        return res;
    }

    /**
     *  最优解  dp  三指针
     * @param n
     * @return
     */
    public int nthUglyNumber1(int n) {
       int[] dp = new int[n];
       dp[0]=1;
       int a=0, b=0, c=0;
        for (int i = 1; i < n; i++) {
            int n2=dp[a]*2, n3 = dp[b]*3, n5 = dp[c]*5;
            dp[i]= Math.min(Math.min(n2, n3), n5);
           if (dp[i]==n2) a++;
           if (dp[i]==n3) b++;
           if (dp[i]==n5) c++;
        }
        return dp[n-1];
    }
    @Test
    public void test(){
        No49 no49 = new No49();
        System.out.println(no49.nthUglyNumber(247));
    }
}
