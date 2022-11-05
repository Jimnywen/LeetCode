import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {

    // lc 1773
    public int countMatches(List<List<String>> items, String ruleKey, String ruleValue) {
        int index = 0;
        int ans = 0;
        switch (ruleKey) {
            case "type":
                break;
            case "color":
                index = 1;
                break;
            case "name":
                index = 2;
                break;

        }
        for (List<String> item : items) {
            if (Objects.equals(item.get(index), ruleValue)) ans++;
        }
        return ans;

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode();
        ListNode curr = head;

        int temp = 0;
        while (true) {
            int sum = l1.val + l2.val;
            curr.val = (sum + temp) % 10;
            temp = (sum + temp) / 10;
            l1 = l1.next;
            l2 = l2.next;

            if (l1 == null && l2 == null) {

                if (temp == 1) {
                    curr.next = new ListNode();
                    curr = curr.next;
                    curr.val = temp;
                }
                break;
            }

            if (l1 == null) {
                while (l2 != null) {
                    curr.next = new ListNode();
                    curr = curr.next;
                    curr.val = (l2.val + temp) % 10;
                    temp = (l2.val + temp) / 10;
                    l2 = l2.next;

                }
                if (temp == 1) {
                    curr.next = new ListNode(temp);
                }
                break;
            }
            if (l2 == null) {
                while (l1 != null) {
                    curr.next = new ListNode();
                    curr = curr.next;
                    curr.val = (l1.val + temp) % 10;
                    temp = (l1.val + temp) / 10;
                    l1 = l1.next;

                }
                if (temp == 1) {
                    curr.next = new ListNode(temp);
                }

                break;
            }

            curr.next = new ListNode();
            curr = curr.next;
        }
        return head;

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
//        ListNode l1 = arrayToListNode(new Integer[]{0, 0, 0, 1});
//        ListNode l2 = arrayToListNode(new Integer[]{1, 1});
//        new Main().addTwoNumbers(l1, l2);
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

