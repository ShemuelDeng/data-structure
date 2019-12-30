package stack;

import java.util.EmptyStackException;

/**
 * Created by dengshaoxiang on 2019/12/30 11:19
 * description: 基于数组实现的栈
 */
public class ArrayStack<E> {

    private int max = 10;
    private Object[] stack ;
    private int top = -1;

    public E pop(){
        if (top != -1){
            E element = (E)stack[top];
            stack[top] = null;
            top--;
            return element;
        }
        throw new EmptyStackException();
    }

    public ArrayStack(){
        stack = new Object[max];
    }
    public ArrayStack(int initSize){
        this.max = initSize;
        stack = new Object[max];
    }

    public boolean empty(){
        return top == -1;
    }

    public E peek(){
        if (top != -1){
            return (E)stack[top];
        }
        throw new EmptyStackException();
    }

    public E push(E element){
        if (top == max-1){
            throw new RuntimeException("栈满了..");
        }
        stack[top+1] = element;
        top++;
        return element;
    }
}
