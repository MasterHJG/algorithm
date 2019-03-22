package stackandqueue;

import java.util.LinkedList;
import java.util.Queue;

public class TwoStacksFormAnArray {
    private int[] array;
    private int top1, top2;  //两个栈的栈顶
    private int capacity;

    public TwoStacksFormAnArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
        this.top1 = -1;
        this.top2 = capacity;
    }

    public boolean stackEmpty1() {
        if (top1 == -1)
            return true;
        else
            return false;
    }

    public boolean stackEmpty2() {
        if (top2 == capacity)
            return true;
        else
            return false;
    }

    public int pop1() throws Exception {
        if (stackEmpty1())
            throw new Exception("栈1为空!");
        else {
            int value = array[top1];
            top1 -= 1;
            return value;
        }
    }

    public int pop2() throws Exception {
        if (stackEmpty2())
            throw new Exception("栈2为空!");
        else {
            int value = array[top2];
            top2 += 1;
            return value;  //索引变化
        }
    }

    public void push1(int x) throws Exception {
        if (top1 == top2 - 1)
            throw new Exception("发生上溢！");
        else {
            top1 += 1;
            array[top1] = x;
        }
    }

    public void push2(int x) throws Exception {
        if (top1 == top2 - 1)
            throw new Exception("发生上溢!");
        else {
            top2 -= 1;
            array[top2] = x;
        }
    }

    public int peek1() throws Exception {
        if (stackEmpty1())
            throw new Exception("栈1为空!");
        else {
            return array[top1];
        }
    }

    public int peek2() throws Exception {
        if (stackEmpty2())
            throw new Exception("栈2为空!");
        else {
            return array[top2];
        }
    }

    public static void main(String[] args) {
        TwoStacksFormAnArray t = new TwoStacksFormAnArray(5);
        try {
            t.push1(1);
            t.push1(2);
            t.push2(3);
            t.push2(4);
            t.push2(5);
            System.out.println(t.peek1());
            System.out.println(t.peek2());
            //t.push1(6);
            System.out.println(t.pop1());
            System.out.println(t.pop1());
            System.out.println(t.stackEmpty1());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
