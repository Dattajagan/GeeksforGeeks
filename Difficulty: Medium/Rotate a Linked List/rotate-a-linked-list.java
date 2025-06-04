class Solution {
    public Node rotate(Node head, int k) {
        if (head == null || head.next == null || k == 0) return head;

        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        k = k % length;
        if (k == 0) return head;

        Node curr = head;
        for (int i = 1; i < k; i++) {
            curr = curr.next;
        }

        Node newHead = curr.next;
        curr.next = null;
        tail.next = head;

        return newHead;
    }
}
