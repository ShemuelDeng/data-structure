package sort;

public class SelectionSort implements Sort {

    /**
     * 选择排序
     * 首先在未排序序列中找到最小（大）元素，跟排序序列的起始位置交换，然后，再从剩余未排序元素中继续寻找最小（大）元素，
     * 然后放到已排序序列的末尾。以此类推，直到所有元素均排序完毕。
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0 )
            return array;
        int length = array.length;
        for (int i = 0; i <length ; i++) {
            int minIndex = i;
            for (int j = i ;j<length;j++){
                if (array[j]<array[minIndex]){ // 两两比较，找到最大的索引
                    minIndex = j;
                }
            }
            // 循环完成后，索引记录的是最大元素的索引，然后跟元素序列的起始元素交换
            int temp = array[minIndex];
            array[minIndex]= array[i];
            array[i]= temp;
        }
        return array;
    }
}
