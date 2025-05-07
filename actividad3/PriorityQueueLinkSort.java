package actividad3;

import actividad1.ExceptionIsEmpty;

public class PriorityQueueLinkSort<E, N extends Comparable<N>> implements PriorityQueue<E, N> {
    private Node<EntryNode<E, N>> first;

    public PriorityQueueLinkSort() {
        first = null;
    }

    public void enqueue(E x, N pr) {
        EntryNode<E, N> newEntry = new EntryNode<>(x, pr);
        Node<EntryNode<E, N>> newNode = new Node<>(newEntry);

        if (first == null || pr.compareTo(first.getData().getPriority()) < 0) {
            newNode.setNext(first);
            first = newNode;
        } else {
            Node<EntryNode<E, N>> current = first;
            while (current.getNext() != null && pr.compareTo(current.getNext().getData().getPriority()) >= 0) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            current.setNext(newNode);
        }
    }

    public E dequeue() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        E value = first.getData().getData();
        first = first.getNext();
        return value;
    }

    public E front() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        return first.getData().getData();
    }

    public E back() throws ExceptionIsEmpty {
        if (isEmpty()) throw new ExceptionIsEmpty("Cola vacía");
        Node<EntryNode<E, N>> current = first;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        return current.getData().getData();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Frente -> ");
        Node<EntryNode<E, N>> current = first;
        while (current != null) {
            sb.append(current.getData().toString()).append(" <- ");
            current = current.getNext();
        }
        sb.append("Fin");
        return sb.toString();
    }
}
