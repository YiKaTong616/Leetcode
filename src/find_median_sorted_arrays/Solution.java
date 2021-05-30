package find_median_sorted_arrays;

public class Solution
{
//    public double findMedianSortedArrays(int[] nums1, int[] nums2)
//    {
//        int begin1 = 0;
//        int end1 = nums1.length - 1;
//        int begin2 = 0;
//        int end2 = nums2.length - 1;
//
//        int count = 0;
//        int targetCount = (nums1.length + nums2.length) / 2;
//
//        while (count != targetCount)
//        {
//            if (nums1[begin1] <= nums2[begin2])
//            {
//                begin1 = findPos(nums1, begin1, end1, nums2[begin2]);
//                if (begin1 == -1)
//                {
//                    count =
//                }
//            }
//        }
//    }
//
//    //在数组nums的指定范围中寻找第一个大于targetNum的数的位置
//    private int findPos(int[] nums, int begin, int end, int targetNum)
//    {
//        if (targetNum >= nums[end])
//            return -1;
//
//        int tempBegin = begin;
//        int tempEnd = end;
//        while (tempBegin < tempEnd)
//        {
//            int midPos = (begin + end) / 2;
//            if (targetNum <= nums[midPos])
//                tempBegin = midPos + 1;
//            else
//                tempEnd = midPos;
//        }
//
//        return tempBegin;
//    }
}
