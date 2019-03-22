package stackandqueue;

public class StackWithArray {
    private int[] array;  //数组实现
    private int top = -1;  //初始化，栈空
    private int capacity; //栈的大小

    public StackWithArray(int capacity) {
        this.capacity = capacity;
        this.array = new int[capacity];
    }

    /**
     * 入栈
     *
     * @param value
     * @throws Exception
     */
    public void push(int value) throws Exception {
        if (top == capacity - 1) {
            throw new Exception("栈已满");
        }
        top++;
        array[top] = value;
    }

    /**
     * 出栈
     *
     * @return
     * @throws Exception
     */
    public int pop() throws Exception {
        if (top == -1) {
            throw new Exception("栈为空");
        }
        int value = array[top];
        top--;
        return value;
    }

    /**
     * 判断栈是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 获取栈顶元素
     *
     * @return
     * @throws Exception
     */
    public int peek() throws Exception {
        if (top == -1) {
            throw new Exception("栈为空");
        }
        return array[top];
    }

    public static void main(String[] args) throws Exception {
        StackWithArray stack = new StackWithArray(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        System.out.println(stack.isEmpty());
    }
}
