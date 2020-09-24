import java.util.*;

/**
 *
 编写一个程序，通过已填充的空格来解决数独问题。

 一个数独的解法需遵循如下规则：

 数字 1-9 在每一行只能出现一次。
 数字 1-9 在每一列只能出现一次。
 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 空白格用 '.' 表示。

 输入：
 [['5','3','.','.','7','.','.','.','.'],
  ['6','.','.','1','9','5','.','.','.'],
  ['.','9','8','.','.','.','.','6','.'],
  ['8','.','.','.','6','.','.','.','3'],
  ['4','.','.','8','.','3','.','.','1'],
  ['7','.','.','.','2','.','.','.','6'],
  ['.','6','.','.','.','.','2','8','.'],
  ['.','.','.','4','1','9','.','.','5'],
  ['.','.','.','.','8','.','.','7','9']]

 预期输出：
 [['5','3','4','6','7','8','9','1','2'],
  ['6','7','2','1','9','5','3','4','8'],
  ['1','9','8','3','4','2','5','6','7'],
  ['8','5','9','7','6','1','4','2','3'],
  ['4','2','6','8','5','3','7','9','1'],
  ['7','1','3','9','2','4','8','5','6'],
  ['9','6','1','5','3','7','2','8','4'],
  ['2','8','7','4','1','9','6','3','5'],
  ['3','4','5','2','8','6','1','7','9']]

 [['.','.','9','7','4','8','.','.','.'],
  ['7','.','.','.','.','.','.','.','.'],
  ['.','2','.','1','.','9','.','.','.'],
  ['.','.','7','.','.','.','2','4','.'],
  ['.','6','4','.','1','.','5','9','.'],
  ['.','9','8','.','.','.','3','.','.'],
  ['.','.','.','8','.','3','.','2','.'],
  ['.','.','.','.','.','.','.','.','6'],
  ['.','.','.','2','7','5','9','.','.']]
 Note:

 给定的数独序列只包含数字 1-9 和字符 '.' 。
 你可以假设给定的数独只有唯一解。
 给定数独永远是 9x9 形式的。

 */
class Solution {
    public void solveSudoku(char[][] board) {
        for (char[] items : board) {
            System.out.println(Arrays.toString(items));
        }
        char[][] res = this.loopSolve(board);
        System.out.println("============================");
        for (char[] items : res) {
            System.out.println(Arrays.toString(items));
        }
        // this.cellSolution(board, 4,4);
    }

    public char[][] loopSolve(char[][] board) {
        int nullCell = 1;
        int t = 81;
        while (nullCell > 0 && t > 0) {
            nullCell = 0;
            for (int i= 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (board[i][j] == '.') {
                        String[] cellRes = this.cellSolution(board, i, j);
                        if (cellRes.length == 1) {
                            // System.out.println('i ' + i + ' j ' + j);
                            // System.out.println(Arrays.toString(cellRes));
                            board[i][j] = cellRes[0].toCharArray()[0];
                        }
                        nullCell++;
                    }
                }
            }
            t--;
        }
        return board;
    }

    public String[] cellSolution(char[][] board, int x, int y) {
        // 遍历x行
        Set existNum = new HashSet();
        for (int i = 0; i < 9; i++) {
            char xItem = board[x][i];
            if (xItem != '.') {
                existNum.add(xItem);
            }
        }
        for (int i = 0; i < 9; i++) {
            char yItem = board[i][y];
            if (yItem != '.') {
                existNum.add(yItem);
            }
        }
        int xStart = 0, xEnd = 0, yStart = 0, yEnd = 0;
        if (x <= 2) {
            xStart = 0; xEnd = 2;
        }
        if (x >= 3 && x <= 5) {
            xStart = 3; xEnd = 5;
        }
        if ( x >= 6 && x <= 8) {
            xStart = 6; xEnd = 8;
        }
        if (y <= 2) {
            yStart = 0; yEnd = 2;
        }
        if (y >= 3 && y <= 5) {
            yStart = 3; yEnd = 5;
        }
        if ( y >= 6 && y <= 8) {
            yStart = 6; yEnd = 8;
        }
        for (int i = xStart; i <= xEnd; i++) {
            for (int j = yStart; j <= yEnd; j++) {
                if (board[i][j] != '.') {
                    existNum.add(board[i][j]);
                   // System.out.println(board[i][j]);
                }
            }
        }

        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            String num = "" + i;
            char[] charNum = num.toCharArray();
            if (existNum.contains(charNum[0])) {
                continue;
            }
            list.add(num);
        }
        String [] res = list.toArray(new String[list.size()]);
        return res;
    }

    public static void main(String[] args) {
        char[][] inputArr;
       // inputArr = new char[][]
       //         {{'5','3','.','.','7','.','.','.','.'},
       //         {'6','.','.','1','9','5','.','.','.'},
       //         {'.','9','8','.','.','.','.','6','.'},
       //         {'8','.','.','.','6','.','.','.','3'},
       //         {'4','.','.','8','.','3','.','.','1'},
       //         {'7','.','.','.','2','.','.','.','6'},
       //         {'.','6','.','.','.','.','2','8','.'},
       //         {'.','.','.','4','1','9','.','.','5'},
       //         {'.','.','.','.','8','.','.','7','9'}};
        inputArr = new char[][]
                {{'.','.','9','7','4','8','.','.','.'},
                {'7','.','.','.','.','.','.','.','.'},
                {'.','2','.','1','.','9','.','.','.'},
                {'.','.','7','.','.','.','2','4','.'},
                {'.','6','4','.','1','.','5','9','.'},
                {'.','9','8','.','.','.','3','.','.'},
                {'.','.','.','8','.','3','.','2','.'},
                {'.','.','.','.','.','.','.','.','6'},
                {'.','.','.','2','7','5','9','.','.'}};
        Solution solution = new Solution();
        solution.solveSudoku(inputArr);
    }
}