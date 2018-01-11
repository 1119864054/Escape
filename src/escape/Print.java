package escape;

import static escape.Escape.gridmap;
import static escape.Escape.m;
import static escape.Escape.n;
import static escape.Escape.grid;

public class Print {
    /***********打印二维数组**************/
    void print() throws InterruptedException {
        for (int i = 0; i <= n + 1; i++) {
                /*for (int j = 0; j <= n + 1; j++) {
                    System.out.printf(grid[i][j] + " ");
                }*/
            for (int j = 0; j <= m + 1; j++) {
                System.out.printf(gridmap[i][j] + " ");
            }
            System.out.printf("\n");
        }

        System.out.printf("\n");
        if(n*m>400)
            Thread.sleep(300);
        else
            Thread.sleep(800);
    }
}
