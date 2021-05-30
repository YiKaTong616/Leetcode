package sword_finger_offer.replace_spaces_03;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了 41.49% 的用户
 */
public class Solution1
{
    public String replaceSpace(String s)
    {
        if (s == null) return null;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) != ' ')
                sb.append(s.charAt(i));
            else
                sb.append("%20");

        return sb.toString();
    }
}
