package util;

/**
 * Classe qui implémente les éléments à ajouter à la pile
 *
 * @author Bogale Tegest & Jallon Sarah
 */
class Element {
    Object data;
    Element next;

    /**
     * Constructeur avec l'objet stocké et l'élément suivant
     *
     * @param data l'objet stocké dans l'élément
     * @param next élément suivant l'actuel
     */
    Element(Object data, Element next) {
        this.data = data;
        this.next = next;
    }

}
