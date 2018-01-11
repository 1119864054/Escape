package escape;

import java.util.Stack;

import static escape.Escape.*;

public class PrimBuildmaze {

    public static int height;
    public static int width;
    public static int[][] state;
    public static boolean up = false, down = false, right = false, left = false;

    public static void setDirFalse() {
        up = false;
        down = false;
        right = false;
        left = false;
    }

    /***********利用随机生成树产生迷宫，算是自己额外添加的功能**************/
    void prim() {
        height = n;
        width = m;
        state = new int[height + 2][width + 2];

        Stack<Position> stack = new Stack<>();

        for (int i = 0; i <= height + 1; i++)
            for (int j = 0; j <= width + 1; j++) {
                state[i][j] = 0;
            }

        int row = 1, col = 1;
        state[row][col] = 1;

        Position temp = new Position();
        Position pmet = new Position();
        temp.row = row;
        temp.col = col;
        temp.state = 1;

        while (true) {
            temp.row = row;
            temp.col = col;
            java.util.Random r = new java.util.Random();
            int randNum = Math.abs(r.nextInt()) % 4;
            switch (randNum) {
                case 0://上
                    if (!up && row > 2 && state[row - 2][col] == 0) {
                        Position t = new Position();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row - 2][col] = 1;
                        state[row - 1][col] = 1;
                        row = row - 2;
                        setDirFalse();
                    } else
                        up = true;
                    break;
                case 1://下
                    if (!down && row < height - 1 && state[row + 2][col] == 0) {
                        Position t = new Position();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row + 2][col] = 1;
                        state[row + 1][col] = 1;
                        row = row + 2;

                        setDirFalse();
                    } else
                        down = true;
                    break;
                case 2://左
                    if (!left && col > 2 && state[row][col - 2] == 0) {
                        Position t = new Position();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row][col - 2] = 1;
                        state[row][col - 1] = 1;
                        col = col - 2;
                        setDirFalse();
                    } else
                        left = true;
                    break;
                case 3://右
                    if (!right && col < width - 1 && state[row][col + 2] == 0) {
                        Position t = new Position();
                        t.row = temp.row;
                        t.col = temp.col;
                        t.state = temp.state;
                        stack.push(t);
                        state[row][col + 2] = 1;
                        state[row][col + 1] = 1;
                        col = col + 2;
                        setDirFalse();
                    } else
                        right = true;
                    break;
            }
            if (up && down && right && left) {
                if (!stack.empty()) {
                    row = stack.peek().row;
                    col = stack.peek().col;
                    stack.pop();
                    setDirFalse();
                } else {
                    for (int i = 0; i <= height + 1; i++)
                        for (int j = 0; j <= width + 1; j++) {
                            if (state[i][j] == 0) {
                                gridmap[i][j] = '#';
                                grid[i][j] = -2;
                            }
                            if (state[i][j] == 1) {
                                gridmap[i][j] = '.';
                                grid[i][j] = -1;
                            }
                        }
                    return;
                }
            }
        }
    }
}
