import actividad1.*;
import actividad2.*;
import actividad3.*;

public class Test {
    public static void main(String[] args) {
        try {
            // Prueba de Stack
            Stack<Integer> pila = new StackArray<>(3);
            pila.push(10); pila.push(20); pila.push(30);
            System.out.println("Pila: " + pila);
            System.out.println("Tope: " + pila.top());
            pila.pop();
            System.out.println("Después de pop: " + pila);

            // Prueba de Queue
            Queue<Integer> cola = new QueueLink<>();
            cola.enqueue(10); cola.enqueue(20); cola.enqueue(30);
            System.out.println("Cola: " + cola);
            cola.dequeue();
            System.out.println("Después de dequeue: " + cola);

            // Prueba de PriorityQueue
            PriorityQueue<String, Integer> colaPrioridad = new PriorityQueueLinkSort<>();
            colaPrioridad.enqueue("media", 3);
            colaPrioridad.enqueue("normal", 5);
            colaPrioridad.enqueue("urgente", 1);
            System.out.println("Cola de prioridad: " + colaPrioridad);
            colaPrioridad.dequeue();
            System.out.println("Después de dequeue: " + colaPrioridad);

        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
