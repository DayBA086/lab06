package ejercicio2;

import actividad2.Queue;
import actividad1.ExceptionIsEmpty;

public class QueueArray<E> implements Queue<E> {
    private E[] array;
    private int first;
    private int last;
    private int size;
    private int capacity;

    @SuppressWarnings("unchecked")
    public QueueArray(int capacity) {
        this.capacity = capacity;
        this.array = (E[]) new Object[capacity];
        this.first = 0;
        this.last = -1;
        this.size = 0;
    }

    public void enqueue(E x) {
        if (isFull()) {
            System.out.println("Cola llena");
            return;
        }
        last = (last + 1) % capacity;
        array[last] = x;
        size++;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        E value = array[first];
        array[first] = null;
        first = (first + 1) % capacity;
        size--;
        return value;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return array[first];
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("Cola vacía");
        }
        return array[last];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder("Frente -> ");
        for (int i = 0; i < size; i++) {
            sb.append(array[(first + i) % capacity]).append(" <- ");
        }
        sb.append("Fin");
        return sb.toString();
    }
}
