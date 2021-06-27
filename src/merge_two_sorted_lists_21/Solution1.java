package merge_two_sorted_lists_21;

import help.ListNode;

/**
 * 执行用时：1 ms, 在所有 Java 提交中击败了 28.02% 的用户
 * 内存消耗：37.9 MB, 在所有 Java 提交中击败了 41.70% 的用户
 */
public class Solution1
{
    public ListNode mergeTwoLists(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode res = new ListNode(0);
        ListNode curNode = res;
        while (l1 != null || l2 != null)
        {
            if (l1 == null || l2 == null)
            {
                if (l1 == null)
                    curNode.next = l2;
                else
                    curNode.next = l1;
                break;
            }

            ListNode temp = null;
            if (l1.val <= l2.val)
            {
                temp = new ListNode(l1.val);
                l1 = l1.next;
            } else
            {
                temp = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode.next = temp;
            curNode = temp;
        }

        return res.next;
    }
}
