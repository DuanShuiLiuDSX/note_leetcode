package backtracking;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cz
 * @Description n皇后问题
 * @date 2022/5/18 14:21
 **/
public class LC51 {
    List<List<String>> res = new ArrayList<>();
    List<String> strings = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] allowed = new char[n][n];
        backStrack(allowed, n, 0);
        return res;
    }

    public void backStrack(char[][] allowed,int n, int startRow){
        String temp = new String(allowed[n-1]);
        System.out.println(temp);
        if (temp.indexOf('Q')!=-1){
            List<String> subRes = new ArrayList<>();
            for (int i=0; i<n; i++) {
                StringBuffer stringBuffer = new StringBuffer();
                for (int j=0; j<n; j++){
                    if (allowed[i][j]!='Q')
                        stringBuffer.append('.');
                    else
                        stringBuffer.append('Q');
                }
                subRes.add(stringBuffer.toString());
            }
            res.add(new ArrayList<>(subRes));
            return;
        }

        for (int i=0; i<n && startRow<n; i++){
            if (startRow==0) allowed = new char[n][n];

            if (isAllowed(allowed, startRow, i, n)){
                allowed[startRow][i] = 'Q';
                backStrack(allowed, n, startRow+1);
                allowed[startRow][i] = '.';
            }
        }

    }

    public boolean isAllowed(char[][] allowed, int row, int column, int n){
        for (int i=0; i<n; i++) {
            if (i != column && allowed[row][i] == 'Q')
                return false;
            if (i != row &&  allowed[i][column] =='Q')
                return false;
        }
        for (int i=row,j=column; i<n&& j<n; i++, j++){
            if (i!=row && j!=column && allowed[i][j]=='Q')
                return false;
        }
        for (int i=row,j=column; i>=0&& j>=0; i--, j--){
            if (i!=row && j!=column && allowed[i][j]=='Q')
                return false;
        }
        for (int i=row,j=column; i>=0&& j<n; i--, j++){
            if (i!=row && j!=column && allowed[i][j]=='Q')
                return false;
        }
        for (int i=row,j=column; i<n && j<n; i++, j++){
            if (i!=row && j!=column && allowed[i][j]=='Q')
                return false;
        }
        for (int i=row,j=column; i<n && j>=0; i++, j--){
            if (i!=row && j!=column && allowed[i][j]=='Q')
                return false;
        }
        return true;
    }

    public void searchAllowed(boolean[][] allowed, int row, int column, int n){
        for (int i=0; i<n; i++){
            allowed[row][i]=true;
            allowed[i][column]=true;
        }
        for (int i=row,j=column; i<n&& j<n; i++, j++){
            allowed[i][j]=true;
        }
        for (int i=row,j=column; i>=0&& j>=0; i--, j--){
            allowed[i][j]=true;
        }
    }


    public static void main(String[] args) {
        LC51 lc51 = new LC51();
        lc51.solveNQueens(4);
    }
}
