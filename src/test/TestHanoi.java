package test;

import hanoi.Hanoi;
import hanoi.HanoiDisplayer;

public class TestHanoi {
    public static void main(String[] args) {
        if(args.length == 1){
            Hanoi hanoi = new Hanoi(Integer.parseInt(args[0]));
            hanoi.solve();
        } else if (args.length == 0) {
            new HanoiDisplayer();
        } else {
            System.out.println("To use the interface run the program without arguments");
            System.out.println("To use the console run the program with the number of disks");
        }
    }
}
