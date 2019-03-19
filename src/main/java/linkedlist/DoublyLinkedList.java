package linkedlist;

public class DoublyLinkedList {
    private Node nil = new Node(0);
    private int size = 0;
    private Node head;

    public static class Node {
        int data;  //关键字
        Node prev; //头指针，指向前驱元素
        Node next; //尾指针，指向后继元素

        public Node(int data) {
            this.data = data;
        }
    }

    public DoublyLinkedList() {
        //初始化一个空的链表，由一个哨兵组成！
        nil.next = null;
        nil.prev = null;
    }

    /**
     * 从链表的头部插入
     *
     * @param data
     */
    public void insert(int data) {
        Node node = new Node(data);
        if (head == null) {
            head = node;
            head.prev = nil;
            nil.next = head;
            size += 1;
        } else {
            node.next = nil.next;
            nil.next.prev = node;
            nil.next = node;
            node.prev = nil;
            size += 1;
            head = nil.next;
        }
    }

    /**
     * 从链表的头部删除
     */
    public void delete() {
        if (head == null)
            return;
        head.prev.next = head.next;
        head.next.prev = head.prev;
        size -= 1;
        head = nil.next;
    }

    /**
     * 从头到尾遍历链表
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
        int[] nums = {1, 2, 3, 4, 5};
        DoublyLinkedList linkedList = new DoublyLinkedList();
        for (int i : nums) {
            linkedList.insert(i);
        }
        System.out.println("size: "+linkedList.size);
        linkedList.printList();
        linkedList.delete();
        System.out.println("size: "+linkedList.size);
        linkedList.printList();
        linkedList.delete();
        System.out.println("size: "+linkedList.size);
        linkedList.printList();
        linkedList.delete();
        System.out.println("size: "+linkedList.size);
        linkedList.printList();
        linkedList.delete();
        System.out.println("size: "+linkedList.size);
        linkedList.printList();
    }
}
