import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        // put your code here
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();
            LoadBalancer balancer = new LoadBalancer();
            for (int i = 0; i < n; i++) {
                balancer.task(sc.nextInt(), sc.nextInt());
            }
            printCollection(balancer.lowLoadQueue);
            printCollection(balancer.highLoadQueue);
        }
    }
    
    private static <T> void printCollection(Collection<T> elements) {
        for (T element : elements) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
    
    static class LoadBalancer {
        private final Queue<Integer> lowLoadQueue;
        private final Queue<Integer> highLoadQueue;
        private long lowLoad = 0L;
        private long highLoad = 0L;

        LoadBalancer() {
            lowLoadQueue = new LinkedList<>();
            highLoadQueue = new LinkedList<>();
        }

        void task(int id, int load) {
            if (lowLoad <= highLoad) {
                lowLoadQueue.add(id);
                lowLoad += load;
            } else {
                highLoadQueue.add(id);
                highLoad += load;
            }
        }
    }
}
