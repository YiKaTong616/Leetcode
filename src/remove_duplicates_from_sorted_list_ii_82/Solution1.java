package remove_duplicates_from_sorted_list_ii_82;

import help.ListNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：37.7 MB, 在所有 Java 提交中击败了 82.24% 的用户
 */
public class Solution1
{
    public ListNode deleteDuplicates(ListNode head)
    {
        if (head == null || head.next == null)
            return head;

        ListNode res = new ListNode(-1, head);
        ListNode temp = res;
        ListNode cursor = head;

        while (cursor != null)
        {
            if (cursor.next == null) break;

            if (cursor.val != cursor.next.val)
            {
                temp = cursor;
                cursor = cursor.next;
            } else
            {
                int v = cursor.val;
                while (cursor != null && cursor.val == v)
                    cursor = cursor.next;
                temp.next = cursor;
            }
        }

        return res.next;
    }
}
