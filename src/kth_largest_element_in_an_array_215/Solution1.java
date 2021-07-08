package kth_largest_element_in_an_array_215;

/**
 * 执行用时：13 ms, 在所有 Java 提交中击败了 20.84% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 76.18% 的用户
 */
public class Solution1
{
    public static int findKthLargest(int[] nums, int k)
    {
        if (nums == null || nums.length == 0 || nums.length < k)
            return 0;

        return findK(nums, k, 0, nums.length - 1);
    }

    public static int findK(int[] nums, int k, int begin, int end)
    {
        int i = partition(nums, begin, end);
        int pos = end - i + 1;
        if (k == pos)
            return nums[i];
        else if (k < pos)
            return findK(nums, k, i + 1, end);
        else
            return findK(nums, k - pos, begin, i - 1);
    }

    public static int partition(int[] nums, int begin, int end)
    {
        int target = nums[end];

        int i = begin - 1;
        int j = begin;

        while (j < end)
            if (nums[j] <= target)
                swap(nums, ++i, j++);
            else
                j++;

        swap(nums, i + 1, end);
        return i + 1;
    }

    public static void swap(int[] nums, int i, int j)
    {
        if (i == j) return;

        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args)
    {
        System.out.println(findKthLargest(new int[] {3,2,3,1,2,4,5,5,6}, 4));
    }
}
