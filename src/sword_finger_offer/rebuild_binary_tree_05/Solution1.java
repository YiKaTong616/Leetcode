package sword_finger_offer.rebuild_binary_tree_05;

import help.TreeNode;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * <p>
 *  
 * <p>
 * 例如，给出
 * <p>
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * / \
 * 15  7
 */
public class Solution1
{
    public TreeNode buildTree(int[] preorder, int[] inorder)
    {
        if (preorder.length != inorder.length) return null;

        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int start1, int end1, int[] inorder, int start2, int end2)
    {
        if (start1 > end1)
            return null;
        if (start1 == end1)
            return new TreeNode(preorder[start1]);

        TreeNode root = new TreeNode(preorder[start1]);
        int index = findIndex(inorder, start2, end2, preorder[start1]);

        int leftStart1 = start1 + 1;
        int leftEnd1 = leftStart1 + (index - start2 - 1);
        int leftStart2 = start2;
        int leftEnd2 = index - 1;

        int rightStart1 = leftEnd1 + 1;
        int rightEnd1 = end1;
        int rightStart2 = index + 1;
        int rightEnd2 = end2;

        root.left = build(preorder, leftStart1, leftEnd1, inorder, leftStart2, leftEnd2);
        root.right = build(preorder, rightStart1, rightEnd1, inorder, rightStart2, rightEnd2);

        return root;
    }

    public int findIndex(int[] nums, int start, int end, int target)
    {
        for (int i = start; i <= end; i++)
            if (nums[i] == target)
                return i;

        return -1;
    }
}

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了 32.39% 的用户
 * 内存消耗：38.3 MB, 在所有 Java 提交中击败了 83.84% 的用户
 */
