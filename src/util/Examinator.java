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
        if(!this.hasNext()){
            throw new RuntimeException("null value");
        }
        Object o = current.getData();
        current = current.getNext();
        return o;
    }
    public boolean hasNext(){
        return current != null;
    }
}
