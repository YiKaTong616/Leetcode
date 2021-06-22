package roman_to_integer_13;

import java.util.HashMap;
import java.util.Map;

/**
 * 执行用时：10 ms, 在所有 Java 提交中击败了 15.31% 的用户
 * 内存消耗：38.7 MB, 在所有 Java 提交中击败了 43.02% 的用户
 */
public class Solution1
{
    public static Map<Character, Integer> map = new HashMap<>();

    static
    {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public static int romanToInt(String s)
    {
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException("s 不合法");

        int sum = 0;
        int index = 0;
        Integer curNum = map.get(s.charAt(0));
        Integer nexNum = index + 1 <= s.length() - 1 ? map.get(s.charAt(index + 1)) : null;
        while (index < s.length())
        {
            if (curNum == null)
                throw new IllegalArgumentException("s 不合法");
            if (index != s.length() - 1 && nexNum == null)
                throw new IllegalArgumentException("s 不合法");

            if (nexNum != null && curNum < nexNum)
                curNum = -curNum;
            sum += curNum;

            index++;
            curNum = nexNum;
            nexNum = index + 1 <= s.length() - 1 ? map.get(s.charAt(index + 1)) : null;
        }

        return sum;
    }

    public static void main(String[] args)
    {
        System.out.println(romanToInt("MCMXCIV"));
    }
}
