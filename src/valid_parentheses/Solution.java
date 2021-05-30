package valid_parentheses;

import java.util.Stack;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了 77.22% 的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了 80.45% 的用户
 */
public class Solution
{
    public boolean isValid(String s)
    {
        if (s == null)
            return false;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++)
        {
            char currentChar = s.charAt(i);
            char topChar = 0;
            if (!stack.isEmpty())
                topChar = stack.peek();
            if (isMatch(currentChar, topChar) && currentChar > topChar)
                stack.pop();
            else
                stack.push(currentChar);
        }
        return stack.isEmpty();
    }

    public boolean isMatch(char c1, char c2)
    {
        if (c1 == '(')
            return c2 == ')';
        else if (c1 == ')')
            return c2 == '(';
        else if (c1 == '[')
            return c2 == ']';
        else if (c1 == ']')
            return c2 == '[';
        else if (c1 == '{')
            return c2 == '}';
        else if (c1 == '}')
            return c2 == '{';
        return false;
    }
}
