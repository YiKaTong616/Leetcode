package binary_tree_upside_down;


import help.TreeNode;

public class Solution1
{
    public TreeNode upsideDownBinaryTree(TreeNode root)
    {
        if (root == null) return null;

        TreeNode curTree = root.left;
        TreeNode curRightNode = root.right;

        root.left = null;
        root.right = null;
        TreeNode upsideTree = root;

        while (curTree != null)
        {
            TreeNode tempLeft = curTree.left;
            TreeNode tempRight = curTree.right;

            curTree.left = curRightNode;
            curTree.right = upsideTree;
            upsideTree = curTree;

            curTree = tempLeft;
            curRightNode = tempRight;
        }
        return upsideTree;
    }
}
