/**
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *
 * 示例：
 *
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 *
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 *
 * 给定的 n 保证是有效的。
 *
 * 进阶：
 *
 * 你能尝试使用一趟扫描实现吗？
 */

import java.util.*;
class Solution {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }

        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }

        public String toPrint() {
            if (next == null) {
                return val + " ";
            }
            return val + " " + next.toPrint();
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 空链表直接返回空
        if (head == null) {
            return null;
        }
        // 初始化一个节点，next指针为链表的头
        ListNode initNode = new ListNode(0, head);;
        // 定义一个快慢指针
        ListNode slow = initNode;
        ListNode fast = initNode;
        // 记录走了多少步
        int count = 0;
        // 链表没走完之前一直循环，快的指针会先走n步，所以当快指针到达尾节点的时候，慢指针恰恰好落后n步
        while (fast.next != null) {
            fast = fast.next;
            if (count < n) {
                count++;
                continue;
            }
            slow = slow.next;
        }
        // 当前slow的next为要去除的指针，因为我们从链表前一个节点开始遍历的
        slow.next = slow.next.next;
        // 初始节点去除开头的0节点，返回
        initNode = initNode.next;
        return initNode;
    }

    public static void main(String[] args) {
        int[] ints = new int[] {1,2,3};
        ListNode head = ints.length > 0 ? new ListNode(ints[0]) : null;
        ListNode node = head;
        for (int i = 1; i < ints.length; i++) {
            node.next = new ListNode(ints[i]);
            node = node.next;
        }
        Solution solution = new Solution();
        ListNode res = solution.removeNthFromEnd(head, 3);
        if (res != null) {
            System.out.println(res.toPrint());
        } else {
            System.out.println("null");
        }
    }
}