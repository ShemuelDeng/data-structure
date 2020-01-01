package sort;

public class BubbleSort implements Sort {
    @Override
    public int[] sort(int[] array) {
        if (array.length == 0)
            return array;
        // 外层循环控制次数
        int times = 0;
        for (int i = 0 ;i<array.length-1;i++){
            times++;
            boolean flag = true; // 优化
            // 第一次循环只需要比较 length-1次，后面每次都少比较一次，所以减i
            // 内层循环两两比较，每次将最大的移到后面
            for (int j = 0 ;j<array.length-1-i;j++){
                if (array[j]>array[j+1]){
                    flag = false; // 发生过交换
                    int temp = array[j];
                    array[j]= array[j+1];
                    array[j+1]= temp;
                }
            }
            if (flag){ // 优化
                break;
            }
        }
        System.out.println("排序完成,本次总共用了"+times+"趟排序完成。");
        return array;
    }
}
