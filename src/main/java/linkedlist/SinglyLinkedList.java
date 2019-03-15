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
    }
}
