package add_two_numbers;

import help.ListNode;

/**
 * 解答成功:
 * 				执行耗时:2 ms,击败了99.92% 的Java用户
 * 				内存消耗:38.6 MB,击败了84.18% 的Java用户
 */

public class Solution1
{
    public static void main(String[] args)
    {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2)
    {
        if (l1 == null && l2 == null)
            return null;
        else if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;

        ListNode node1 = l1;
        ListNode node2 = l2;
        int carry = 0;

        ListNode headNode = new ListNode();
        ListNode currentNode = headNode;
        while (node1 != null || node2 != null || carry != 0)
        {
            int num1 = node1 != null ? node1.val : 0;
            int num2 = node2 != null ? node2.val : 0;

            ListNode tempNode = new ListNode((num1 + num2 + carry) % 10);
            carry = (num1 + num2 + carry) / 10;

            currentNode.next = tempNode;
            currentNode = currentNode.next;
            node1 = node1 != null ? node1.next : null;
            node2 = node2 != null ? node2.next : null;
        }

        return headNode.next;
    }
}
