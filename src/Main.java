import hanoi.Hanoi;
import hanoi.gui.JHanoi;


/**
 * Permet de lancer le programme en ligne de commande ou avec l'interface graphique
 *
 * @author Bogale Tegest & Jallon Sarah
 */
public class Main {
    /**
     * Lance le programme en ligne de commande ou avec l'interface graphique
     * @param args arguments donnés en ligne de commande
     * @throws RuntimeException si le nombre de disques est < 1 ou si hanoi Displayer est null
     *
     */
    public static void main(String[] args) {
        try{
            if (args.length == 1) {
                Hanoi hanoi = new Hanoi(Integer.parseInt(args[0]));
                hanoi.solve();
            } else if (args.length == 0) {
                new JHanoi();
            } else {
                System.out.println("To use the interface run the program without arguments");
                System.out.println("To use the console run the program with the number of disks");
            }
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

    }
}