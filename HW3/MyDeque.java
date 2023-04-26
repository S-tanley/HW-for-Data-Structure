package HW3;

public class MyDeque<T> implements DequeInterface<T> {
    protected T [] theDeque;
    protected int size;
    protected int front;
    protected int back;
    
    public MyDeque(int initsize){
        theDeque = (T[]) new Object[initsize];
        size = 0;
        front = initsize/2;
        back = front - 1;
    }

    public MyDeque(MyDeque<T> initT){
        this(initT.theDeque.length);
        for (int i = 0; i < theDeque.length; i++) {
            theDeque[i] = initT.theDeque[i];
        }
        front = initT.front;
        back = initT.back;
        size = initT.size;
    }

    @Override
    public void addToFront(T newEntry) {
        if (size == theDeque.length) {
            MyEnlarge();
        }
        if (front-1 >= 0) {
            front--;
            theDeque[front] = newEntry;
        } else {
            front = theDeque.length - 1;
            theDeque[front] = newEntry;
        }
        size++;
    }

    @Override
    public void addToBack(T newEntry) {
        if (size == theDeque.length) {
            MyEnlarge();
        }
        if (back+1 <= theDeque.length-1) {
            back++;
            theDeque[back] = newEntry;
        } else {
            back = 0;
            theDeque[back] = newEntry;   
        }
        size++;
    }

    @Override
    public T removeFront() {
        T tem = null;
        if (size == 0) {
        } else {
            tem = theDeque[front];
            size--;
            if (front+1 <= theDeque.length-1) {
                front++;
            } else {
                front = 0;
            }
        } 
        return tem;
    }

    @Override
    public T removeBack() {
        T tem = null;
        if (size == 0) {
        } else {
            tem = theDeque[back];
            size--;
            if (back-1 >= 0) {
                back--;
            } else {
                back = theDeque.length-1;
            }
        }
        return tem;
    }

    @Override
    public T getFront() {
        return theDeque[front];
    }

    @Override
    public T getBack() {
        return theDeque[back]; 
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
        int temlength = theDeque.length;
        theDeque = (T[]) new Object[temlength];
        size = 0;
        front = temlength/2;
        back = front-1;
       }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int capacity() {
        return theDeque.length;
    }

    protected void MyEnlarge() {
        T [] tem = (T[]) new Object[theDeque.length*2];
        for (int i = 0; i < theDeque.length; i++) {
            tem[i] = theDeque[front];
            if (front+1 <= theDeque.length-1) {
                front++;
            } else {
                front = 0;
            }
        }
        theDeque = tem;
        front = 0;
        back = theDeque.length/2 - 1;
    }

    public String toString() {
        String tem = "Contents:";
        int temfront = front;
        for (int i = 0; i < size; i++) {
            tem = tem + " " + theDeque[temfront];
            if (temfront+1 <= theDeque.length-1) {
                temfront++;
            } else {
                temfront = 0;
            }
        }
        return tem;
    }

    protected boolean equals(MyDeque<T> obj){
        if (size != obj.size) {
            return false;
        }
        int front_a = front, front_b = obj.front;
        for (int i = 0; i < size; i++) {
            if (theDeque[front_a] == obj.theDeque[front_b]) {
                if (front_a+1 <= theDeque.length-1) {
                    front_a++;
                } else {
                    front_a = 0;
                } 
                if (front_b+1 <= obj.theDeque.length-1) {
                    front_b++;
                } else {
                    front_b = 0;
                }  
            } else {
                return false;
            }
        }
        return true;
    }
}
