package sword_finger_offer.repeated_numbers_in_the_array_01;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了 50.47% 的用户
 * 内存消耗：48.4 MB, 在所有 Java 提交中击败了 12.72% 的用户
 */
public class Solution1
{
    public static int findRepeatNumber(int[] nums)
    {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++)
            if (!set.add(nums[i]))
                return nums[i];
        return -1;
    }

    public static void main(String[] args)
    {
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }
}
