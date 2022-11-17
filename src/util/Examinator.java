package util;

public class Examinator {
    private Element current;

    public Examinator(Element el){
        current = el;
    }

    public void setCurrent(Element current){
        this.current = current;
    }

    public Element getCurrent(){
        return current;
    }

    public Object next(){
        return current.getNext().getData();
    }
    public boolean hasNext(){
        return current.getNext()!= null;
    }
}
