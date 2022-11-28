package util;

import java.util.EmptyStackException;

/**
 * Classe qui implémente l'itérateur de la pile
 *
 * @author Bogale Tegest & Jallon Sarah
 */
public class Examinator {
    private Element current;

    /**
     * Constructeur, avec l'élément de départ de l'itérateur.
     * À sa création, l'itérateur se réfère au début de la stack (avant le 1er élément).
     *
     * @param el élément sur lequel l'itérateur se réfère
     */
    Examinator(Element el) {
        current = el;
    }

    /**
     * Méthode qui rend l'élément suivant de l'itérateur
     *
     * @return retourne l'Objet stocké dans l'élément suivant de l'itérateur
     * @throws EmptyStackException s'il n'y a plus d'élément à itérer
     */
    public Object next() {
        if (!hasNext()) {
            throw new EmptyStackException();
        }
        Object o = current.data;
        current = current.next;
        return o;
    }

    /**
     * Méthode qui vérifie si l'élément sur lequel l'itérateur se réfère a un élément après
     *
     * @return rend true si l'itérateur n'est pas en fin de la pile, false sinon
     */
    public boolean hasNext() {
        return current != null;
    }
}
