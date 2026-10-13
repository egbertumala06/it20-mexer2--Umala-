package ticket.triage1;

import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Scanner;

class Ticket {
    String name;
    int urgency;
    int arrivalOrder;

    Ticket(String name, int urgency, int arrivalOrder) {
        this.name = name;
        this.urgency = urgency;
        this.arrivalOrder = arrivalOrder;
    }

    @Override
    public String toString() {
        return name + " (" + urgency + ")";
    }
}

public class TicketTriage1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Ticket> queue = new PriorityQueue<>(
            Comparator.comparingInt((Ticket t) -> t.urgency)
                      .thenComparingInt(t -> t.arrivalOrder)
        );

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nTicket " + (i + 1));

            System.out.print("Enter ticket name: ");
            String name = sc.nextLine();

            System.out.print("Enter urgency (lower number = higher priority): ");
            int urgency = sc.nextInt();
            sc.nextLine(); // Consume newline

            queue.offer(new Ticket(name, urgency, i));
        }

        System.out.println("\nTickets in priority order:");

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        sc.close();
    }
}