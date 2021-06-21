package container_with_most_water_11;

public class Solution1
{
    public int maxArea(int[] height)
    {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right)
        {
            int area = (right - left) * Math.min(height[left], height[right]);
            max = Math.max(max, area);
            if (height[left] < height[right]) left++;
            else if (height[left] > height[right]) right--;
            else
            {
                left++;
                right--;
            }
        }
        return max;
    }
}
