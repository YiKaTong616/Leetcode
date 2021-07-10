package find_minimum_in_rotated_sorted_array_153;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38 MB, 在所有 Java 提交中击败了 30.66% 的用户
 */
public class Solution1
{
    public static int findMin(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end)
        {
            int mid = (start + end) / 2;

            if (nums[mid] < nums[end])
            {
                if (mid == 0 || nums[mid] < nums[mid - 1])
                    return nums[mid];

                end = mid - 1;
            } else if (nums[mid] == nums[end])
                return nums[mid];
            else
                start = mid + 1;
        }

        return 0;
    }

    public static void main(String[] args)
    {
        System.out.println(findMin(new int[]{3, 1, 2}));
    }
}
