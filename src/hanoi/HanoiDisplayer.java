package hanoi;

import java.sql.SQLOutput;

public class HanoiDisplayer {

    /**
     *Permet d'afficher l'état courant du problème de Hanoi dans la console
     * @param h instance de Hanoi que nous souhaitons afficher
     */
    public void display(Hanoi h){
        System.out.println("-- Turn: " + h.turn());
        System.out.println(h);
    }

}
