package escape;

public class Position {
    int row = 1;//在二维数组中的行号
    int col = 1;//在二维数组中的行号
    int state;//被访问过则为1，未被访问过则为二

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }
}

