package one_edit_distance_161;

/**
 * 解答成功: 执行耗时:2 ms,击败了48.46% 的Java用户 内存消耗:37.1 MB,击败了58.02% 的Java用户
 */
public class Solution1
{
    public static boolean isOneEditDistance(String s, String t)
    {
        if (s == null || t == null) return false;
        if (Math.abs(s.length() - t.length()) > 1) return false;

        String shortString = s.length() < t.length() ? s : t;
        String longString = shortString != s ? s : t;

        int shortIndex = 0, longIndex = 0;
        boolean hasEdit = false, isSameLength = shortString.length() == longString.length();

        if (!isSameLength && shortString.equals(longString.substring(0, longString.length() - 1)))
            return true;

        while (shortIndex < shortString.length() && longIndex < longString.length())
        {
            char sc = shortString.charAt(shortIndex);
            char lc = longString.charAt(longIndex);

            if (sc == lc)
            {
                shortIndex++;
                longIndex++;
            } else if (!hasEdit)
            {
                hasEdit = true;
                if (isSameLength)
                    shortIndex++;
                longIndex++;
            } else
                return false;
        }

        return hasEdit;
    }

    public static void main(String[] args)
    {
        System.out.println(isOneEditDistance("", ""));
    }
}
