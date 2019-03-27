package bobo;
/*
栈的接口
 */
public interface Stack<E> {
    void push(E e); //入栈
    E pop();        //出栈
    E peek();       //看栈顶元素
    int getSize();  //元素个数
    boolean isEmpty(); //判空
}
