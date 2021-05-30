package sword_finger_offer.lookup_in_a_two_dimensional_array_02;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：44.2 MB, 在所有 Java 提交中击败了 54.29% 的用户
 */
public class Solution2
{
    public boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++)
        {
            for (int j = n - 1; j >= 0; j--)
            {
                if (matrix[i][j] < target) break;
                else if (matrix[i][j] == target) return true;
                else continue;
            }
        }
        return false;
    }
}
