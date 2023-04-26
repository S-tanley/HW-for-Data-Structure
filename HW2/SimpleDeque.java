package HW2;

public class SimpleDeque<T> implements DequeInterface<T>{
    private T [] theQueue;  // Parameter used for array data
	private int size;
    
    public SimpleDeque(int initsize)
    {
        theQueue = (T[]) new Object[initsize];
        size = 0;
    }

    public void addToFront(T itemtoadd) {
        if (size == theQueue.length) {
            Enlarge();
        }
        shift(false);
        theQueue[0] = itemtoadd;
        size++;
    }
    
    public void addToBack(T itemtoadd) {
        if (size == theQueue.length) {
            Enlarge();
        }
        theQueue[size] = itemtoadd;
        size++;
    }

    public T removeBack() {
        T tem;
        if (size != 0) {
            tem = theQueue[size-1];
            theQueue[size-1] = null;
            size--;
        } else {
            tem = null;
        }
        return tem;
    }

    public T removeFront() {
        T tem;
        if (size != 0) {
            tem = theQueue[0];
            theQueue[0] = null;
            size--;
            shift(true);
        } else {
            tem = null;
        }
        return tem; 
    }

    public T getFront() {
        T tem;
        if (size != 0) {
            tem = theQueue[0];
        } else {
            tem = null;
        }
        return tem;  
    }

    public T getBack() {
        T tem;
        if (size != 0) {
            tem = theQueue[size-1];
        } else {
            tem = null;
        }
        return tem;       
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void clear() {
        int rel = theQueue.length;
        theQueue = (T[]) new Object[rel];
        size = 0;
    }

    public String toString() {
        String S = "";
        if (size == 0) {
            S = "Deque is Empty";
            return S;
        }
        for (int i = 0; i < size; i++) {
            S = S + theQueue[i] + ", ";
        }
        return S;
    }

    private void Enlarge() {
        T[] tem = theQueue;
        theQueue = (T[]) new Object[size*2];
        for (int i = 0; i < tem.length; i++) {
            theQueue[i] = tem[i];
        }
    }

    private void shift(boolean inverse) {
        if (inverse) {
            for (int i = 1; i < theQueue.length; i++) {
                theQueue[i-1] = theQueue[i];
            }
        } else {
            for (int i = size-1; i >= 0; i--) {
                theQueue[i+1] = theQueue[i]; 
            }
        }
    }
}
