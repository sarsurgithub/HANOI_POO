package test;

import hanoi.Hanoi;
import hanoi.HanoiDisplayer;

import java.util.Arrays;

/**
 * Classe de test mettant en œuvre toutes les fonctionnalités de la classe Hanoi
 *
 * @author Bogale Tegest & Jallon Sarah
 */
public class TestHanoi {
    private static HanoiDisplayer hanoiDisplayer = new HanoiDisplayer();
    private static Hanoi hanoi;

    public static void main(String[] args) {

        System.out.println("Test the construction of hanoi with a given disks");
        testHanoi();
        System.out.println("Test the algorithme used");
        testSolve();
        System.out.println("Tests the representation of hanoi in an array of 2 dimensions");
        testStatus();
        System.out.println("Hanoi with number of disks less than 1 should raise a RuntimeException: ");
        testWrongDisk();
    }

    /**
     * Test la bonne construction de la tour de hanoi
     */
    private static void testHanoi() {
        hanoi = new Hanoi(5);
        System.out.println("Hanoi : ");
        hanoiDisplayer.display(hanoi);

    }

    /**
     * Construction de la tour de hanoi avec un nombre de disques < 1
     */
    private static boolean testWrongDisk() {
        try {
            hanoi = new Hanoi(0);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;

    }


    /**
     * Teste l'algorithme pour la résolution et la méthode finished()
     */
    private static void testSolve() {
        hanoi = new Hanoi(5);
        System.out.println("Solve : ");
        hanoi.solve();
        System.out.println("When solved the value of finished is true : " + hanoi.finished());

    }

    /**
     * Teste la représentation en tableau de tableau de la pile
     */
    private static void testStatus() {
        hanoi = new Hanoi(5);
        System.out.println("Status : " + Arrays.deepToString(hanoi.status()));
    }


}
