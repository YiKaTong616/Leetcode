package longest_common_prefix_14;

/**
 * 执行用时: 1 ms, 在所有 Java 提交中击败了 84.45% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了 74.57% 的用户
 */
public class Solution1
{
    public static String longestCommonPrefix(String[] strs)
    {
        if (strs == null || strs.length == 0)
            return "";

        StringBuilder res = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++)
        {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++)
                if (i >= strs[j].length() || strs[j].charAt(i) != c)
                    return res.toString();
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }
}
