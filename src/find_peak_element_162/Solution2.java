package find_peak_element_162;

/**
 * 二分解法
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了 59.21% 的用户
 */
public class Solution2
{
    public int findPeakElement(int[] nums)
    {
        int start = 0;
        int end = nums.length - 1;

        while (start < end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                start = mid + 1;
        }

        return start;
    }
}
