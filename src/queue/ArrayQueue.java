package queue;
/**
 * Created by dengshaoxiang on 2019/12/30 11:19
 * description: 基于数组实现的队列,普通队列,每次添加时,通过元素的移动,将所有
 * 的元素都放在数组的前面部分,以达到循环队列的效果
 */
public class ArrayQueue<E> {
    private int max;
    private Object[] queue;
    private int size;

    private int front = 0;
    private int rear = 0;
    public ArrayQueue(){
        this.max = 10;
        this.queue = new Object[max];
    }

    public ArrayQueue(int initSize){
        this.max = initSize;
        this.queue = new Object[max];
    }

    public int size(){
        return this.size;
    }

    public boolean add(E element){
        return this.offer(element);
    }
    public boolean offer(E element){
        ensureCapacity();
        queue[rear++] = element;
        size++;
        return true;
    }

    public E peek(){

        if (this.isEmpty()){
            throw  new  RuntimeException("队列为空");
        }

        return (E)queue[front];
    }

    public E poll(){

        if (this.isEmpty()){
            throw  new  RuntimeException("队列为空");
        }
        E value = (E)queue[front++];
        size--;
        return value;
    }

    private void ensureCapacity(){

        if (isEmpty()){
            this.rear = 0;
            this.front = 0;
        }
        if (rear-front == max){
            throw new RuntimeException("队列已经满");
        }
        if (!isEmpty()){
            if (front != 0){
                 System.arraycopy(queue,front,queue,0,rear-front);
                // System.arraycopy can be replaced with the for loop
                //for(int i = front;i<rear; i++){
                  //  queue[i-front] = queue[i]; // move all element to the front of the array
                //}
                this.rear=rear-front;
                this.front=0;
            }
        }
    }
    private boolean isEmpty(){
        return front == rear;
    }

}
