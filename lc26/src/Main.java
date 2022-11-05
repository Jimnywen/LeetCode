import java.util.Arrays;

public class Main {
    // lc 26
    public int removeDuplicates(int[] nums) {
        int previousPosition = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue;
            } else {
                nums[previousPosition] = nums[i];
                previousPosition++;
            }
        }
        return previousPosition;
    }

    // lc 206
    public ListNode reverseList1(ListNode head) {
        ListNode node = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = node;
            node = curr;
            curr = next;
        }

        return node;

    }

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        // break the loop, exp. 4<->5
        head.next = null;

        // always return the new head
        return newHead;
    }

    // lc 283
    public void moveZeroes(int[] nums) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int previous = nums[index];
                nums[index] = nums[i];
                nums[i] = previous;
                index++;

            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static ListNode arrayToListNode(Integer[] head) {
        ListNode node = new ListNode(-1);
        ListNode curr = node;

        for (Integer integer : head) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
//        new Main().removeDuplicates(new int[]{0,0,1,1,1,2,2,3,3,4});

//        ListNode l1 = arrayToListNode(new Integer[]{1, 2, 3, 4, 5});
//        new Main().reverseList(l1);
        new Main().moveZeroes(new int[]{1});
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}