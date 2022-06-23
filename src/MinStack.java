import javax.xml.soap.Node;
import java.util.Collections;
import java.util.Stack;

class MinStack {
    Node head;

    public class Node {
        int val;
        Node next;
        int min;

        Node (int val, Node next, int min) {
            this.val = val;
            this.next = next;
            this.min = min;
        }
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, null, val);
        }
        else {
            head = new Node(val, head, Math.min(head.min, val));
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;

    }

    public int getMin() {
        return head.min;
    }
}
