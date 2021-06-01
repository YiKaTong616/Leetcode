package sword_finger_offer.symmetric_binary_tree_28;

import help.TreeNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.3 MB, 在所有 Java 提交中击败了 74.57% 的用户
 */
public class Solution2
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null) return true;

        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;

        return isSymmetric(t1.left, t2.right) && isSymmetric(t1.right, t2.left);
    }
}
