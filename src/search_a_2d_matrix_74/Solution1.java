package search_a_2d_matrix_74;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了 31.56% 的用户
 */
public class Solution1
{
    public static boolean searchMatrix(int[][] matrix, int target)
    {
        int i = findRow(matrix, target);

        if (i < 0) return false;

        else return binarySearch(matrix[i], target);
    }

    private static boolean binarySearch(int[] nums, int target)
    {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (target < nums[mid])
                end = mid - 1;
            else if (target == nums[mid])
                return true;
            else
                start = mid + 1;
        }
        return false;
    }

    private static int findRow(int[][] matrix, int target)
    {
        int start = 0;
        int end = matrix.length - 1;
        int j = matrix[0].length - 1;

        while (start <= end)
        {
            if (target < matrix[start][0] || target > matrix[end][j])
                return -1;

            int mid = (start + end) / 2;

            if (target <= matrix[mid][j])
                end = mid;
            else
                start = mid + 1;

            if (start == end) return start;
        }

        return -1;
    }

    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        System.out.println(searchMatrix(matrix, -1));
    }
}
