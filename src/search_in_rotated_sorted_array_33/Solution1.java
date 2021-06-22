package search_in_rotated_sorted_array_33;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了 50.67% 的用户
 */
public class Solution1
{
    public static int search(int[] nums, int target)
    {
        int res = -1;

        int start = 0, end = nums.length - 1;
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            boolean isLeftValid = nums[mid] >= nums[start];
            if (isLeftValid)
                res = binarySearch(nums, start, mid, target);
            else
                res = binarySearch(nums, mid + 1, end, target);
            if (res != -1) return res;
            if (isLeftValid) start = mid + 1;
            else end = mid - 1;
        }
        return res;
    }

    private static int binarySearch(int[] nums, int start, int end, int target)
    {
        while (start <= end)
        {
            int mid = (start + end) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] > target) end = mid - 1;
            else start = mid + 1;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        System.out.println(search(new int[]{5, 1, 3}, 1));
    }
}
