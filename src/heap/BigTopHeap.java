package heap;

/**
 * 大顶堆
 * 大顶堆要排序，所以存储的元素必须要能比较
 */
public class BigTopHeap<E extends Comparable<E>> {

    private Object[] array; // 数组，用来存储数据

    private int maxSize; // 大顶堆的大小，

    private int size; // 当前堆中的元素的数量

    // 构造函数
    public BigTopHeap(int maxSize){
        this.maxSize = maxSize;
        array = new Object[maxSize];
    }

    public boolean add(E element){
        checkBounds();
        int index = size;
        if (size == 0){
            array[0] = element;
        }else{
            bigUp(index,element);
        }
        size++;
        return true;
    }

    /**
     * @description: 大元素上移动
     * @param index
     * @param element
     * @date: 2020/1/7 14:37
     * @author: dengshaoxiang
     */
    private void bigUp(int index,E element){
        while (index > 0){
            int parentIndex = (index-1) >>> 1;
            Comparable<? super E> parent = (Comparable<? super E>)array[parentIndex];
            if (parent.compareTo(element) < 0){
                array[index] = parent;
                index = parentIndex;
            }else{
                break;
            }
        }
        // 程序走到这,index 要么是父节点索引,要么是最后一个节点的索引
        // 如果是父节点的索引,则说明父节点比较小,需要将新加的大的元素放入父节点
        // 如果是随后一个元素的索引 说明是直接break到这里的 ,最后一个元素较小,直接插入
        array[index] = element;
    }

    private void checkBounds(){
        if (this.size-1 >= this.maxSize) throw new RuntimeException("堆已满");
    }

    public int size(){
        return this.size;
    }


    public void showHeap(){
        for (Object e : array) {
            if (e != null) System.out.print(e+"\t");
        }
    }

}
