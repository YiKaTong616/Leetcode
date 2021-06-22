package first_missing_positive_41;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了 38.41% 的用户
 * 内存消耗：84.6 MB, 在所有 Java 提交中击败了 22.42% 的用户
 */
public class Solution2
{
    public static int firstMissingPositive(int[] nums)
    {
        for (int i = 0; i < nums.length; i++)
            if (nums[i] >= 1 && nums[i] <= nums.length)
            {
                int curPos = i, targetPos = nums[curPos] - 1;
                if (curPos == targetPos || nums[targetPos] == nums[curPos]) continue;
                int temp = nums[curPos];
                nums[curPos] = nums[targetPos];
                nums[targetPos] = temp;
                i--;
            }

        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }

    public static void main(String[] args)
    {
        System.out.println(firstMissingPositive(new int[]{1}));
    }
}
