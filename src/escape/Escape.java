package escape;

import java.util.*;

public class Escape {

    public static int n, m;//迷宫的高度和宽带
    public static int[][] grid;
    public static char[][] gridmap;
    public static int numOfNbrs = 4;
    public static Position[] offset = new Position[4];
    public static Position start = new Position(), finish = new Position();//起点和终点
    public static Position here = new Position(), nbr = new Position();//当前位置和其相邻的位置
    public static Position magma = new Position(), flow = new Position();//岩浆的位置及其相邻的位置
    public static Queue<Position> M1 = new LinkedList<Position>();
    public static Queue<Position> M2 = new LinkedList<Position>();
    public static Queue<Position> Q = new LinkedList<Position>();
    public static Queue<Position> U = new LinkedList<Position>();

    public static void main(String[] args) throws InterruptedException {

        Buildmaze b = new Buildmaze();
        b.buildthemaze();//构建迷宫

        Findpath f = new Findpath();
        if (!f.findthepath()) {
            System.out.println("逃跑失败！");
        } else {
            System.out.println("逃跑成功！");
        }
    }
}