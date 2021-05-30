package remove_nth_node_from_end_of_list;

import help.ListNode;

/**
 * 执行用时: 0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗: 36.4 MB, 在所有 Java 提交中击败了 69.67% 的用户
 */

public class Solution
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
            return null;

        ListNode before = head;
        ListNode after = head;
        for (int i = 0; i < n - 1; i++)
            after = after.next;

        ListNode temp = null;
        while (after.next != null)
        {
            temp = before;
            before = before.next;
            after = after.next;
        }

        if (temp != null)
            temp.next = before.next;
        else
            head = head.next;

        return head;
    }
}
