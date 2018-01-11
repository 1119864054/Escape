package escape;

import static escape.Escape.*;

public class Findpath {

    boolean findthepath() throws InterruptedException {
        if ((start.getRow() == finish.getRow()) && (start.getCol() == finish.getCol())) {
            return true;
        }

        for (int i = 0; i < 4; i++)
            offset[i] = new Position();
        offset[0].setRow(0);
        offset[0].setCol(1);//right
        offset[1].setRow(1);
        offset[1].setCol(0);//up
        offset[2].setRow(0);
        offset[2].setCol(-1);//left
        offset[3].setRow(-1);
        offset[3].setCol(0);//down

        here.setRow(start.getRow());
        here.setCol(start.getCol());
        grid[start.getRow()][start.getCol()] = 0;

        U.offer(here);

        Print p = new Print();
        do {
            p.print();

            while (!U.isEmpty()) {
                here = U.poll();
                if (gridmap[here.getRow()][here.getCol()] != '!') gridmap[here.getRow()][here.getCol()] = 'X';
                for (int i = 0; i < numOfNbrs; i++) {
                    nbr.setRow(here.getRow() + offset[i].getRow());
                    nbr.setCol(here.getCol() + offset[i].getCol());
                    if (grid[nbr.getRow()][nbr.getCol()] == -1) {
                        if (gridmap[here.getRow()][here.getCol()] == '!') continue;
                        grid[nbr.getRow()][nbr.getCol()] = grid[here.getRow()][here.getCol()] + 1;
                        if (gridmap[nbr.getRow()][nbr.getCol()] == 'E')
                            return true;
                        else
                            gridmap[nbr.getRow()][nbr.getCol()] = 'S';
                        Position temp = new Position();
                        temp.setRow(nbr.getRow());
                        temp.setCol(nbr.getCol());
                        Q.offer(temp);
                    }
                }
            }
            if (gridmap[nbr.getRow()][nbr.getCol()] == 'E')
                break;
            if (Q.isEmpty())
                return false;

            while (!M1.isEmpty()) {
                magma = M1.poll();
                for (int i = 0; i < numOfNbrs; i++) {
                    flow.setRow(magma.getRow() + offset[i].getRow());
                    flow.setCol(magma.getCol() + offset[i].getCol());
                    if (grid[flow.getRow()][flow.getCol()] >= -1) {
                        grid[flow.getRow()][flow.getCol()] = -2;
                        if (gridmap[flow.getRow()][flow.getCol()] == 'E')
                            return false;
                        else
                            gridmap[flow.getRow()][flow.getCol()] = '!';
                        Position barrel = new Position();
                        barrel.setRow(flow.getRow());
                        barrel.setCol(flow.getCol());
                        M2.offer(barrel);
                    }
                }
            }

            p.print();

            while (!Q.isEmpty()) {
                here = Q.poll();
                if (gridmap[here.getRow()][here.getCol()] != '!') gridmap[here.getRow()][here.getCol()] = 'X';
                for (int i = 0; i < numOfNbrs; i++) {
                    nbr.setRow(here.getRow() + offset[i].getRow());
                    nbr.setCol(here.getCol() + offset[i].getCol());
                    if (grid[nbr.getRow()][nbr.getCol()] == -1) {
                        if (gridmap[here.getRow()][here.getCol()] == '!') continue;
                        grid[nbr.getRow()][nbr.getCol()] = grid[here.getRow()][here.getCol()] + 1;
                        if (gridmap[nbr.getRow()][nbr.getCol()] == 'E')
                            return true;
                        else
                            gridmap[nbr.getRow()][nbr.getCol()] = 'S';
                        Position temp = new Position();
                        temp.setRow(nbr.getRow());
                        temp.setCol(nbr.getCol());
                        U.offer(temp);
                    }
                }
            }
            if (gridmap[nbr.getRow()][nbr.getCol()] == 'E')
                break;
            if (U.isEmpty())
                return false;

            while (!M2.isEmpty()) {
                magma = M2.poll();
                for (int i = 0; i < numOfNbrs; i++) {
                    flow.setRow(magma.getRow() + offset[i].getRow());
                    flow.setCol(magma.getCol() + offset[i].getCol());
                    if (grid[flow.getRow()][flow.getCol()] >= -1) {
                        grid[flow.getRow()][flow.getCol()] = -2;
                        if (gridmap[flow.getRow()][flow.getCol()] == 'E')
                            return false;
                        else
                            gridmap[flow.getRow()][flow.getCol()] = '!';
                        Position barrel = new Position();
                        barrel.setRow(flow.getRow());
                        barrel.setCol(flow.getCol());
                        M1.offer(barrel);
                    }
                }
            }

        }
        while (true);

        return true;
    }
}
