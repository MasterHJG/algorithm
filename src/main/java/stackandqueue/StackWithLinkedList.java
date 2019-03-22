package stackandqueue;

public class StackWithLinkedList {
    public class Node {
        int data;  //关键字
        Node next; //尾指针，指向后继元素

        public Node(int data) {
            this.data = data;
        }
    }

    public Node top = null;
    public int size = 0;

    /**
     * 在头部插入
     *
     * @param data
     */
    public void push(int data) {
        Node node = new Node(data);
        node.next = top;
        top = node;
        size += 1;
    }

    public int pop() throws Exception {
        if (top == null) {
            throw new Exception("栈为空");
        }
        size -= 1;
        int data = top.data;
        top = top.next;
        return data;
    }

    /**
     * 获取栈的大小
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return top == null;
    }

    public int peek() throws Exception {
        if (top == null) {
            throw new Exception("栈为空");
        }
        return top.data;
    }

    public static void main(String[] args) throws Exception {
        StackWithLinkedList stack = new StackWithLinkedList();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
