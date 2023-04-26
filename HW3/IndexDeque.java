package HW3;

public class IndexDeque<T> extends MyDeque<T> implements Indexable<T>{

    public IndexDeque(int initsize) {
        super(initsize);
        //TODO Auto-generated constructor stub
    }

    @Override
    public T getFront(int i) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            if (front+i < theDeque.length) {
                return theDeque[front+i];
            } else {
                return theDeque[front+i-theDeque.length];
            }
        }
    }

    @Override
    public T getBack(int i) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            if (back-i >= 0) {
                return theDeque[back-i];
            } else {
                return theDeque[back-i+theDeque.length];
            }
        }
    }

    @Override
    public void setFront(int i, T item) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            if (front+i < theDeque.length) {
               theDeque [front+i] = item;
            } else {
                theDeque[front+i-theDeque.length] = item;
            }
        }
    }

    @Override
    public void setBack(int i, T item) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            if (back-i >= 0) {
              theDeque[back-i] = item;
            } else {
                theDeque[back-i+theDeque.length] = item;
            }
        }
    }
}
