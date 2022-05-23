package backtracking;

import org.junit.jupiter.api.Test;

import javax.crypto.interfaces.PBEKey;

/**
 * @author cz
 * @Description 解数独
 * @date 2022/5/19 9:01
 **/
public class LC37 {

    public void solveSudoku(char[][] board) {
        backStrack(0,board);
        System.out.println(11);
    }

    public boolean backStrack(int cow, char[][] board){
        // 无须终止条件
        for (int i=cow; i<9; i++){  // 控制 每一行 填充的数字 i=当前行开始 适当的剪枝

            for (int j=0; j<9; j++){        // eg i==0 时, j从0-8 依次填充第一行的每一列
                if (board[i][j]!='.') continue;
                for (int value=1; value<10; value++){
                    if (isValid(i, j, value, board)){
                        board[i][j] =  (char) (value+48);
                        if (backStrack(i,board)) return true;  // 当前位置填入正确，直接结束
                        board[i][j]='.';
                    }
                }
                return  false;   // 数独无解的情况
            }
        }
        return true;
    }

    public boolean isValid(int cow, int column, int value, char[][] board){

        for (int i=0; i<9; i++){
            if (board[i][column] - '0'==value) return false;
        }
        for (int i=0; i<9; i++){
            if (board[cow][i] - '0'==value) return false;
        }
        int beginRow=(cow/3)*3, beginColumn=(column/3)*3;

        for (int i=beginRow; i<beginRow+3; i++){
            for (int j=beginColumn; j<beginColumn+3; j++){
                if (i!=cow && j!=column && board[i][j]-'0'==value)
                    return false;
            }
        }
        return true;
    }

    @Test
    public void test(){
        char[][] board = new char[9][9];
        board= new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'}, {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'}, {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'}, {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};

        new LC37().solveSudoku(board);
    }
}
