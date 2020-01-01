package 常见算法题;


/**
 * 八皇后问题
 * 首先约定，使用一维数组 {0,4,7,5,2,6,1,3} 来表示皇后放置
 * 的位置，数组索引代表放置棋盘上的行数，数组的值代表列数
 */
public class EightQueen {

    private int max = 8;
    private int[] array = new int[max];

    public static int times=0;

    /**
     * 测试八皇后
     * @param args
     */
    public static void main(String[] args) {
        EightQueen eightQueen = new EightQueen();
        eightQueen.putQueen(0);
        System.out.println(times);
    }

    /**
     * 放入第n个皇后
     * @param n
     */
    public void putQueen(int n ){
        if (n<0){
            throw new IllegalArgumentException("参数不合法");
        }

        if (n == max){ // 八个皇后都放置完成
            printQueen();// 输出八皇后的放置位置
        }else {
            for (int i = 0; i<max; i++){
                array[n]=i;  // 每次把第n个皇后放在第n+1行的第一列，然后列依次递增
                if (!isConflict(n)){ // 不冲突
                    putQueen(n+1);// 不冲突，放置下一个皇后
                }
                // 冲突则继续循环
            }
        }
    }



    /**
     * 判断放入的第n个皇后是否与之前的冲突
     * @param n
     * @return
     */
    public boolean isConflict(int n){
        for (int i=0; i < n ; i++){
            /**
             * array[i] == array[n]  代表同一列
             * Math.abs(n-i)== Math.abs(array[n]-array[i]) x坐标之差 等于y坐标之差代表在同一lie
             * 数组索引递增，则必然在不同行，因此只要判断上述两个条件，则满足八皇后的位置放置要求
             */
            if (array[i] == array[n] || Math.abs(n-i)== Math.abs(array[n]-array[i])){
                return true; // 位置冲突
            }
        }
        return false;
    }

    public void printQueen(){

        for (int i = 0;i<max; i++){
            System.out.print(array[i]+"\t");
        }
        times++;
        System.out.println();
    }

}
