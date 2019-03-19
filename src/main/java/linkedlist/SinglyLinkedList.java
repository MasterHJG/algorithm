package linkedlist;

/**
 * 单向链表
 */
public class SinglyLinkedList {
    private Node nil = new Node(0); //辅助头节点nil
    private Node head; //头节点
    private int size = 0; //链表长度

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * 初始化单链表
     * 头插法
     * 顺序相反
     *
     * @param nums
     * @return
     */
    public boolean initWithHead(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            size++;
            node.next = nil.next;
            nil.next = node;
        }
        head = nil.next;
        return true;
    }

    /**
     * 初始化单链表
     * 尾差法
     *
     * @param nums
     * @return
     */
    public boolean initWithTail(int[] nums) {
        if (nums == null || nums.length == 0)
            return false;
        Node temp = nil;
        for (int i = 0; i < nums.length; i++) {
            Node node = new Node(nums[i]);
            size++;
            temp.next = node;
            temp = node;
        }
        head = nil.next;
        return true;
    }

    /**
     * 在指定位置插入元素
     *
     * @param data
     * @param index 从0开始计算
     * @return
     */
    public boolean insert(int data, int index) {
        if (index < 0 || index > size)
            return false;
        Node temp = nil;
        while (index-- > 0) {
            temp = temp.next;
        }
        Node node = new Node(data);
        node.next = temp.next;
        temp.next = node;
        size++;
        head = nil.next;
        return true;
    }

    /**
     * 删除指定位置的节点
     *
     * @param index 从0开始计算
     * @return
     */
    public boolean delete(int index) {
        if (index < 0 || index >= size)
            return false;
        Node temp = nil;
        while (index-- > 0) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
        head = nil.next;
        return true;
    }

    /**
     * 反转单链表
     * 若链表nil->1->2->null
     * 1. prev=null,cur=1:null<-1
     * 2. prev=1,cur=2:null<-1<-2
     * null<-1<-2<-nil
     */
    public void reverse() {
        Node cur = head;
        Node prev = null;
        while (cur != null) {
            Node next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        nil.next = prev;
        head = nil.next;
    }

    /**
     * 判断单链表是否有环路
     * 算法思想：
     * 设定两个快慢指针slow和fast
     * 其中slow每次向前一步，fast每次向前两步
     * 那么，如果链表存在环，则slow和fast相遇，相当于fast已经超越slow一圈
     * 若链表没有环，则fast最先到达链表末尾
     *
     * @param head
     * @return
     */
    public boolean hasCircle(Node head) {
        if (head == null)
            return false;
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }

    /**
     * 环的长度
     *
     * @param head
     * @return
     */
    public int circleLen(Node head) {
        if (!hasCircle(head))
            return 0;
        Node slow = head;
        Node fast = head;
        Node pos = null;
        //一定有环
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                pos = slow;
                break;
            }
        }
        int sLen = 0;
        int fLen = 0;
        slow = pos;
        fast = pos;
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            sLen += 1;
            fLen += 2;
            if (slow == fast) {
                break;
            }
        }
        return fLen - sLen;
    }

    /**
     * 求环连接点的位置
     *
     * @param head
     * @return
     */
    public Node intersectionPoint(Node head) {
        if (!hasCircle(head))
            return null;
        Node slow = head;
        Node fast = head;
        Node pos = null;
        //一定有环
        while (true) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                pos = slow;
                break;
            }
        }
        Node pHead = head;
        while (pHead != pos) {
            pHead = pHead.next;
            pos = pos.next;
        }
        return pHead;
    }

    /**
     * 返回有环链表的头节点
     * 1->2->3->4->5->6->3
     *
     * @return
     */
    public Node buildCircleList() {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        return node1;
    }

    /**
     * 从头到尾遍历单链表
     */
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        int[] nums = {1, 2, 3, 4, 5};
        list.initWithTail(nums);
        list.printList();
        System.out.println("链表的长度为：" + list.size);
        list.insert(6, 0);
        list.printList();
        System.out.println("链表的长度为：" + list.size);
        list.delete(5);
        list.printList();
        System.out.println("链表的长度为：" + list.size);
        list.reverse();
        list.printList();

        System.out.println("是否有环：" + list.hasCircle(list.head));
        System.out.println("是否有环：" + list.hasCircle(list.buildCircleList()));

        System.out.println("环的长度：" + list.circleLen(list.buildCircleList()));
        System.out.println("环的连接点位置：" + list.intersectionPoint(list.buildCircleList()).data);
    }
}
