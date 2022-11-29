package util;

import java.util.EmptyStackException;

/**
 * Classe qui implémente la pile
 *
 * @author Bogale Tegest & Jallon Sarah
 */
public class Stack {
    private Element top = null;
    private int size;

    /**
     * Permet d'empiler un objet sur le sommet de la pile.
     * Il est possible d'empiler un objet null
     *
     * @param o l'objet à empiler
     */
    public void push(Object o) {
        top = new Element(o, top);
        ++size;
    }

    /**
     * Permet de désempiler un objet du sommet de la pile
     *
     * @return retourne l'objet désempilé
     * @throws EmptyStackException si la pile est vide
     */
    public Object pop() {
        if (top == null) {
            throw new EmptyStackException();
        }
        Object o = top.data;
        top = top.next;
        --size;
        return o;
    }

    /**
     * Permet de redéfinir la méthode toString() afin d'obtenir la représentation sous la forme de
     * chaîne de caractères du contenu de la pile,
     *
     * @return rend le contenu de la pile sous forme de chaine de caractère
     */
    @Override
    public String toString() {
        Examinator ex = examinator();
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        while (ex.hasNext()) {
            sb.append("<").append(ex.next()).append(">").append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Permet d'obtenir un tableau d’objets représentant
     * l’état actuel de la pile (l’indice 0 contenant l’élément placé au
     * sommet de la pile)
     *
     * @return le tableau d'objet représentant l'état actuel de la pile
     */
    public Object[] stackToArray() {
        Object[] tab = new Object[size];
        int i = 0;
        Examinator ex = examinator();
        while (ex.hasNext()) {
            tab[i++] = ex.next();
        }
        return tab;
    }

    /**
     * Permet de retourner un itérateur le sur le sommet de la pile
     *
     * @return un itérateur
     */
    public Examinator examinator() {
        return new Examinator(top);
    }

    /**
     * Permet de retourner la taille de la pile
     *
     * @return la taille de la pile
     */
    public int size() {
        return size;
    }

    /**
     *Permet de savoir si la stack est vide
     * @return vrai si vide, faux sinon
     */
    public boolean isEmpty(){
        return size() == 0;
    }

}