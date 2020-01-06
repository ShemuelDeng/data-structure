package heap;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 大顶堆
 * 大顶堆要排序，所以存储的元素必须要能比较
 */
public class BigTopHeap<E extends Comparable<E>> {

    private E[] array; // 数组，用来存储数据

    private int maxSize; // 大顶堆的大小，

    private int size; // 当前堆中的元素的数量

    // 构造函数
    public BigTopHeap(int maxSize){
        this.maxSize = maxSize;
        array = (E[]) new Object[maxSize+1];
    }

    public boolean add(E element){
        checkBounds();
        array[++size] = element; // 添加元素
        heaplize();// 堆化
        return true;
    }

    /**
     * 堆化，
     */
    private void heaplize(){
        // 数组中最后一个元素的父节点的索引
        int sonIndex = size-1; // 最后一个节点的索引
        int parentIndex = sonIndex / 2;
        while( parentIndex != 0 ){
            // 父节点小于子节点 则交换
            if (array[parentIndex].compareTo(array[sonIndex])<0){
                swap(parentIndex,sonIndex);
                sonIndex = parentIndex;
                parentIndex = sonIndex/2;
            }
        }
    }

    /**
     * 数组交换元素
     * @param index1
     * @param index2
     */
    private void swap(int index1,int index2){
        E temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void checkBounds(){
        if (this.size >= this.maxSize) throw new RuntimeException("堆已满");
    }

    public int size(){
        return this.size;
    }


    public void showHeap(){
        for (E e : array) {
            System.out.print(e+"\t");
        }
    }
    public static void main(String[] args) {
        System.out.println(3/2);
    }

}
