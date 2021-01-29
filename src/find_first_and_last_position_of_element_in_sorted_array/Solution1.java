package find_first_and_last_position_of_element_in_sorted_array;

/*
	解答成功:
	执行耗时:0 ms,击败了100.00% 的Java用户
	内存消耗:41.6 MB,击败了61.16% 的Java用户
 */
public class Solution1
{
    public int[] searchRange(int[] nums, int target)
    {
        if (nums.length == 0 || target < nums[0] || target > nums[nums.length - 1])
            return new int[]{-1, -1};

        return new int[]{findSmall(nums, target), findBig(nums, target)};
    }

    private int findBig(int[] nums, int target)
    {
        if (nums[nums.length - 1] == target)
            return nums[nums.length - 1];

        int leftPos = 0;
        int rightPos = nums.length - 1;

        while (leftPos < rightPos)
        {
            int midPos = (leftPos + rightPos) / 2;
            if (nums[midPos] <= target)
                leftPos = midPos + 1;
            else if (nums[midPos] > target)
                rightPos = midPos;
        }

        if (nums[leftPos - 1] == target)
            return leftPos - 1;
        else
            return -1;
    }

    private int findSmall(int[] nums, int target)
    {
        if (nums[0] == target)
            return 0;

        int leftPos = 0;
        int rightPos = nums.length - 1;

        while (leftPos < rightPos)
        {
            int midPos = (leftPos + rightPos + 1) / 2;
            if (nums[midPos] < target)
                leftPos = midPos;
            else if (nums[midPos] >= target)
                rightPos = midPos + 1;
        }

        if (nums[leftPos + 1] == target)
            return leftPos + 1;
        else
            return -1;
    }
}
