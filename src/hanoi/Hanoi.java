package hanoi;

import util.Stack;

public class Hanoi {
    private Stack[] needles = new Stack[3];
    private HanoiDisplayer hanoiDisplayer;
    private int turn;
    public Hanoi(HanoiDisplayer hanoiDisplayer){
        // autre chose à faire aussi
        this.hanoiDisplayer = new HanoiDisplayer();
    }

    public void move(Stack src, Stack by, Stack dest, int n){ //t
        if(n < 1)
            return;
        move(src, dest, by,n - 1);
        dest.push(src.pop());
        ++turn;
        hanoiDisplayer.display(this);
        move(by, dest, src,n-1);
    }

    public Hanoi(int disks, HanoiDisplayer displayer){ //s

    }
    public Hanoi(int disks){ //t

    }
    public void solve(){ //s

    }
    public int[][] status(){ //t

    }
    public boolean finished(){ //s

    }
    public int turn(){ //t

    }
}
