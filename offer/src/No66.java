/**
 * @author cz
 * @Description 构建乘积数组
 * @date 2022/5/4 19:57
 **/
public class No66 {
    public int[] multiply(int[] A) {
        int length = A.length;
        int[] res = new int[length];
        int[] top = new int[length];
        int[] bottom = new int[length];
        top[0]=1;
        bottom[0]=1;
        for(int i=0; i<length-1; i++){
            top[i+1] = A[i]*top[i];
            bottom[i+1] = A[length-i-1]*bottom[i];
        }
        for(int i=0; i<length; i++){
            res[i] = top[i]*bottom[length-i-1];
        }
        return res;
    }
}
