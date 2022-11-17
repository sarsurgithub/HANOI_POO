package util;

public class Element {
    private Object data;
    private Element next;
    public void setNext(Element e){
        next = e;
    }
    public Element getNext(){
        return next;
    }
    public Object getData(){
        return data;
    }
}
