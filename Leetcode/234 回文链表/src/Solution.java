/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 *
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 *
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public boolean isPalindrome(ListNode head) {
        // 空或一个节点直接返回true
        if (head == null || head.next == null) {
            return true;
        }
        // 找到中间节点，这步可以用快慢指针， 慢指针走一步，快指针走两步，刚好慢指针为中间节点
        int size = 1;
        ListNode slow = head;
        while (slow.next != null) {
            size += 1;
            slow = slow.next;
        }
        int mid = size >> 1;
        ListNode fast = head;
        for(int i = 0; i < mid - 1; i++) {
            fast = fast.next;
        }
        // 中间节点的下一个节点为空
        ListNode firstNode = fast.next;
        // 保存下下个节点
        ListNode pNode = fast.next!= null ? fast.next.next: null;
        firstNode.next = null;
        // 从下下个节点开始，头插法插入到中间节点
        while (pNode != null) {
            ListNode qNode = pNode.next;
            pNode.next = fast.next;
            fast.next = pNode;
            pNode = qNode;
        }
        slow = head;
        while (slow != null) {
            System.out.println(slow.val);
            slow = slow.next;
        }
        // 两个节点遍历是否值为一致的
        slow = head;
        fast = fast.next;
        for (int i = 0; i < mid; i++) {
            System.out.println("第" + i + "次循环, slow的值: " + slow.val + " ,fast的值: " + fast.val);
            if (slow.val != fast.val) {
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] array = new int[] {1,2,3,2,1};
        ListNode listNode = new ListNode(array[0]);
        ListNode flagNode = listNode;
        for (int i = 1; i < array.length; i++) {
            flagNode.next = new ListNode(array[i]);
            flagNode = flagNode.next;
        }
        boolean res = solution.isPalindrome(listNode);
        System.out.println(res);
    }
}