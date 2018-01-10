package escape;

import java.util.*;

public class Escape {

    public static int n, m;
    public static int[][] grid;
    public static char[][] gridmap;
    public static int numOfNbrs = 4;
    public static Position[] offset = new Position[4];
    public static Position start = new Position(), finish = new Position();
    public static Position here = new Position(), nbr = new Position();
    public static Position magma = new Position(), flow = new Position();
    public static Queue<Position> M1 = new LinkedList<Position>();
    public static Queue<Position> M2 = new LinkedList<Position>();
    public static Queue<Position> Q = new LinkedList<Position>();
    public static Queue<Position> U = new LinkedList<Position>();

    public static void main(String[] args) throws InterruptedException {

        Buildmaze b = new Buildmaze();
        b.buildthemaze();

        Findpath f = new Findpath();
        if (!f.findthepath()) {
            System.out.println("逃跑失败！");
        } else {
            System.out.println("逃跑成功！");
        }
    }
}