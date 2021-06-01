package sword_finger_offer.print_binary_tree_from_top_to_bottom_32;

import help.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * <p>
 *  
 * <p>
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回：
 * <p>
 * [3,9,20,15,7]
 *  
 * <p>
 * 提示：
 * <p>
 * 节点总数 <= 1000
 */
public class Solution1
{
    public int[] levelOrder(TreeNode root)
    {
        if (root == null) return new int[0];

        List<Integer> resList = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty())
        {
            TreeNode temp = queue.poll();
            resList.add(temp.val);

            if (temp.left != null) queue.offer(temp.left);
            if (temp.right != null) queue.offer(temp.right);
        }

        return resList.stream().mapToInt(Integer::intValue).toArray();
    }
}

/**
 * 执行用时：5 ms, 在所有 Java 提交中击败了 9.16% 的用户
 * 内存消耗：38.4 MB, 在所有 Java 提交中击败了 83.54% 的用户
 */
