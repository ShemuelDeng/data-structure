package queue;

import link.DoubleLink;

import java.util.NoSuchElementException;

/**
 * Created by dengshaoxiang on 2020/1/7 14:59
 * description: 基于链表实现的队列, 使用链表尾部插入 头部删除 ,
 * 可以很简单的实现队列
 */
public class LinkQueue<E> {
    private int max; // the max capacity of the queue
    private int size; // the size of the queue
    private DoubleLink<E> nodes = new DoubleLink<>(); // to store the element


    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public LinkQueue(int max){
        this.max = max;
    }

    public LinkQueue(){
        this.max = 10; // default capacity
    }

    public boolean add(E element){
        return this.offer(element);
    }

    public boolean offer(E element) {
        if (size == max) throw new RuntimeException("队列已满");
        nodes.add(element);
        size++;
        return true;
    }

    // get out of the queue
    public E poll(){
        if (size == 0 ) throw new NoSuchElementException();
        E value = nodes.get(0);
        nodes.remove(value);
        size--;
        return value;
    }

    // just get a peek of the head element of the queue
    public E peek(){
        if (size == 0 ) throw new NoSuchElementException();

        return nodes.get(0);
    }
}
