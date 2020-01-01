package search;

/**
 * 二分查找的改进版，通过公式，确定mid值，能更快找到对应的元素
 * mid = left + (right-left)*(key-array[left])/(array[right]-array[left])
 */
public class InsertionSearch {
    private static int[] array = {12,13,14,21,23,34,55};
    private static int times = 0;
    public static int insertValueSearch(int left,int right,int key){

        times++;

        // 递归结束条件
        if (left > right || key < array[0] || key > array[array.length-1]){
            return -1;
        }

        int mid = left + (right-left)*(key-array[left])/(array[right]-array[left]);
        if (key < array[mid]){
            // 向左边递归
            return insertValueSearch(left,mid-1,key);
        }else if (key > array[mid]){
            //向右边递归
            return insertValueSearch(mid+1,right,key);
        }else{
            return mid;
        }
    }

    public static int insertValueSearch(int key){
        return  insertValueSearch(0,array.length-1,key);
    }

    public static void main(String[] args) {
        int index = insertValueSearch(-12);
        System.out.println(index);
        System.out.println(times);
    }
}
