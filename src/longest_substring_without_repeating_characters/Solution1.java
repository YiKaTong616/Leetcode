package longest_substring_without_repeating_characters;

import java.util.*;

/**
 * 执行耗时:130 ms,击败了10.98% 的Java用户
 * 内存消耗:38.9 MB,击败了25.32% 的Java用户
 */
public class Solution1
{
    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstring("asds"));
    }

    static public int lengthOfLongestSubstring(String s)
    {
        if (s == null || s.length() == 0)
            return 0;

        int maxSubStringNum = 0;
        for (int i = 0; i < s.length(); i++)
        {
            Set<Character> tempSet = new HashSet<>();
            for (int j = i; j < s.length(); j++)
            {
                if (j == i)
                {
                    maxSubStringNum = Math.max(1, maxSubStringNum);
                    tempSet.add(s.charAt(j));
                    continue;
                }

                if (!tempSet.contains(s.charAt(j)))
                {
                    tempSet.add(s.charAt(j));
                    maxSubStringNum = Math.max(j - i + 1, maxSubStringNum);
                } else
                    break;
            }
        }

        return maxSubStringNum;
    }
}
