package search;

/**
 * 二分查找，被查找的集合必须有序
 * 也叫做折半查找，
 * 缺点 查找第一个索引的元素 会额外浪费几次查找
 */
public class BinarySearch {

    private static int[] array = {12,13,14,21,23,34,55};
    private static int times = 0;

    /**
     * 递归方式
     * @param left
     * @param right
     * @param key
     * @return
     */
    public static int binarySearch(int left,int right,int key){

        times++;

        // 递归结束条件
        if (left > right){
            return -1;
        }

        int mid = (left+right) / 2;
        if (key < array[mid]){
            // 向左边递归
           return binarySearch(left,mid-1,key);
        }else if (key > array[mid]){
            //向右边递归
            return binarySearch(mid+1,right,key);
        }else{
            return mid;
        }
    }

    /**
     * 递归方式
     * @param key
     * @return
     */
    public static int binarySearch(int key){
       return  binarySearch(0,array.length-1,key);
    }


    /**
     * 非递归方式
     * @param key
     * @return
     */
    public static int binarySearchNormal(int key){
        int left = 0;
        int right = array.length-1;
        while(left<right){
            int mid = left+right/2;
            if (array[mid] == key){
                return mid;
            }else if(array[mid]>key){
                // 向左查找
                right = right -1;
            }else{
                // 向右查找
                left = left + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = binarySearch(33);
        int index1 = binarySearchNormal(33);
        System.out.println(index);
        System.out.println(index1);

        System.out.println(times);
    }

}
