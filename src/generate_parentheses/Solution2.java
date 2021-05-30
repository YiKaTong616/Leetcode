package generate_parentheses;

import java.util.ArrayList;
import java.util.List;

/**
 * 执行用时: 5 ms
 * 内存消耗: 38.2 MB
 */
public class Solution2
{
    public static List<String> generateParenthesis(int n)
    {
        if (n == 1)
        {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }

        List<String> preList = generateParenthesis(n - 1);
        List<String> postList = new ArrayList<>();
        for (int i = 0; i < preList.size(); i++)
        {
            StringBuilder sb = new StringBuilder(preList.get(i));
            sb.insert(0, '(');
            for (int j = 1; j <= sb.length(); j++)
            {
                sb.insert(j, ')');
                postList.add(sb.toString());
                sb.deleteCharAt(j);
            }
            sb.deleteCharAt(0);
        }
        return postList;
    }
}
