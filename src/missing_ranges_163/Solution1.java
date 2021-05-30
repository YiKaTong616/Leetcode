package missing_ranges_163;

import java.util.ArrayList;
import java.util.List;

/**
 * 解答成功: 执行耗时:7 ms,击败了89.66% 的Java用户 内存消耗:36.6 MB,击败了93.10% 的Java用户
 */
public class Solution1
{
    public static List<String> res = new ArrayList<>();

    public static List<String> findMissingRanges(int[] nums, int lower, int upper)
    {
        if (nums.length == 0)
        {
            generateString(lower, upper);
            return res;
        }

        if (lower < nums[0])
            generateString(lower, nums[0] - 1);

        int index = 1;

        while (index < nums.length)
        {
            int currentNum = nums[index];
            int lastNum = nums[index - 1];

            if (currentNum - lastNum > 1)
                generateString(lastNum + 1, currentNum - 1);

            index++;
        }

        if (nums[index - 1] < upper)
            generateString(nums[index - 1] + 1, upper);

        return res;
    }

    public static void generateString(int start, int end)
    {
        if (start == end)
            res.add(String.valueOf(start));
        else
            res.add(start + "->" + end);
    }

    public static void main(String[] args)
    {
        int[] nums = new int[]{};
        System.out.println(findMissingRanges(nums, 0, 1));
    }
}
