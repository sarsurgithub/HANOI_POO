package util;

public class Stack {
    private Element top;
    void push(Object o){
        Element e = new Element(o,top);
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

    public int size(){  //todo
        int size = 0;
        Examinator ex = examinator();
        while(ex.hasNext()){
            size++;
            ex.setCurrent(ex.getCurrent().getNext());
        }
        return size;
    }

}