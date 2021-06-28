package maximum_subarray_53;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 95.49% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了 71.29% 的用户
 */
public class Solution1
{
    public static int maxSubArray(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        int[] record = new int[nums.length];
        record[0] = nums[0];

        int max = record[0];
        for (int i = 1; i < nums.length; i++)
        {
            if (record[i - 1] < 0) record[i] = nums[i];
            else record[i] = nums[i] + record[i - 1];

            max = Math.max(max, record[i]);
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(maxSubArray(new int[] {-2,1,-3,4,-1,2,1,-5,4}));
    }
}
