package bobo;
/*
动态数组实现栈
 */
public class ArrayStack<E> implements Stack<E> {
    private Array<E> arr;

    //构造函数
    public ArrayStack(int capacity) {
        arr = new Array<>(capacity);
    }
    public ArrayStack() {
        arr = new Array<>();
    }

    @Override
    public void push(E e) {
        arr.addLast(e);
    }

    @Override
    public E pop() {
        return arr.removeLast();
    }

    @Override
    public E peek() {
        return arr.getLast();
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
        res.append("Stack: [");
        for (int i = 0; i < arr.getSize(); i++) {
            res.append(arr.get(i));
            if(i != arr.getSize() - 1)
                res.append(", ");
        }
        res.append("] top");
        return res.toString();
    }

}
