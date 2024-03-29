/*
实现链表-有虚拟头结点
 */
public class LinkedList<E> {

    //节点作为链表的内部类
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
        public String toString() {return e.toString();}
    }

    private Node dummyHead; //虚拟头结点
    private int size;

    //构造函数
    public LinkedList() {
        dummyHead = new Node();  // 空链表也要有一个虚拟头结点
        size = 0;
    }
    //获取链表中元素个数
    public int getSize() {
        return size;
    }
    //判空
    public boolean isEmpty() {
        return size == 0;
    }
    //在index处插入元素
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }
    //在链表头插入元素
    public void addFirst(E e) {
        add(0,e);
    }
    //在链表尾插入元素
    public void addLast(E e) {
        add(size,e);
    }
    //从链表中删除index位置的元素
    public E remove(int index) {
        if(index < 0 ||index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node retNode = prev.next;
        prev.next = retNode.next;
        retNode.next = null;      // 便于Java回收这个内存
        size--;
        return retNode.e;
    }
    //删除表头元素
    public E removeFirst() {
        return remove(0);
    }
    //删除表尾元素
    public E removeLast() {
        return remove(size-1);
    }
    //删除链表中所有e元素
    public void removeAllElements(E e) {
        Node prev = dummyHead;
        while(prev.next != null) {
            if(prev.next.e.equals(e))
                prev.next = prev.next.next;
            else
                prev = prev.next;
        }
    }
    //获得index位置的元素
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Get failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    //获取链表第一个元素
    public E getFirst() {
        return get(0);
    }
    //获取链表最后一个元素
    public E getLast() {
        return get(size-1);
    }
    //修改index位置的元素
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }
    //查询链表中是否有元素e
    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while(cur != null) {
            if(cur.e.equals(e))
                return true;
            cur = cur.next;
        }
        return false;
    }
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node cur = dummyHead.next;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }

}
