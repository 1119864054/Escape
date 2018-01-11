package escape;

import java.util.Scanner;

import static escape.Escape.*;

public class Buildmaze {
    void buildthemaze() {
        System.out.printf("输入方格行数：");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            n = scanner.nextInt();
            if (n > 1) break;
            else System.out.printf("请输入大于1的正整数：");
        }
        System.out.printf("输入方格列数：");
        while (true) {
            m = scanner.nextInt();
            if (m > 1) break;
            else System.out.printf("请输入大于1的正整数：");
        }

        for (char[] ignored : gridmap = new char[n + 2][m + 2]) {
        }
        for (int[] ignored : grid = new int[n + 2][m + 2]) {
        }
        for (int i = 0; i <= n + 1; i++)
            for (int j = 0; j <= m + 1; j++) {
                grid[i][j] = -1;
                gridmap[i][j] = '.';
            }

        for (int i = 0; i <= m + 1; i++) {
            grid[0][i] = grid[n + 1][i] = -2;
            gridmap[0][i] = gridmap[n + 1][i] = '#';
        }
        for (int i = 0; i <= n + 1; i++) {
            grid[i][0] = grid[i][m + 1] = -2;
            gridmap[i][0] = gridmap[i][m + 1] = '#';
        }

        java.util.Random r = new java.util.Random();
        if (n <= 4 && m <= 4) {
            int wall = Math.abs(r.nextInt()) % (n + m);
            while (wall != 0) {
                int a, b;
                a = Math.abs(r.nextInt()) % n;
                b = Math.abs(r.nextInt()) % m;
                if (a == 0) a++;
                if (b == 0) b++;
                if (a == 0 && b == 0)
                    break;
                grid[a][b] = -2;
                gridmap[a][b] = '#';
                wall--;
            }
        } else {
            PrimBuildmaze prim = new PrimBuildmaze();
            prim.prim();
        }

        while (true) {
            int sRow = Math.abs(r.nextInt()) % n;
            int sCol = Math.abs(r.nextInt()) % m;
            int fRow = Math.abs(r.nextInt()) % n;
            int fCol = Math.abs(r.nextInt()) % m;
            if (sRow == 0) sRow++;
            if (sCol == 0) sCol++;
            if (fRow == 0) fRow++;
            if (fCol == 0) fCol++;
            if (n == 2 && m == 2) {
                sRow = 1;
                sCol = 2;
                fRow = 2;
                fCol = 2;
                gridmap[sRow][sCol] = 'S';
                gridmap[fRow][fCol] = 'E';
            }
            if ((sRow == fRow && sCol == fCol) || (sRow == magma.getRow() && sCol == magma.getCol()) || (fRow == magma.getRow() && fCol == magma.getCol()))
                continue;
            if ((gridmap[sRow][sCol] == '#') || (gridmap[fRow][fCol] == '#'))
                continue;
            else {
                start.setRow(sRow);
                start.setCol(sCol);
                grid[start.getRow()][start.getCol()] = 0;
                gridmap[start.getRow()][start.getCol()] = 'S';
                finish.setRow(fRow);
                finish.setCol(fCol);
                grid[finish.getRow()][finish.getCol()] = -1;
                gridmap[finish.getRow()][finish.getCol()] = 'E';
                break;
            }
        }

        int source = 1 + Math.abs(r.nextInt()) % 2;
        while (source != 0) {
            int mRow = Math.abs(r.nextInt()) % (n);
            int mCol = Math.abs(r.nextInt()) % (m);
            if (mRow == 0) mRow++;
            if (mCol == 0) mCol++;
            if (n == 2 && m == 2) {
                source = 1;
                mRow = 1;
                mCol = 1;
            }
            if ((mRow == finish.getRow() && mCol == finish.getCol()) || (mRow == start.getRow() && mCol == start.getCol()))
                continue;
            else {
                magma.setRow(mRow);
                magma.setCol(mCol);
                grid[magma.getRow()][magma.getCol()] = -2;
                gridmap[magma.getRow()][magma.getCol()] = '!';
                Position barrel = new Position();
                barrel.setRow(magma.getRow());
                barrel.setCol(magma.getCol());
                M1.offer(barrel);
                source--;
            }
        }
    }
}
