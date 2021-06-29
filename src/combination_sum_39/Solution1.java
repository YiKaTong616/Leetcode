package combination_sum_39;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了 31.52% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了 95.92% 的用户
 */
public class Solution1
{
    public int[] candidates = null;
    public List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target)
    {
        if (candidates == null || candidates.length == 0)
            return res;

        this.candidates = candidates;
        dfs(target, new ArrayList<>(), 0);

        return res;
    }

    public void dfs(int target, List<Integer> list, int idx)
    {
        if (target <= 0)
        {
            if (target == 0)
            {
                List<Integer> temp = new ArrayList<>(list);
                res.add(temp);
            }
            return;
        }
        if (idx >= candidates.length)
            return;

        dfs(target, list, idx + 1);
        list.add(candidates[idx]);
        dfs(target - candidates[idx], list, idx);
        list.remove(list.size() - 1);
    }
}
