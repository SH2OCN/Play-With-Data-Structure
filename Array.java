package bobo;
/*
实现动态数组
 */
public class Array<E> {
    private E[] data;
    private int size;

    //构造函数
    public Array(int capacity){
        data = (E[])new Object[capacity];
        size = 0;
    }

    public Array() {
        this(10);
    }

    public int getSize() {
        return size;
    }
    public int getCapacity() {
        return data.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    //扩容&缩容
    private void resize(int newCapacity) {
        E[] newData = (E[])new Object[newCapacity];
        for(int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    //增
    public void add(int index, E e) {
        if(index < 0 || index > size)
            throw new IllegalArgumentException("Add failed. Illegal index.");
        if(size == data.length)
            resize(data.length * 2);
        for(int i = size-1; i >= index; i--) {
            data[i+1] = data[i];
        }
        data[index] = e;
        size ++;
    }
    public void addFirst(E e) {add(0,e);}
    public void addLast(E e) {add(size,e);}

    //删
    public E remove(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Remove failed. Illegal index.");
        E ret = data[index];
        for(int i = index+1; i < size; i++) {
            data[i-1] = data[i];
        }
        data[size-1] = null; //****loitering element
        size--;
        if(size == data.length / 4 && data.length / 2 != 0)
            resize(data.length / 2);
        return ret;
    }
    public E removeFirst() {return remove(0);}
    public E removeLast() {return remove(size-1);}

    //改
    public void set(int index, E e) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        data[index] = e;
    }

    //查
    public E get(int index) {
        if(index < 0 || index >= size)
            throw new IllegalArgumentException("Set failed. Illegal index.");
        return data[index];
    }
    public E getFirst() {return get(0);}
    public E getLast() {return get(size-1);}

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Array: size = %d, capacity = %d.\n",size,data.length));
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if(i != size - 1)
                res.append(", ");
        }
        res.append(']');
        return res.toString();
    }
}
