package longest_substring_with_at_most_two_distinct_characters_159;

import java.util.HashMap;

/**
 * 解答成功: 执行耗时:6 ms,击败了66.67% 的 Java 用户 内存消耗:38.5 MB,击败了 56.80% 的 Java 用户
 */
public class Solution1
{
    public static int lengthOfLongestSubstringTwoDistinct(String s)
    {
        if (s == null) return 0;
        if (s.length() < 3) return s.length();

        HashMap<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        int start = 0, end = 1, len = s.length(), max = 1;

        while (end < len)
        {
            char c = s.charAt(end);
            if (map.containsKey(c))
            {
                int num = map.get(c);
                map.put(c, num + 1);
                end++;

                max = Math.max(max, end - start);
            } else if (map.size() < 2)
            {
                map.put(c, 1);
                end++;

                max = Math.max(max, end - start);
            } else
            {
                char startChar = s.charAt(start);
                int num = map.get(startChar);

                if (num > 1) map.put(startChar, num - 1);
                else if (num == 1) map.remove(startChar);

                start++;
            }
        }

        return max;
    }

    public static void main(String[] args)
    {
        System.out.println(lengthOfLongestSubstringTwoDistinct("eceba"));
    }
}
