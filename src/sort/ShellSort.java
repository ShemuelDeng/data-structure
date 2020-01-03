package sort;

public class ShellSort implements Sort {

    /**
     * 希尔排序，通过一个增量（常用希尔增量，即数组的长度的一半，并且每次缩小一半）进行分组，
     * 各个分组再进行插入排序
     * @param array
     * @return
     */
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0 )
            return array;
        int length = array.length;
        int gap = length/2;
        while (gap>0){
            for (int i = gap;i<length;i++){
                int current = array[i];
                int preIndex = i-gap; // 前一个的索引，
                while (preIndex>=0 && array[preIndex]>current ){
                    array[preIndex+gap]= array[preIndex];
                    preIndex-=gap;
                }
                array[preIndex+gap]=current;
            }
            gap/=2;
        }
        return array;
    }
}
