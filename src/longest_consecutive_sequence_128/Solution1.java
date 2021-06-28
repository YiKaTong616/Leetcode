package longest_consecutive_sequence_128;

import java.util.HashSet;
import java.util.Set;

/**
 * 执行用时：16 ms, 在所有 Java 提交中击败了 52.94% 的用户
 * 内存消耗：53.4 MB, 在所有 Java 提交中击败了 20.59% 的用户
 */
public class Solution1
{
    public static int longestConsecutive(int[] nums)
    {
        if (nums == null || nums.length == 0)
            return 0;

        Set<Integer> set = new HashSet<>();
        for (int num : nums)
            set.add(num);

        int maxLen = 1;
        int currentLen = 1;
        for (int num : set)
        {
            int n = num;
            if (set.contains(n - 1))
                continue;

            while (set.contains(++n))
                currentLen++;
            maxLen = Math.max(maxLen, currentLen);
            currentLen = 1;
        }

        return maxLen;
    }

    public static void main(String[] args)
    {
        System.out.println(longestConsecutive(new int[] {}));
    }
}
