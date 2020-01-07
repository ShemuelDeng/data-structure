package heap;

/**
 * 大顶堆
 * 大顶堆要排序，不带泛型，只能存储int
 */
public class TopHeap {

    private int[] array; // 数组，用来存储数据

    private int maxSize; // 大顶堆的大小，

    private int size; // 当前堆中的元素的数量

    // 构造函数
    public TopHeap(int maxSize){
        this.maxSize = maxSize;
        array = new int[maxSize+1];
    }

    public boolean add(int element){
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
        int sonIndex = size; // 最后一个节点的索引
        int parentIndex = sonIndex / 2;
        while( parentIndex != 0 ){
            // 父节点小于子节点 则交换
            if (array[parentIndex]<(array[sonIndex])){
                swap(parentIndex,sonIndex);
                sonIndex = parentIndex;
                parentIndex = sonIndex/2;
            }else {
                break;
            }
        }
    }

    /**
     * 数组交换元素
     * @param index1
     * @param index2
     */
    private void swap(int index1,int index2){
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private void checkBounds(){
        if (this.size-1 >= this.maxSize) throw new RuntimeException("堆已满");
    }

    public int size(){
        return this.size;
    }


    public void showHeap(){
        for (int e : array) {
            System.out.print(e+"\t");
        }
    }

}
