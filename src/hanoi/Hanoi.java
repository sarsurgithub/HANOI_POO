package hanoi;

import util.Stack;

/**
 * Classe qui implémente les tours de hanoi et ses méthodes pour la résolution ainsi que l'affichage
 *
 * @author Bogale Tegest & Jallon Sarah
 */
public class Hanoi {
    private final Stack[] needles = new Stack[3];
    private final HanoiDisplayer hanoiDisplayer;
    private final int disks;
    private int cntTurn;

    /**
     * Constructeur pour l'affichage dans le GUI
     *
     * @param disks          nombre de disques à déplacer
     * @param hanoiDisplayer instance de hanoi displayer pour l'affichage
     * @throws RuntimeException si le nombre de disques est inférieur à 1 ou si hanoiDisplayer est null
     */
    public Hanoi(int disks, HanoiDisplayer hanoiDisplayer) {
        if (disks < 1) throw new RuntimeException("Error: number of disks should be greater than 0.");
        if (hanoiDisplayer == null) throw new RuntimeException("Error: hanoi displayer must be different from null.");
        this.disks = disks;
        this.hanoiDisplayer = hanoiDisplayer;

        for (int i = 0; i < needles.length; ++i) {
            needles[i] = new Stack();
        }
        for (int i = disks; i > 0; --i) {
            needles[0].push(i);
        }
    }

    /**
     * Constructeur pour l'affichage dans la console
     *
     * @param disks nombre de disques à déplacer
     * @throws RuntimeException si le nombre de disques est inférieur à 1 ou si hanoiDisplayer est null
     */
    public Hanoi(int disks) {
        this(disks, new HanoiDisplayer());
    }

    /**
     * Fonction de transfert récursive qui permet de déplacer n disques d'un baton d'origine à un
     * baton de destination en passant par un baton intermédiaire
     *
     * @param src  baton d'origine
     * @param by   baton intermédiaire
     * @param dest baton de destination
     * @param n    nombre de disques à déplacer
     */
    private void move(Stack src, Stack by, Stack dest, int n) {
        if (n < 1)
            return;
        move(src, dest, by, n - 1);
        dest.push(src.pop());
        ++cntTurn;
        hanoiDisplayer.display(this);
        move(by, src, dest, n - 1);
    }


    /**
     * Algorithme de résolution du problème des tours de Hanoi, repris dans le cours
     * de ASD2022.
     */
    public void solve() {
        hanoiDisplayer.display(this);
        move(needles[0], needles[1], needles[2], disks);
    }

    /**
     * Permet d'obtenir le statut courant des tours
     *
     * @return un tableau de tableaux représentant les 3 batons et leurs contenus
     */
    public int[][] status() {
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

    /**
     * Permet de savoir la résolution du problème des tours de hanoi est terminée
     *
     * @return vrai si terminé, faux sinon
     */
    public boolean finished() {
        return needles[0].isEmpty() && needles[1].isEmpty() && needles[2].size() == disks;

    }

    /**
     * Permet de connaître le nombre d'étapes déjà réalisées dans la résolution du
     * problème de Hanoi
     *
     * @return le nombre de l'étape courante
     */
    public int turn() {
        return cntTurn;
    }

    /**
     * Permet de redéfinir la méthode toString() afin d'obtenir la représentation sous la forme de
     * chaine de caractère des trois tours de Hanoi utilisant Stack.toString()
     *
     * @return rend le contenu des trois tours sous forme de chaine de caractères
     */
    @Override
    public String toString() {
        return "One:   " + needles[0] +
                "\nTwo:   " + needles[1] +
                "\nThree: " + needles[2];

    }
}
