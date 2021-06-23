package permutations_46;

import java.util.*;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 * <p>
 * 输入：nums = [1]
 * 输出：[[1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Solution1
{
    public static List<List<Integer>> permute(int[] nums)
    {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        lists.add(list);

        for (int i = 1; i < nums.length; i++)
            lists = generate(nums[i], lists);

        return lists;
    }

    private static List<List<Integer>> generate(int nums, List<List<Integer>> lists)
    {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < lists.size(); i++)
        {
            for (int j = 0; j <= lists.get(i).size(); j++)
            {
                List<Integer> list = new ArrayList<>();
                Collections.addAll(list, new Integer[lists.get(i).size()]);
                Collections.copy(list, lists.get(i));
                if (j < lists.get(i).size()) list.add(j, nums);
                else list.add(nums);
                res.add(list);
            }
        }
        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(permute(new int[]{1}));
    }
}

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了 26.93% 的用户
 * 内存消耗：38.9 MB, 在所有 Java 提交中击败了 16.58% 的用户
 */
