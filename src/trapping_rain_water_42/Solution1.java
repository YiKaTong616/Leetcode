package trapping_rain_water_42;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 99.99% 的用户
 * 内存消耗：38.1 MB, 在所有 Java 提交中击败了 45.26% 的用户
 */
public class Solution1
{
    public int trap(int[] height)
    {
        if (height == null || height.length == 0) return 0;

        int length = height.length;
        int[] leftMax = new int[length], rightMax = new int[length];

        leftMax[0] = height[0];
        rightMax[length - 1] = height[length - 1];
        for (int i = 1; i < length; i++)
        {
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
            rightMax[length - 1 - i] = Math.max(height[length - 1 - i], rightMax[length - i]);
        }

        int sum = 0;
        for (int i = 0; i < length; i++)
            sum += Math.min(leftMax[i], rightMax[i]) - height[i];
        return sum;
    }
}
