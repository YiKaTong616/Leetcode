package flatten_binary_tree_to_linked_list_114;

import help.TreeNode;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 45.55% 的用户
 * 内存消耗：37.8 MB, 在所有 Java 提交中击败了 77.08% 的用户
 */
public class Solution1
{
    public static void flatten(TreeNode root)
    {
        if (root == null)
            return;

        flat(root);
    }

    public static TreeNode flat(TreeNode treeNode)
    {
        if (treeNode.left == null && treeNode.right == null)
            return treeNode;
        else if (treeNode.left != null && treeNode.right == null)
        {
            TreeNode leftTail = flat(treeNode.left);
            treeNode.right = treeNode.left;
            treeNode.left = null;
            return leftTail;
        } else if (treeNode.left == null)
            return flat(treeNode.right);
        else
        {
            TreeNode leftTail = flat(treeNode.left);
            TreeNode rightTail = flat(treeNode.right);
            leftTail.right = treeNode.right;
            treeNode.right = treeNode.left;
            treeNode.left = null;
            return rightTail;
        }
    }

    public static void main(String[] args)
    {
        flatten(TreeNode.stringToTreeNode("[1,2,5,3,4,null,6]"));
    }
}
