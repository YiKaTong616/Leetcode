package first_missing_positive_41;

/**
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * <p>
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,0]
 * 输出：3
 * 示例 2：
 * <p>
 * 输入：nums = [3,4,-1,1]
 * 输出：2
 * 示例 3：
 * <p>
 * 输入：nums = [7,8,9,11,12]
 * 输出：1
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 5 * 105
 * -231 <= nums[i] <= 231 - 1
 */
public class Solution1
{
    public static int firstMissingPositive(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] <= 0)
                nums[i] = nums.length + 1;

        for (int i = 0; i < nums.length; i++)
        {
            if (Math.abs(nums[i]) >= 1 && Math.abs(nums[i]) <= nums.length && nums[Math.abs(nums[i]) - 1] > 0)
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
        }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0)
                return i + 1;

        return nums.length + 1;
    }

    public static void main(String[] args)
    {
        System.out.println(firstMissingPositive(new int[]{1, 1}));
    }
}

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了 16.42% 的用户
 * 内存消耗：84.3 MB, 在所有 Java 提交中击败了 35.43% 的用户
 */
