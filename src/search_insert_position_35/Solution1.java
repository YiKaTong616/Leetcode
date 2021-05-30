package search_insert_position_35;

/**
 * 解答成功: 执行耗时:0 ms,击败了100.00% 的Java用户 内存消耗:38.1 MB,击败了45.88% 的Java用
 */
public class Solution1
{
    public static int searchInsert(int[] nums, int target)
    {
        if (nums.length == 0)
            return 0;

        int start = 0;
        int end = nums.length - 1;

        while (true)
        {
            if (start == end)
            {
                if (target <= nums[start])
                    return start;
                else
                    return start + 1;
            }

            int mid = (start + end) / 2;
            if (target <= nums[mid])
                end = mid;
            else if (target > nums[mid])
                start = mid + 1;
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {-1, 0};
        int target = 0;
        System.out.println(searchInsert(nums, target));
    }
}
