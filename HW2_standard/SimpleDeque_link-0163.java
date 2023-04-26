package HW2_standard;

class node<T>{
    node<T> before;
    node<T> next;
    T data;
}

public class SimpleDeque_link<T> implements DequeInterface<T> {
    private node<T> Head;
    private node<T> tail;
    private int length;
    private int size;

    SimpleDeque_link(int initsize){
        Head = new node<T>();
        tail = new node<T>();
        Head.next = tail;
        tail.before = Head;
        length = initsize;
    }

    @Override
    public void addToFront(T newEntry) {
        if (size < length) {
            node<T> tem = new node<T>();
            tem.next = Head.next;
            Head.next.before = tem;
            Head.next = tem;
            tem.before = Head;
            tem.data = newEntry;
            size++;
        } else {
            System.out.println("No room, " + newEntry + " not added to Deques");
        }
    }

    @Override
    public void addToBack(T newEntry) {
        if (size < length) {
            node<T> tem = new node<T>();
            tail.before.next = tem;
            tem.before = tail.before;
            tem.next = tail;
            tail.before = tem;
            tem.data = newEntry;
            size++;
        } else {
            System.out.println("No room, " + newEntry + " not added to Deques"); 
        }
    }

    @Override
    public T removeFront() {
        T tem;
        if (size > 0) {
            tem = Head.next.data;
            Head.next = Head.next.next;
            size--;
        } else {
            tem = null;
        }
        return tem;
    }

    @Override
    public T removeBack() {
        T tem;
        if (size > 0) {
            tem = tail.before.data;
            tail.before = tail.before.before; 
            size--;
        } else {
            tem = null;
        }
        return tem; 
    }

    @Override
    public T getFront() {
        if (size > 0) {
            return Head.next.data;
        } else {
            return null;
        }
    }

    @Override
    public T getBack() {
        if (size > 0) {
            return tail.before.data;
        } else {
            return null;
        }
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void clear() {
        Head.next = tail;
        tail.before = Head;
        size = 0;
    }

    public String toString(){
        String S = "";
        if (size == 0) {
            S = "Deque is Empty";
            return S;
        }
        node<T> tem = Head;
        for (int i = 0; i < size; i++) {
            S = S + tem.next.data + ", ";
            tem = tem.next;
        }
        return S;
    }
}
