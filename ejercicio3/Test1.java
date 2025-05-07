package ejercicio3;

import actividad1.Stack;
import actividad1.ExceptionIsEmpty;
import actividad2.Queue;
import actividad3.PriorityQueue;

import ejercicio1.StackLink;
import ejercicio2.QueueArray;
import ejercicio3.PriorityQueueLinked;

public class Test1 {
    public static void main(String[] args) {
        try {
            System.out.println("=== Prueba de StackLink (lista enlazada) ===");
            Stack<String> pila = new StackLink<>();
            pila.push("A");
            pila.push("B");
            pila.push("C");
            System.out.println(pila);
            System.out.println("Tope: " + pila.top());
            pila.pop();
            System.out.println("Después de pop: " + pila);

            System.out.println("\n=== Prueba de QueueArray ===");
            Queue<Integer> cola = new QueueArray<>(5);
            cola.enqueue(10);
            cola.enqueue(20);
            cola.enqueue(30);
            System.out.println(cola);
            System.out.println("Frente: " + cola.front());
            cola.dequeue();
            System.out.println("Después de dequeue: " + cola);

            System.out.println("\n=== Prueba de PriorityQueueLinked ===");
            PriorityQueue<String, Integer> colaP = new PriorityQueueLinked<>(3);
            colaP.enqueue("normal", 2);
            colaP.enqueue("urgente", 0);
            colaP.enqueue("media", 1);
            System.out.println(colaP);
            System.out.println("Elemento con mayor prioridad: " + colaP.front());
            colaP.dequeue();
            System.out.println("Después de dequeue: " + colaP);

        } catch (ExceptionIsEmpty e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
