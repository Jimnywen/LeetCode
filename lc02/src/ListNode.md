```java

public class Main {
    public static ListNode arrayToListNode(Integer[] head) {
        ListNode node = new ListNode(-1);
        ListNode curr = node;

        for (Integer integer : head) {
            curr.next = new ListNode(integer);
            curr = curr.next;
        }
        return node.next;
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
```