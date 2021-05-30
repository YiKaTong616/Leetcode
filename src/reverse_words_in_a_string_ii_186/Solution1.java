package reverse_words_in_a_string_ii_186;

/**
 * 解答成功: 执行耗时:1 ms,击败了100.00% 的Java用户 内存消耗:41.5 MB,击败了72.53% 的Java用户
 */
public class Solution1
{
    public static void reverseWords(char[] s)
    {
        int nextStart = 0;
        while (nextStart < s.length)
            nextStart = handle(s, nextStart);

        for (int i = 0, j = s.length - 1; i < j; i++, j--)
        {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static int handle(char[] s, int start)
    {
        int end = start + 1;
        for (; end < s.length && s[end] != ' '; end++) ;
        int nextStart = end-- + 1;
        while (end > start)
        {
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
        return nextStart;
    }

    public static void main(String[] args)
    {
        char[] s = {};
        reverseWords(s);
        System.out.println(s);
    }
}
