package bobo;
/*
循环队列的底层实现（不使用动态数组）
 */
public class LoopQueue<E> implements Queue<E> {

    private E[] data;
    private int front, tail;
    private int size;

    public LoopQueue(int capacity) {
        data = (E[]) new Object[capacity + 1];
    }
    public LoopQueue() {
        this(10);
    }

    //扩容
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front+i) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override //入队
    public void enqueue(E e) {
        if((tail+1) % data.length == front)
            resize(2 * getCapacity());
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    @Override  //出队
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Dequeue failed. Empty queue.");
        E res = data[front];
        data[front] = null; //loitering element
        front = (front + 1) % data.length;
        size--;
        if(size == getCapacity() / 4 && getCapacity() / 2 != 0)
            resize(getCapacity() / 2);
        return res;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return data.length - 1;
    }
    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("LoopQueue: size = %d, capacity = %d\n",getSize(),getCapacity()));
        res.append("front [");
        for (int i = front; i != tail; i = (i+1) % data.length) {
            res.append(data[i]);
            if((i+1) % data.length != tail)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
