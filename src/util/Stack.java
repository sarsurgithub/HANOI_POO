package util;

public class Stack {
    private Element top;
    private int size;

    public void push(Object o) {
        top = new Element(o, top);
        ++size;
    }


    public Object pop() {
        if (top == null) {
            throw new RuntimeException("The stack is empty");
        }
        Object o = top.getData();
        top = top.getNext();
        --size;
        return o;
    }

    public String toString() {
        Examinator ex = examinator();
        StringBuilder sb = new StringBuilder();
        while (ex.hasNext()) {
            sb.append(ex.next());
        }
        return sb.toString();
    }

    public Object[] stackToArray() { //t
        Object tab[] = new Object[size];
        int i = 0;
        Examinator ex = examinator();
        while(ex.hasNext()){
            tab[i++] = ex.next();
        }
        return tab;
    }

    public Examinator examinator() {
        return new Examinator(top);
    }

    public int size() {  //todo
        return size;
    }

}