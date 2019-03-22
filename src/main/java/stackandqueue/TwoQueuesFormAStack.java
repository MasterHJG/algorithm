package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoQueuesFormAStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public TwoQueuesFormAStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int x) {
        q1.offer(x);
    }

    public int pop() {
        int value = 0;
        if (q1.isEmpty()) {
            while (q2.size() > 1) {
                q1.offer(q2.poll());
            }
            value = q2.poll();
        } else if (q2.isEmpty()) {
            while (q1.size() > 1) {
                q2.offer(q1.poll());
            }
            value = q1.poll();
        }
        return value;
    }

    public static void main(String[] args) {
        TwoQueuesFormAStack stack = new TwoQueuesFormAStack();
        stack.push(1);
        stack.push(2);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
