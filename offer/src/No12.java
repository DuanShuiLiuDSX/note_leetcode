import org.junit.jupiter.api.Test;

/**
 * @author cz
 * @Description 矩阵中的路径
 * @date 2022/4/11 10:17
 **/
public class No12 {
    public class Solution1 {

        public boolean exist(char[][] board, String word) {
            char[] words = word.toCharArray();
            for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                    if(dfs(board, words, i, j, 0))
                        return true;
                }
            }
            return false;
        }
        boolean dfs(char[][] board, char[] word, int i, int j, int k) {
            if(i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k])
                return false;
            if(k == word.length - 1)
                return true;
            board[i][j] = '\0';
            boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                    dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i , j - 1, k + 1);
            board[i][j] = word[k];
            return res;
        }


    }

    static class Solution {
        public static boolean exist(char[][] board, String word) {
            boolean res=false;
            char[] words = word.toCharArray();
            for(int i=0; i<board.length; i++){
                for(int j=0; j<board[0].length; j++){
                    res = res || dfs(board, i, j, words, 0);
                }
            }
            return res;
        }

        public static boolean dfs(char[][] board, int row, int column, char[] words, int index){
            if(row<0 || row>=board.length || column<0 || column>=board[0].length || board[row][column]!=words[index])
                return false;
            if(index==words.length-1) return true;

            // · 重复的元素
             board[row][column] = '1';
             boolean res = dfs(board, row-1, column, words, index+1) || dfs(board, row+1, column, words, index+1) ||
             dfs(board, row, column-1, words, index+1) || dfs(board, row, column+1, words, index+1);

             // 将原位置的元素还原
            // 还原操作 在递归操作之后 不影响递归搜索的判断
            /**
             *  例如这种情况
             *  [["C","A","A"],
             *   ["A","A","A"],
             *   ["B","C","D"]]
             *   "AAB"
             */
             board[row][column] = words[index];
             return res;

        }
    }

    @Test
    public void test(){
        Solution.exist(new char[][]{{'a','b'}}, "ba");
    }
}
