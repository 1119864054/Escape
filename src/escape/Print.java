package escape;

import static escape.Escape.gridmap;
import static escape.Escape.m;
import static escape.Escape.n;
import static escape.Escape.grid;

public class Print {
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
        Thread.sleep(1000);
    }
}
