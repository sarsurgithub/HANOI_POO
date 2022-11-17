package util;

public class Stack {
    private Element top;
    void push(Element e){
        Element tmp = top;
        top = e;
        e.setNext(tmp);
    }

    void pop(){
        top = top.getNext();
    }
    public String toString(){
        Element el = top;
        StringBuilder sb = new StringBuilder();
        while (el.getNext() != null){
            sb.append(el.getData());
        }
        return sb.toString();
    }

    public Object[] tab(){ //t
        return null;
    }

    public Examinator examinator(){
        return new Examinator(top);
    }

    public int size(){
        return tab().length;
    }

}