package word_search_79;

/**
 * 执行用时：71 ms, 在所有 Java 提交中击败了 79.45% 的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了 72.10% 的用户
 */
public class Solution
{
    public char[][] mBoard;
    public String mWord;
    boolean[][] mRecord;

    public boolean exist(char[][] board, String word)
    {
        if (word.length() > board.length * board[0].length)
            return false;

        mBoard = board;
        mWord = word;
        mRecord = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (dfs(i, j, 0))
                    return true;

        return false;
    }

    private boolean dfs(int i, int j, int curPos)
    {
        if (curPos == mWord.length())
            return true;
        if (i < 0 || j < 0 || i >= mBoard.length || j >= mBoard[0].length)
            return false;
        if (mRecord[i][j])
            return false;

        if (mBoard[i][j] == mWord.charAt(curPos))
        {
            mRecord[i][j] = true;

            boolean dfs = dfs(i + 1, j, curPos + 1)
                    || dfs(i - 1, j, curPos + 1)
                    || dfs(i, j - 1, curPos + 1)
                    || dfs(i, j + 1, curPos + 1);
            if (!dfs)
                mRecord[i][j] = false;

            return dfs;
        }

        return false;
    }
}
