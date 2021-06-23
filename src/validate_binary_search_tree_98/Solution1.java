package validate_binary_search_tree_98;

import help.TreeNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了 32.41% 的用户
 */
public class Solution1
{
    public boolean isValidBST(TreeNode root)
    {
        if (root == null) return false;

        return isValid(root);
    }

    public boolean isValid(TreeNode root)
    {
        if (root == null) return true;

        if (root.left != null && root.left.val >= root.val) return false;
        if (root.right != null && root.right.val <= root.val) return false;

        TreeNode tempLeft = root.left, tempRight = root.right;
        if (tempLeft != null)
            while (tempLeft.right != null) tempLeft = tempLeft.right;
        if (tempRight != null)
            while (tempRight.left != null) tempRight = tempRight.left;
        if (tempLeft != null && root.val <= tempLeft.val) return false;
        if (tempRight != null && root.val >= tempRight.val) return false;

        return isValid(root.left) && isValid(root.right);
    }
}
