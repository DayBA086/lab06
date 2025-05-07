package ejercicio3;

import actividad1.ExceptionIsEmpty;
import actividad2.Queue;
import actividad2.QueueLink;

public class PriorityQueueLinked<E> implements actividad3.PriorityQueue<E, Integer> {
    private Queue<E>[] colas;
    private int numPrioridades;

    @SuppressWarnings("unchecked")
    public PriorityQueueLinked(int numPrioridades) {
        this.numPrioridades = numPrioridades;
        this.colas = (Queue<E>[]) new Queue[numPrioridades];
        for (int i = 0; i < numPrioridades; i++) {
            colas[i] = new QueueLink<>();
        }
    }

    public void enqueue(E x, Integer pr) {
        if (pr < 0 || pr >= numPrioridades) {
            System.out.println("Prioridad fuera de rango");
            return;
        }
        colas[pr].enqueue(x);
    }

    public E dequeue() throws ExceptionIsEmpty {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].dequeue();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public E front() throws ExceptionIsEmpty {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return colas[i].front();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public E back() throws ExceptionIsEmpty {
        for (int i = numPrioridades - 1; i >= 0; i--) {
            if (!colas[i].isEmpty()) {
                return colas[i].back();
            }
        }
        throw new ExceptionIsEmpty("Cola de prioridad vacía");
    }

    public boolean isEmpty() {
        for (int i = 0; i < numPrioridades; i++) {
            if (!colas[i].isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Cola de prioridad:\n");
        for (int i = 0; i < numPrioridades; i++) {
            sb.append("Prioridad ").append(i).append(": ").append(colas[i].toString()).append("\n");
        }
        return sb.toString();
    }
}
