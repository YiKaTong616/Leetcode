package rotate_image_48;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 21.42% 的用户
 */
public class Solution1
{
    public void rotate(int[][] matrix)
    {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || matrix.length != matrix[0].length)
            return;

        int n = matrix.length;

        for (int i1 = 0, i2 = n - 1; i1 < i2; i1++, i2--)
            for (int j = 0; j < n; j++)
                swap(matrix, i1, j, i2, j);

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                swap(matrix, i, j, j, i);
    }

    private void swap(int[][] matrix, int i1, int j1, int i2, int j2)
    {
        int temp = matrix[i1][j1];
        matrix[i1][j1] = matrix[i2][j2];
        matrix[i2][j2] = temp;
    }
}
