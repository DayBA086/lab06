package actividad1;

public class StackArray<E> implements Stack<E> {
    private E[] array;
    private int tope;
    private int capacity;

    @SuppressWarnings("unchecked")
    public StackArray(int n) {
        this.array = (E[]) new Object[n];
        this.tope = -1;
        this.capacity = n;
    }

    public void push(E x) {
        if (tope == capacity - 1) {
            System.out.println("Pila llena");
        } else {
            array[++tope] = x;
        }
    }

    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return array[tope--];
    }

    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Pila vacía");
        return array[tope];
    }

    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == capacity - 1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Tope -> ");
        for (int i = tope; i >= 0; i--) {
            sb.append(array[i]).append(" | ");
        }
        return sb.toString();
    }
}
