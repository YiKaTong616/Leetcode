package binary_tree_level_order_traversal_102;

import help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 94.95% 的用户
 * 内存消耗：38.6 MB, 在所有 Java 提交中击败了 53.74% 的用户
 */
public class Solution1
{
    public static List<List<Integer>> levelOrder(TreeNode root)
    {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        Queue<TreeNode> curQueue = new LinkedList<>();
        Queue<TreeNode> nxtQueue = new LinkedList<>();
        curQueue.add(root);

        List<Integer> temp = new ArrayList<>();
        while (!curQueue.isEmpty())
        {
            TreeNode topNode = curQueue.poll();
            if (topNode.left != null) nxtQueue.add(topNode.left);
            if (topNode.right != null) nxtQueue.add(topNode.right);
            temp.add(topNode.val);
            if (curQueue.isEmpty())
            {
                Queue<TreeNode> tempQueue = curQueue;
                curQueue = nxtQueue;
                nxtQueue = tempQueue;
                res.add(temp);
                temp = new ArrayList<>();
            }
        }

        return res;
    }

    public static void main(String[] args)
    {
        System.out.println(levelOrder(TreeNode.stringToTreeNode("[3,9,20,null,null,15,7]")));
    }
}
