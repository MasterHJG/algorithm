package stackandqueue;

public class CircularQueue {
    private int head = 0, tail = 0;  //设置队列的头指针和尾指针
    private int maxSize;  //队列的空间大小
    private int[] array;  //数组结构

    public CircularQueue(int maxSize) {
        this.array = new int[maxSize];
        this.maxSize = maxSize;
    }

    public boolean queueEmpty() {
        if (head == tail)
            return true;
        else

            return false;
    }

    public boolean queueFull() {
        if ((tail + 1) % maxSize == head)
            return true;
        else
            return false;
    }

    public void enqueue(int x) throws Exception {
        if (queueFull())
            throw new Exception("队列已满！");
        else {
            array[tail] = x;
            if (tail == maxSize - 1)
                tail = 0;
            else
                tail += 1;
        }
    }

    public int dequeue() throws Exception {
        if (queueEmpty())
            throw new Exception("队列为空！");
        else {
            int value = array[head];
            if (head == maxSize - 1)
                head = 0;
            else
                head += 1;
            return value;
        }
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue(5);
        try {
            queue.enqueue(1);
            queue.enqueue(2);
            queue.enqueue(3);
            queue.enqueue(4);
            //queue.enqueue(5); //队列满
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            queue.enqueue(5);
            queue.enqueue(6);
            //queue.enqueue(7);
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            System.out.println(queue.dequeue());
            //System.out.println(queue.dequeue()); //队列空

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
