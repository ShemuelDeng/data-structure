package search;

/**
 * 线性查找
 */
public class SeqSearch {


    private static int[] array = {12,3,421,3,-1,34,22};

    public static int seqSearch(int key){
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int index = seqSearch(421);
        System.out.println("查找到元素421的索引为："+ index);
    }
}
