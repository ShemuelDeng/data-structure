package 常见算法题;

/**
 * 迷宫算法
 */
public class Mase {

    public static void main(String[] args) {
        int[][] map = new int[3][3];
        map[0][0] = 0;
        map[0][1] = 5;
        map[0][2] = 8;
        map[1][0] = 7;
        map[1][1] = 8;
        map[1][2] = 9;
        map[2][0] = 6;
        map[2][1] = 3;
        map[2][2] = 0;

        for (int i = 0 ;i<map.length; i++){
            for (int j = 0;j<map[i].length;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }

        AgoOn(map,0,0);
        System.out.println();
        for (int i = 0 ;i<map.length; i++){
            for (int j = 0;j<map[i].length;j++){
                System.out.print(map[i][j]+"\t");
            }
            System.out.println();
        }
    }

    // -1 hasgo
    public static boolean AgoOn(int[][] map,int i ,int j){
        int m =map[0].length;
        int n =map.length;

        // check index
        if (i>m-1 || i< 0 || j> n-1 || j< 0){
            return false;
        }

        if (i == m -1 && j == n-1 && map[i][j] == 0){
            return true;
        }else {
            if ( map[i][j] != -1){ // hasn't gone
                int temp = map[i][j];
                map[i][j] = -1; // has gone
                if (AgoOn(map,i-1,j)){ // go down
                    return true;
                }else if (AgoOn(map,i+1,j+1)){ // go right
                    return true;
                }else if (AgoOn(map,i,j+1)){ //AgoOn(map,i,j+1)
                    return true;
                }else{
                    map[i][j] = temp;
                    return false;
                }
            }else{
                return false;
            }
        }
    }
}
