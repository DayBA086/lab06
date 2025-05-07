package ejercicio1;

import actividad1.Stack;
import actividad3.Node;
import actividad1.ExceptionIsEmpty;

public class StackLink<E> implements Stack<E> {
    private Node<E> top;

    public StackLink() {
        this.top = null;
    }

    @Override
    public void push(E x) {
        Node<E> newNode = new Node<>(x);
        newNode.setNext(top);
        top = newNode;
    }

    @Override
    public E pop() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede desapilar de una pila vacía");
        }
        E value = top.getData();
        top = top.getNext();
        return value;
    }

    @Override
    public E top() throws ExceptionIsEmpty {
        if (isEmpty()) {
            throw new ExceptionIsEmpty("No se puede consultar el tope de una pila vacía");
        }
        return top.getData();
    }

    @Override
    public boolean isEmpty() {
        return top == null;
    }

    @Override
    public String toString() {
        if (isEmpty()) return "Pila vacía";
        StringBuilder sb = new StringBuilder("Tope -> ");
        Node<E> current = top;
        while (current != null) {
            sb.append(current.getData()).append(" | ");
            current = current.getNext();
        }
        return sb.toString();
    }
}
