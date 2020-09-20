import java.io.*;
import java.util.*;

class ListedNode {
    int data;
    ListedNode next;

    ListedNode(int d) {
        data = d;
        next = null;
    }

}

class Link {

    static ListedNode pre = new ListedNode(0);
    static ListedNode res = pre;
    static HashSet<Integer> values = new HashSet<>();

    public static ListedNode removeDuplicates(ListedNode head) {
        buildUniq(head);
        return res.next;
    }

    public static void buildUniq(ListedNode head) {
        if (head == null) return;
        if (! values.contains(head.data)) {
            values.add(head.data);
            pre.next = new ListedNode(head.data);
            pre = pre.next;
        }
        buildUniq(head.next);
    }

    public static ListedNode insert(ListedNode head, int data) {
        ListedNode p = new ListedNode(data);
        if (head == null)
            head = p;
        else if (head.next == null)
            head.next = p;
        else {
            ListedNode start = head;
            while (start.next != null)
                start = start.next;
            start.next = p;

        }
        return head;
    }

    public static void display(ListedNode head) {
        ListedNode start = head;
        while (start != null) {
            System.out.print(start.data + " ");
            start = start.next;
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        ListedNode head = null;
        int T = sc.nextInt();
        while (T-- > 0) {
            int ele = sc.nextInt();
            head = insert(head, ele);
        }
        head = removeDuplicates(head);
        display(head);

    }
}
