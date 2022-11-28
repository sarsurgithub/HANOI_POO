package hanoi;

import util.Stack;

public class Hanoi {
    private Stack[] needles = new Stack[3];
    private HanoiDisplayer hanoiDisplayer;
    private int cntTurn;
    private int disks;


    public void move(Stack src, Stack by, Stack dest, int n) { //t
        if (n < 1)
            return;
        move(src, dest, by, n - 1);
        dest.push(src.pop());
        ++cntTurn;
        hanoiDisplayer.display(this);
        move(by, dest, src, n - 1);
    }

    public Hanoi(int disks, HanoiDisplayer displayer) { //s

    }

    public Hanoi(int disks) { //t
        this(disks, new HanoiDisplayer());

    }

    public void solve() { //s

    }

    public int[][] status() { //t
        Object[][] hanoiStatus = new Object[needles.length][];
        int[][] t = new int[hanoiStatus.length][];
        for (int i = 0; i < t.length; ++i) {
            hanoiStatus[i] = needles[i].stackToArray();
            t[i] = new int[hanoiStatus[i].length];
            for (int j = 0; j < t[i].length; ++j) {
                t[i][j] = (int) hanoiStatus[i][j];
            }
        }
        return t;
    }

    public boolean finished() { //s
        return false;

    }

    public int turn() { //t
        return cntTurn;
    }
}
