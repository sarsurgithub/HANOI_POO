package test;

import util.*;

import java.util.Arrays;
import java.util.EmptyStackException;


/**
 * Classe de test mettant en œuvre toutes les fonctionnalités des classes du package util,
 * soit Stack, Element et Examinator
 * @author Bogale Tegest & Jallon Sarah
 */
public class TestStack {
    private static final String passed = "Passed";
    private static final String failed = "Failed";

    public static void main(String[] args) {
        System.out.println();
        System.out.println("************************ TEST push(Object o) & toString() ************************");
        testPush();
        System.out.println();
        System.out.println("************************ TEST pop() **********************************************");
        testPop();
        System.out.println();
        System.out.println("************************ TEST hasNext() ******************************************");
        testHasNext();
        System.out.println();
        System.out.println("************************ TEST stackToArray() *************************************");
        testStackToArray();
        System.out.println("************************ TEST next() *************************************");
        testNext();

    }

    /**
     * Permet de tester l'empilement des valeurs correctes, incorrectes, null ainsi que la représentation sous la
     * forme de chaîne de caractère du contenu de la pile
     */
    private static void testPush() {
        Stack s = creatTestStack(4);
        String correct = "[ <1> <2> <3> <4> ]";
        String wrongStringRep = "[ <1 <2> <3> <4> ]";
        String inCorrect = "[ <2> <3> <4> ]";

        Stack emptyStack = creatTestStack(0);
        System.out.println("The representation of an empty stack is [ ] = " + emptyStack);
        System.out.println("Wrong string representation should fail: "
                + (testResultS(s.toString(), wrongStringRep).equals(failed) ? passed : failed));
        System.out.println("Creation of a stack with correct expected values: "
                + testResultS(s.toString(), correct));
        System.out.println("Creation of a stack with incorrect expected values should not work: "
                + (testResultS(s.toString(), inCorrect).equals(failed) ? passed : failed));
        System.out.println("Creation of a stack with correct values and correct string representation: "
                + testResultS(correct, s.toString()));

        s.push(null);
        System.out.println("Pushing \"null\" object to the stack is possible. Result: " + s);

    }

    /**
     * Permet de tester le désempilement des valeurs correctes, incorrectes et null
     */
    private static void testPop() {
        Stack s = creatTestStack(2);
        s.pop();
        String correct = "[ <2> ]";
        String inCorrect = "[ <1> <2> ]";

        System.out.println("Pop from a non empty stack works: " + testResultS(s.toString(), correct));
        System.out.println("The stack value after a pop is different from the original and is correct: "
                + (testResultS(s.toString(), inCorrect).equals(failed) ? passed : failed));
        System.out.println("Pop on empty stack should throw EmptyStackException (null) : ");
        try {
            s.pop();
            s.pop();
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }

        Stack nullS = creatTestStack(0);
        nullS.push(null);
        System.out.println("We can pop a null value. Before: " + nullS);
        nullS.pop();
        System.out.println("After pop(): " + nullS);

    }

    /**
     * Test le fonctionnement de hasNext()
     */

    private static void testHasNext() {
        Stack s = creatTestStack(3);
        Examinator e = s.examinator();
        int cnt = 0;
        while (e.hasNext()) {
            e.next();
            ++cnt;
        }
        System.out.println("hasNext iterates until the stack is empty: "
                + testResult(cnt, s.size()));

        Examinator e2 = s.examinator();
        for (int i = 0; i < 10; ++i) {
            if (e2.hasNext()) {
                ++cnt;
            }
        }
        System.out.println("The iterator doesn't overflow : "
                + (testResult(cnt, s.size()).equals(failed) ? passed : failed));

    }

    /**
     * Test le fonctionnement de hasNext()
     */

    private static void testNext() {
        Stack s = creatTestStack(3);
        Examinator e = s.examinator();

        System.out.println("Printing stack values using next() works as expected: ");
        for (int i = 0; i < s.size(); ++i) {
            System.out.println(e.next());
        }
        System.out.println("If the iterator overflow an EmptyStackException is raised(null): ");
        try {
            for (int j = 0; j < s.size() + 3; ++j) {
                System.out.println(e.next());
            }
        } catch (EmptyStackException ex) {
            System.out.println(ex.getMessage());
        }

    }

    /**
     * Test le fonctionnement de stackToArray
     */
    private static void testStackToArray() {
        Stack s = creatTestStack(4);
        String correctArray = "[1, 2, 3, 4]";
        String incorrectArray = "[1 2 3 4]";
        System.out.println("Check with correct array: " +
                testResultS(Arrays.toString(s.stackToArray()), correctArray));
        System.out.println("Check with incorrect array: " +
                (testResultS(Arrays.toString(s.stackToArray()), incorrectArray).equals(failed) ? passed : failed));

        Stack empty = creatTestStack(0);
        System.out.println("Representation of empty stack to array: " + Arrays.toString(empty.stackToArray()));
    }

    /**
     * Permet de créer et remplir une pile
     */
    private static Stack creatTestStack(int size) {
        Stack s = new Stack();
        for (int i = size; i > 0; --i) {
            s.push(i);
        }
        return s;
    }

    /**
     * Permet de comparer la sortie avec le bon affichage
     */
    private static String testResultS(String a, String b) {
        if (a.equals(b)) return passed;
        else return failed;
    }

    /**
     * Permet de comparer si on a le bon nombre de résultats.
     */
    private static String testResult(int a, int b) {
        if (a == b)
            return passed;
        else return failed;
    }

}
