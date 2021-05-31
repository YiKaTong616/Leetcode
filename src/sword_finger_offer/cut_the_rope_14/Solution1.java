package sword_finger_offer.cut_the_rope_14;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 44.78% 的用户
 * 内存消耗：35.4 MB, 在所有 Java 提交中击败了 20.64% 的用户
 */
public class Solution1
{
    public static int cuttingRope(int n)
    {
        if (n < 2)
            return -1;

        int[] record = new int[n + 1];
        record[2] = 1;
        for (int i = 3; i <= n; i++)
        {
            int max = -1;
            for (int j = 1; j < i; j++)
            {
                int a = j * record[i - j];
                int b = j * (i - j);

                max = Math.max(max, Math.max(a, b));
            }
            record[i] = max;
        }
        return record[n];
    }

    public static void main(String[] args)
    {
        System.out.println(cuttingRope(58));
    }
}
