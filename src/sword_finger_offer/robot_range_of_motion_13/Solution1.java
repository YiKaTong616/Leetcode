package sword_finger_offer.robot_range_of_motion_13;

/**
 * 执行用时：4 ms, 在所有 Java 提交中击败了 27.99% 的用户
 * 内存消耗：37.6 MB, 在所有 Java 提交中击败了 6.56% 的用户
 */
public class Solution1
{
    public static int movingCount(int m, int n, int k)
    {
        int[][] record = new int[m][n];

        dfs(record, 0, 0, k);

        int res = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (record[i][j] == -1)
                    res += 1;

        return res;
    }

    public static void dfs(int[][] record, int i, int j, int k)
    {
        if (i < 0 || i > record.length - 1 || j < 0 || j > record[0].length - 1 || record[i][j] == -1)
            return;

        if (isPosValid(i, j, k))
        {
            record[i][j] = -1;
            dfs(record, i - 1, j, k);
            dfs(record, i + 1, j, k);
            dfs(record, i, j - 1, k);
            dfs(record, i, j + 1, k);
        }
    }

    public static boolean isPosValid(int i, int j, int k)
    {
        int[] nums1 = generateNums(i);
        int[] nums2 = generateNums(j);

        int sum1 = 0, sum2 = 0;
        for (int p = 0; p < 3; p++)
        {
            sum1 += nums1[p];
            sum2 += nums2[p];
        }
        return sum1 + sum2 <= k;
    }

    public static int[] generateNums(int n)
    {
        int[] nums = new int[3];

        for (int i = 0; i < 3; i++)
            nums[i] = (n / (int) Math.pow(10, i)) % 10;

        return nums;
    }

    public static void main(String[] args)
    {
        System.out.println(movingCount(2, 3, 1));
    }
}
