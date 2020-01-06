package 常见算法题;

/**
 * 汉诺塔问题
 */
public class HanoiTower {

    public static void main(String[] args) {
        solution(4,'A','B','C');
    }

    /**
     * @param number 盘子个数
     * @param a a塔
     * @param b b塔
     * @param c c塔
     */
    public static void solution(int number,char a ,char b ,char c){

        if (number < 1){
            throw  new RuntimeException("参数有误");
        }

        //当有两个盘子时，即number = 2,
        //1.将第一个盘子从a塔移动到b塔
        //2.将第二个盘子从a塔移动到c塔
        //3.将b塔的盘子移动到c塔， 完成
        // 当n>2时，将上面n-1个盘子看做整体，进行上面三个操作
        if (number == 1){
            // 只有一个盘子 直接A移动到c
            System.out.println("第"+number+"个盘子从"+a +"=>"+ c);
        }else{
            //把a塔的所有盘从a到b
            solution(number-1,a,c,b);
            System.out.println("第"+number+"个盘子从"+a +"=>"+ c);
            //把b塔的所有盘从b到c
            solution(number-1,b,a,c);
        }

    }

}
