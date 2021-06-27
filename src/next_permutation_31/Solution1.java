package next_permutation_31;

import java.util.Arrays;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 97.21% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 33.42% 的用户
 */
public class Solution1
{
    public static void nextPermutation(int[] nums)
    {
        for (int i = nums.length - 2; i >= 0; i--)
        {
            int targetPos = find(nums, i);
            if (targetPos == -1)
                continue;
            else
            {
                swap(nums, i, targetPos);
                reverse(nums, i + 1);
                return;
            }
        }

        reverse(nums, 0);
    }

    private static int find(int[] nums, int start)
    {
        int targetPos = -1;
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < nums.length; i++)
            if (nums[i] > nums[start] && nums[i] <= min)
            {
                targetPos = i;
                min = nums[i];
            }
        return targetPos;
    }

    private static void swap(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int start)
    {
        int end = nums.length - 1;
        for (; start < end; start++, end--)
        {
            swap(nums, start, end);
        }
    }

    public static void main(String[] args)
    {
        int[] res = new int[]{2,3,1};
        nextPermutation(res);
        System.out.println(Arrays.toString(res));
    }
}
