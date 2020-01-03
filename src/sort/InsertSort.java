package sort;

public class InsertSort implements Sort {


    /**
     * 插入排序插入排序（Insertion-Sort）的算法描述是一种简单直观的排序算法。它的工作原理是通过构建有序序列，
     * 对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。插入排序在实现上，
     * 通常采用in-place排序（即只需用到O(1)的额外空间的排序），
     * 因而在从后向前扫描过程中，需要反复把已排序元素逐步向后挪位，为最新元素提供插入空间
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0 )
            return array;
        for (int i=0;i<array.length-1;i++){
            // 默认第一个是已经排序好的，从第二个开始跟第一个比较
            int current = array[i+1];
            int preIndex = i; // 当前值的前一个，
            while (preIndex>=0 && current<array[preIndex]){ // 当前值小于前面的，则往后挪
                array[preIndex+1]=array[preIndex];
                preIndex--;
            }
            array[preIndex+1]=current;
        }
        return array;
    }
}
