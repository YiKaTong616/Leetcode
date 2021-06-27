package merge_intervals_56;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 执行用时：10 ms, 在所有 Java 提交中击败了 19.20% 的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了 41.03% 的用户
 */
public class Solution1
{
    public int[][] merge(int[][] intervals)
    {
        Arrays.sort(intervals, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] arr1, int[] arr2)
            {
                if (arr1[0] != arr2[0])
                    return arr1[0] - arr2[0];
                else
                    return arr1[1] - arr2[1];
            }
        });

        int targetPos = 0;
        for (int i = 1; i < intervals.length; i++)
            if (intervals[i][0] <= intervals[targetPos][1])
                intervals[targetPos][1] = Math.max(intervals[i][1], intervals[targetPos][1]);
            else
                intervals[++targetPos] = intervals[i];

        return Arrays.copyOfRange(intervals, 0, targetPos + 1);
    }
}
