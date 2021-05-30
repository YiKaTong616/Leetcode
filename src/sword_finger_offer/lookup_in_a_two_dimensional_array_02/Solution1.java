package sword_finger_offer.lookup_in_a_two_dimensional_array_02;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 9.78% 的用户
 * 内存消耗：44.2 MB, 在所有 Java 提交中击败了 44.72% 的用户
 */
public class Solution1
{
    public boolean findNumberIn2DArray(int[][] matrix, int target)
    {
        if (matrix.length == 0 || matrix[0].length == 0)
            return false;

        int width = matrix[0].length;
        int height = matrix.length;

        for (int i = 0; i < height; i++)
        {
            if (matrix[i][0] > target) return false;
            for (int j = 0; j < width; j++)
            {
                if (matrix[i][j] < target) continue;
                else if (matrix[i][j] == target) return true;
                else if (matrix[i][j] > target) break;

            }
        }

        return false;
    }
}
