package reverse_linked_list;

import help.ListNode;

/**
 * 执行用时：0 ms, 在所有 Java 提交中击败了 100.00% 的用户
 * 内存消耗：38.2 MB, 在所有 Java 提交中击败了 62.33% 的用户
 */

public class Solution1
{
    public ListNode reverseList(ListNode head)
    {
        if (head == null || head.next == null) return head;

        ListNode res = null;
        while (head != null)
        {
            ListNode temp = head.next;
            head.next = res;
            res = head;
            head = temp;
        }
        return res;
    }
}
