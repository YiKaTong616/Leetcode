package swap_nodes_in_pairs_24;

import help.ListNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.1 MB, 在所有 Java 提交中击败了 28.83% 的用户
 */
public class Solution1
{
    public ListNode swapPairs(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode second = head.next;

        while (second != null)
        {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;

            first = first.next != null ? first.next.next : null;
            second = second.next != null ? second.next.next : null;
        }

        return head;
    }
}
