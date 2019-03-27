package bobo;
/*
动态数组实现队列
 */
public class ArrayQueue<E> implements Queue<E> {

    private Array<E> arr;

    public ArrayQueue(int capacity) {
        arr = new Array<>(capacity);
    }
    public ArrayQueue() {
        arr = new Array<>();
    }

    @Override
    public void enqueue(E e) {
        arr.addLast(e);
    }

    @Override
    public E dequeue() {
        return arr.removeFirst();
    }

    @Override
    public E getFront() {
        return arr.getFirst();
    }

    @Override
    public int getSize() {
        return arr.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arr.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d, capacity = %d\n",arr.getSize(),arr.getCapacity()));
        res.append("front [");
        for (int i = 0; i < arr.getSize(); i++) {
            res.append(arr.get(i));
            if(i != arr.getSize() - 1)
                res.append(", ");
        }
        res.append("] tail");
        return res.toString();
    }
}
