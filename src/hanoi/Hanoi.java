package hanoi;

import util.Stack;
/**
 * Classe qui implémente les tours de hanoi et ses méthodes pour la résolution ainsi que l'affichage
 * @author Bogale Tegest & Jallon Sarah
 */
public class Hanoi {
    private final Stack[] needles = new Stack[3];
    private final HanoiDisplayer hanoiDisplayer;
    private int cntTurn;
    private final int disks;


    public void move(Stack src, Stack by, Stack dest, int n) { //t
        if (n < 1)
            return;
        move(src, dest, by, n - 1);
        dest.push(src.pop());
        ++cntTurn;
        hanoiDisplayer.display(this);
        move(by, dest, src, n - 1);
    }

    public Hanoi(int disks, HanoiDisplayer hanoiDisplayer) { //s
        this.disks = disks;
        this.hanoiDisplayer = hanoiDisplayer;
        for (int i = disks; i > 0; --i) {
            needles[0].push(i);
        }
    }

    public Hanoi(int disks) { //t
        this(disks, new HanoiDisplayer());

    }

    public void solve() { //s
        if (disks > 0) {
            move(needles[0], needles[2], needles[1], disks - 1);
            needles[2].push(needles[0]);
            move(needles[1], needles[0], needles[2], disks - 1);

        }
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
        return needles[0].size() == 0 && needles[1].size() == 0 && needles[3].size() == disks;

    }

    public int turn() { //t
        return cntTurn;
    }
}
