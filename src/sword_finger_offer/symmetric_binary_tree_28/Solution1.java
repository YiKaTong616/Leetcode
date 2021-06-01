package sword_finger_offer.symmetric_binary_tree_28;

import help.TreeNode;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 16.75% 的用户
 * 内存消耗：36.5 MB, 在所有 Java 提交中击败了 38.87% 的用户
 */
public class Solution1
{
    public boolean isSymmetric(TreeNode root)
    {
        if (root == null) return true;

        mirrorTree(root.right);

        return isSameTree(root.left, root.right);
    }

    public void mirrorTree(TreeNode root)
    {
        if (root == null) return;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);
    }

    public boolean isSameTree(TreeNode t1, TreeNode t2)
    {
        if (t1 == null && t2 == null) return true;

        if (t1 == null || t2 == null) return false;

        if (t1.val != t2.val) return false;

        return isSameTree(t1.left, t2.left) && isSameTree(t1.right, t2.right);

    }
}
