package unique_paths_62;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.3 MB, 在所有 Java 提交中击败了 39.08% 的用户
 */
public class Solution1
{
    public static int uniquePaths(int m, int n)
    {
        int[][] dp = new int[m][n];
        for (int i = 0, j = 0; i < m || j < n; i++, j++)
        {
            if (i < m) dp[i][0] = 1;
            if (j < n) dp[0][j] = 1;
        }

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args)
    {
        System.out.println(uniquePaths(1, 1));
    }
}
