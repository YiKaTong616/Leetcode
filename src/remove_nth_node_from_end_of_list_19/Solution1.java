package remove_nth_node_from_end_of_list_19;

import help.ListNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：36.4 MB, 在所有 Java 提交中击败了 46.81% 的用户
 */
public class Solution1
{
    public ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null) return null;

        ListNode start, end = head;
        for (int i = 0; i < n - 1; i++)
        {
            end = end.next;
            if (end == null)
                return head;
        }
        start = head;

        ListNode pre = null;
        while (end.next != null)
        {
            end = end.next;
            pre = start;
            start = start.next;
        }

        if (pre == null) head = head.next;
        else pre.next = start.next;

        return head;
    }
}
