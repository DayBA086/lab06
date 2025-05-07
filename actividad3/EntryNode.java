package actividad3;

public class EntryNode<E, N extends Comparable<N>> {
    private E data;
    private N priority;

    public EntryNode(E data, N priority) {
        this.data = data;
        this.priority = priority;
    }

    public E getData() { return data; }
    public N getPriority() { return priority; }

    @Override
    public String toString() {
        return "(" + data + ", prioridad: " + priority + ")";
    }
}
