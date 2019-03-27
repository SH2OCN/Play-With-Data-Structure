package bobo;
/*
队列的接口
 */
public interface Queue<E> {

    void enqueue(E e);  //入队
    E dequeue();        //出队
    E getFront();       //获取队首元素
    int getSize();      //队列元素个数
    boolean isEmpty();  //判空

}
