package sword_finger_offer.tree_substructure;

import help.TreeNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.8 MB, 在所有 Java 提交中击败了 94.63% 的用户
 */
public class Solution1
{
    public boolean isSubStructure(TreeNode A, TreeNode B)
    {
        if (A == null || B == null) return false;

        if (judge(A, B)) return true;

        return isSubStructure(A.left, B) || isSubStructure(A.right, B);
    }

    public boolean judge(TreeNode t1, TreeNode t2)
    {
        if (t2 == null) return true;

        if (t1 == null) return false;

        if (t1.val != t2.val) return false;

        return judge(t1.left, t2.left) && judge(t1.right, t2.right);
    }
}
