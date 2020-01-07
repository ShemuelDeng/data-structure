package stack;

import link.SingleLink;

import java.util.NoSuchElementException;

/**
 * Created by dengshaoxiang on 2020/1/7 14:59
 * description: 基于链表实现的栈,使用队列尾插法,尾部删除的特点
 * 可以轻松的实现栈
 */
public class LinkStack<E> {
    private final SingleLink<E> nodes  = new SingleLink<>();
    private int max; // the max capacity of the stack
    private int size;
    public LinkStack(int max){
        this.max = max;
    }
    public LinkStack(){
        this.max = 10;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * @description: 压栈
     * @param item
     * @date: 2020/1/7 15:08
     * @author: dengshaoxiang
     */
    public boolean push(E item){
        if (this.size == max) throw new RuntimeException("栈已满");
        nodes.add(item);
        size++;
        return true;
    }

    /**
     * @description: 出栈
     * @param
     * @date: 2020/1/7 15:07
     * @author: dengshaoxiang
     */
    public E pop(){
        if (isEmpty()) throw new NoSuchElementException();
        E value = nodes.get(size-1);
        nodes.remove(value);
        size--;
        return value;
    }

    /**
     * @description: 查看栈顶元素
     * @param
     * @date: 2020/1/7 15:07
     * @author: dengshaoxiang
     */
    public E peek(){
        if (isEmpty()) throw new NoSuchElementException();
        return nodes.get(size-1);
    }
}
