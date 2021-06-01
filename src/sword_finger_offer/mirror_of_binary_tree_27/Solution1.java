package sword_finger_offer.mirror_of_binary_tree_27;

import help.TreeNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：35.8 MB, 在所有 Java 提交中击败了 46.78% 的用户
 */
public class Solution1
{
    public TreeNode mirrorTree(TreeNode root)
    {
        if (root == null) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorTree(root.left);
        mirrorTree(root.right);

        return root;
    }
}
