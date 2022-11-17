package util;

public class Examinator {
    private Element current;

    public Examinator(Element el){
        current = el;
    }

    public Element next(){
        return current.getNext();
    }
    public boolean hasNext(){
        return current.getNext()!= null;
    }
}
