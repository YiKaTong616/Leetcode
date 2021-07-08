package unique_binary_search_trees_96;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.1 MB, 在所有 Java 提交中击败了 71.39% 的用户
 */
public class Solution1
{
    public int numTrees(int n)
    {
        int[] record = new int[n + 1];
        record[0] = 1;
        record[1] = 1;

        for (int i = 2; i < n + 1; i++)
            for (int j = 0; j < i; j++)
                record[i] += record[j] * record[(i - 1) - j];

        return record[n];
    }
}
