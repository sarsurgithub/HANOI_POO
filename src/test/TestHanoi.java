package test;

import hanoi.Hanoi;

public class TestHanoi {
    public static void main(String[] args) {
        Hanoi hanoi = new Hanoi(5);
        hanoi.solve();
    }
}
