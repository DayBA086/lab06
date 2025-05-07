package actividad2;

import actividad1.ExceptionIsEmpty;
import actividad3.Node;

public class QueueLink<E> implements Queue<E> {
    private Node<E> first, last;

    public QueueLink() {
        this.first = null;
        this.last = null;
    }

    public void enqueue(E x) {
        Node<E> aux = new Node<>(x);
        if (isEmpty()) {
            first = aux;
        } else {
            last.setNext(aux);
        }
        last = aux;
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E value = first.getData();
        first = first.getNext();
        if (first == null) last = null;
        return value;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.getData();
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return last.getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        if (isEmpty()) return "Cola vacía";
        StringBuilder sb = new StringBuilder("Frente -> ");
        Node<E> current = first;
        while (current != null) {
            sb.append(current.getData()).append(" <- ");
            current = current.getNext();
        }
        sb.append("Fin");
        return sb.toString();
    }
}
