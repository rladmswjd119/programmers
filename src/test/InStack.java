package test;


public class InStack<E> {
    private int ptr;
    private E[] stk;
    private int capacity;


    // 생성자
    public InStack(int maxlen){
        ptr = 0;
        capacity = maxlen;
        try{
            stk = (E[]) new Object[maxlen];
        } catch (OutOfMemoryError e) {
            capacity = 0;
        }
    }

    public int getSize(){
        return ptr;
    }

    public E inPush(E p){
        if(ptr >= capacity) {
            throw new OverInStackException();
        }

        return stk[ptr++] = p;
    }

    public E inPop(){
        if(ptr == 0) {
            throw new EmptyInStackException();
        }

        return stk[--ptr];
    }

    public int getPoint(){
        return ptr;
    }

    public int getCapacity(){
        return capacity;
    }

    public E inPeek(){
        if(ptr == 0) {
            throw new EmptyInStackException();
        }
        return stk[ptr - 1];
    }

    public void inClear() {
        ptr = 0;
    }

    public int inIndexOf(E e) {
        for(int i = ptr - 1; i >= 0; i--) {
            if(stk[i] == e) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty(){
        return ptr == 0;
    }

    public boolean isFull(){
        return ptr >= capacity;
    }

    public void getDump(){
        if(ptr <= 0) {
            System.out.println("스택이 비어있습니다.");
        } else {
            for(int i = ptr - 1; i >= 0; i--) {
                System.out.println(stk[i]);
            }
        }
    }
}
