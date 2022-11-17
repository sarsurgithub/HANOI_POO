package util;

public class Element {
    private Object data;
    private Element next;

    public Element(Object data, Element next){
        this.data = data;
        this.next = next;
    }
    public Element getNext(){
        return next;
    }
    public Object getData(){
        return data;
    }
}
