package stackandqueue;

import java.util.Stack;

public class TwoStacksFormAQueue {

    /**
     * 入队时，将元素压入s1。
     * 出队时，判断s2是否为空，如不为空，则直接弹出顶元素；
     * 如为空，则将s1的元素逐个“倒入”s2，把最后一个元素弹出并出队。
     */

    private Stack<Integer> s1;  //用来入栈，相当于队列的队尾
    private Stack<Integer> s2;  //用来出栈，相当于队列的队头

    public TwoStacksFormAQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void addToTail(int x) throws Exception {
        s1.push(x);
    }

    public int deleteFromHead() throws Exception {
        if (s2.isEmpty() == true) {
            System.out.println("栈s2为空");
            stack1ToStack2();
        }
        return s2.pop();
    }

    public void stack1ToStack2() throws Exception {
        while (s1.isEmpty() == false) {
            s2.push(s1.pop());
        }
    }

    public static void main(String[] args) {
        TwoStacksFormAQueue queue = new TwoStacksFormAQueue();
        try {
            //queue.deleteFromHead(); //empty stack
            queue.addToTail(1);
            queue.addToTail(2);
            queue.addToTail(3);
            System.out.println(queue.deleteFromHead());
            System.out.println(queue.deleteFromHead());
            queue.addToTail(4);
            queue.addToTail(5);
            System.out.println(queue.deleteFromHead());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
