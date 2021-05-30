package sword_finger_offer.print_linked_list_from_end_to_beginning_04;

import help.ListNode;

import java.util.ArrayList;

/**
 * 执行用时：2 ms, 在所有 Java 提交中击败了 38.35% 的用户
 * 内存消耗：39.2 MB, 在所有 Java 提交中击败了 32.22% 的用户
 */
public class Solution1
{
    public int[] reversePrint(ListNode head)
    {
        ArrayList<Integer> list = new ArrayList<>(10000);
        int length = 0;
        while (head != null)
        {
            length++;
            list.add(10000 - length, head.val);
            head = head.next;
        }

        return list.subList(10000 - length, 10000).stream().mapToInt(Integer::valueOf).toArray();
    }
}
