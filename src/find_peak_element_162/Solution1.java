package find_peak_element_162;

/**
 * 线性解法
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了 20.19% 的用户
 */
public class Solution1
{
    public int findPeakElement(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
            if (i + 1 < nums.length)
            {
                if (nums[i] > nums[i + 1])
                    return i;
            } else
                return i;

        return 0;
    }
}
