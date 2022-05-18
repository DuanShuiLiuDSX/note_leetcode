package backtracking;

/**
 * @author cz
 * @Description
 * @date 2022/5/18 14:47
 **/
public class Test {
    public static void main(String[] args) {
        int[][] a = new int[1][1];
        method(a);
        System.out.println(a);
    }

    public static void method(int[][] a){
        a[0][0]=111;
    }
}
