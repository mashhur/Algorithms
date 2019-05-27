package Leetcode;

import java.util.Arrays;

public class AddTwoNumbers {

    public static void main(String args[]) {
        int[] array = {1, 2, 3};
        System.out.println(Arrays.binarySearch(array, 0));

        char[] chArray = {'a', 'b', 'c'};
        System.out.println(Arrays.binarySearch(chArray, 'Z'));
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        int sum = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            dummy.next = new ListNode(sum % 10);
            dummy = dummy.next;
            sum /= 10;
        }

        if (sum == 1) {
            dummy.next = new ListNode(1);
        }
        return head.next;
    }
}


class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}