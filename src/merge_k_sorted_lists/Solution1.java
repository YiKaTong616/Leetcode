package merge_k_sorted_lists;

import help.ListNode;

/**
 * 执行用时: 367 ms, 在所有 Java 提交中击败了 5.01% 的用户
 * 内存消耗：40 MB, 在所有 Java 提交中击败了 81.14% 的用户
 */
public class Solution1
{
    public ListNode mergeKLists(ListNode[] lists)
    {
        ListNode res = getMin(lists);
        if (res == null)
            return res;

        ListNode node = res;
        while (true)
        {
            ListNode temp = getMin(lists);
            if (temp == null)
                break;

            node.next = temp;
            node = temp;
        }
        return res;
    }

    public static ListNode getMin(ListNode[] lists)
    {
        int minPos = -1;
        for (int i = 0; i < lists.length; i++)
            if (lists[i] != null && (minPos == -1 || lists[i].val < lists[minPos].val))
                minPos = i;
        if (minPos != -1)
        {
            int val = lists[minPos].val;
            lists[minPos] = lists[minPos].next;
            return new ListNode(val);
        } else
            return null;
    }
}
