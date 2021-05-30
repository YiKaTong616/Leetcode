package sword_finger_offer.path_in_the_matrix_12;

/**
 * 执行用时：6 ms, 在所有 Java 提交中击败了 66.15% 的用户
 * 内存消耗：40.2 MB, 在所有 Java 提交中击败了 57.21% 的用户
 */
public class Solution1
{
    public boolean exist(char[][] board, String word)
    {
        if (board.length == 0 || board[0].length == 0 || word == null || word.length() == 0)
            return false;

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(board, i, j, word, 0))
                    return true;

        return false;
    }

    public boolean dfs(char[][] board, int i, int j, String word, int k)
    {
        if (k == word.length())
            return true;

        if (i > board.length - 1 || j > board[0].length - 1 || i < 0 || j < 0)
            return false;

        char target = word.charAt(k);
        if (board[i][j] != target)
            return false;
        board[i][j] = ' ';

        if (dfs(board, i - 1, j, word, k + 1))
            return true;
        if (dfs(board, i + 1, j, word, k + 1))
            return true;
        if (dfs(board, i, j - 1, word, k + 1))
            return true;
        if (dfs(board, i, j + 1, word, k + 1))
            return true;

        board[i][j] = target;
        return false;
    }
}
