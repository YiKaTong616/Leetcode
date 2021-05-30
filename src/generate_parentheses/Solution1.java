package generate_parentheses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 执行用时: 19 ms
 * 内存消耗: 38.9 MB
 */
public class Solution1
{
    public static void main(String[] args)
    {
        System.out.println(generateParenthesis(2));
    }

    public static List<String> generateParenthesis(int n)
    {
        if (n == 1)
        {
            List<String> list = new ArrayList<>();
            list.add("()");
            return list;
        }

        List<String> preList = generateParenthesis(n - 1);
        Set<String> postSet = new HashSet<>();
        for (int i = 0; i < preList.size(); i++)
        {
            StringBuilder sb = new StringBuilder(preList.get(i));
            for (int j = 0; j < sb.length(); j++)
            {
                sb.insert(j, '(');
                for (int k = j + 1; k <= sb.length(); k++)
                {
                    sb.insert(k, ')');
                    postSet.add(sb.toString());
                    sb.deleteCharAt(k);
                }
                sb.deleteCharAt(j);
            }
        }
        return new ArrayList<>(postSet);
    }
}
