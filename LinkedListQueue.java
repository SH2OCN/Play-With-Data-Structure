/*
借鉴链表思想 实现队列
 */
public class LinkedListQueue<E> implements Queue<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
        public Node(E e) {this(e,null);}
        public Node() {this(null,null);}
        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head, tail;  //头部作为队尾：插入元素，尾部作为队首：删除元素
    private int size;

    public LinkedListQueue() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void enqueue(E e) {
        if(isEmpty()) {
            tail = new Node(e);
            head = tail;
        }
        else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Dequeue failed. Empty queue.");
        Node remNode = head;
        head = head.next;
        remNode.next = null;
        if(head == null)
            tail = null;
        size--;
        return remNode.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Dequeue failed. Empty queue.");
        return head.e;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Queue: front[");
        Node cur = head;
        while(cur != null) {
            res.append(cur);
            if(cur.next != null)
                res.append(" ");
            cur = cur.next;
        }
        res.append("] tail");
        return res.toString();
    }
}
