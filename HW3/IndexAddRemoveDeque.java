package HW3;

public class IndexAddRemoveDeque<T> extends IndexDeque<T> implements IndexableAddRemove<T> {

    public IndexAddRemoveDeque(int initsize) {
        super(initsize);
        //TODO Auto-generated constructor stub
    }

    @Override
    public void addToFront(int i, T item) {
        if (i+1 > size || i < 0) {
            if (size == 0) {
                theDeque[front] = item;
            } else {
                throw new IndexOutOfBoundsException("Illegal Index " + i);
            }
        } else {
            if (size == theDeque.length) {
                MyEnlarge();
            }
            int p, times;
            if (front+i < theDeque.length) {
                p = front+i;
            } else {
                p = front+i-theDeque.length;
            }
            if (back >= p) {
                times = back - p + 1;
            } else {
                times = back+1 + theDeque.length - p;
            }
            Myshift(back, times);
            theDeque[p] = item;
        }
        size++;
    }

    @Override
    public void addToBack(int i, T item) {
        if (i+1 > size || i < 0) {
            if (size == 0) {
                theDeque[back] = item;
            } else {
                throw new IndexOutOfBoundsException("Illegal Index " + i);
            }
        } else {
            if (size == theDeque.length) {
                MyEnlarge();
            }
            int p, times;
            if (back - i >= 0) {
                p = back - i;
            } else {
                p = back - i + theDeque.length;
            }
            if (back >= p) {
                times = back - p;
            } else {
                times = back + theDeque.length-1 - p;
            }
            Myshift(back, times);
            if(p+1 < theDeque.length){
                p += 1;
            }else{
                p = 0;
            } 
            theDeque[p] = item;
        }
        size++;
    }

    @Override
    public T removeFront(int i) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            int x;
            if (front+i < theDeque.length) {
                x = front+i;
            } else {
                x = front+i-theDeque.length;
            } 
            T tem = theDeque[x];
            int p, times;
            if (front+i-1 < theDeque.length) {
                p = front+i-1;
            } else {
                p = front+i-1-theDeque.length;
            }
            if (p >= front) {
                times = p - front + 1;
            } else {
                times = p + theDeque.length-1 - front;
            }
            Myshift(p, times);
            size--;
            return tem;
        }    
    }

    @Override
    public T removeBack(int i) {
        if (i+1 > size || i < 0) {
            throw new IndexOutOfBoundsException("Illegal Index " + i);
        } else {
            int x;
            if (back - i >= 0) {
                x = back - i;
            } else {
                x = back - i + theDeque.length;
            } 
            T tem = theDeque[x];
            int p, times;
            if (back-i-1 >= 0) {
                p = back-i-1;
            } else {
                p = back-i-1+theDeque.length;
            }
            if (p >= front) {
                times = p - front + 1;
            } else {
                times = p+1 + theDeque.length-1 - front;
            }
            Myshift(p, times);
            size--;
            return tem;
        }    
    }

    private void Myshift(int p, int time){
        int current = p;
        int before;
        int next;
        boolean flag1 = false;
        boolean flag2 = false;
        for (int i = 0; i < time; i++) {
            if (current-1 >= 0) {
                before = current-1;
            } else {
                before = theDeque.length-1;
            }
            if (current+1 < theDeque.length) {
                next = current + 1;
            } else {
                next = 0;
            }
            if (current == front) {
                flag1 = true;
            }
            if(current == back){
                flag2 = true;
            }
            theDeque[next] = theDeque[current];
            current = before;
        }
        if (flag1) {
            if(front+1 < theDeque.length){
                front += 1;
            }else{
                front = 0;
            }
        }
        if (flag2) {
            if (back+1 < theDeque.length) {
                back += 1;
            } else {
                back = 0;
            }
        }
    }
}
