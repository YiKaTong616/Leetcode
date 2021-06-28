package group_anagrams_49;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 执行用时：11 ms, 在所有 Java 提交中击败了 33.89% 的用户
 * 内存消耗：41.2 MB, 在所有 Java 提交中击败了 83.06% 的用户
 */
public class Solution1
{
    public List<List<String>> groupAnagrams(String[] strs)
    {
        return new ArrayList<>(Arrays.stream(strs)
                .collect(Collectors.groupingBy(str -> {
                    // 返回 str 排序后的结果。
                    // 按排序后的结果来grouping by，算子类似于 sql 里的 group by。
                    char[] array = str.toCharArray();
                    Arrays.sort(array);
                    return new String(array);
                })).values());
    }
}
