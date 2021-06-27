package linked_list_cycle_141;

import help.ListNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：39.6 MB, 在所有 Java 提交中击败了 41.60% 的用户
 */
public class Solution1
{
    public boolean hasCycle(ListNode head)
    {
        if (head == null || head.next == null)
            return false;

        ListNode slowPoint = head.next;
        ListNode fastPoint = head.next.next;

        while (slowPoint != null && fastPoint != null)
        {
            slowPoint = slowPoint.next;
            fastPoint = fastPoint.next != null ? fastPoint.next.next : null;

            if (slowPoint == fastPoint)
                return true;
        }

        return false;
    }
}
