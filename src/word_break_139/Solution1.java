package word_break_139;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 执行用时：3 ms, 在所有 Java 提交中击败了 89.83% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 73.41% 的用户
 */
public class Solution1
{
    public static boolean wordBreak(String s, List<String> wordDict)
    {
        if (s == null || s.length() == 0 || wordDict == null || wordDict.size() == 0)
            return false;

        Set<String> record = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()];

        //[0...j]和[j + 1, i]
        for (int i = 0; i < s.length(); i++)
            for (int j = i - 1; j >= -1; j--)
            {
                if (j == -1)
                    dp[i] = record.contains(s.substring(0, i + 1));
                else
                    dp[i] = dp[j] && record.contains(s.substring(j + 1, i + 1));

                if (dp[i]) break;
            }


        return dp[s.length() - 1];
    }

    public static void main(String[] args)
    {
        System.out.println(wordBreak("catsanddog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
    }
}
