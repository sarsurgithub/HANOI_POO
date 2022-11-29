package hanoi;

import java.sql.SQLOutput;

public class HanoiDisplayer {

    /**
     *
     * @param h
     */
    public void display(Hanoi h){ //s
        //afficher en utilisant status
        System.out.println("-- Turn: " + h.turn());
        System.out.println(h);
    }

}
