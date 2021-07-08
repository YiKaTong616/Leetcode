package sort_list_148;

import help.ListNode;

/**
 * 执行结果：28 / 28 个通过测试用例，超出时间限制
 */
public class Solution1
{
    public ListNode sortList(ListNode head)
    {
        ListNode curNode = head;

        while (curNode != null)
        {
            ListNode floatNode = curNode.next;
            while (floatNode != null)
            {
                if (floatNode.val < curNode.val)
                {
                    int temp = floatNode.val;
                    floatNode.val = curNode.val;
                    curNode.val = temp;
                }
                floatNode = floatNode.next;
            }
            curNode = curNode.next;
        }

        return head;
    }
}
