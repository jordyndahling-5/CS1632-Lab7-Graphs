import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//File needs to be copy pasted into the folder in intellij

public class Main {
    //read file (each line has both nodes and the weight of the edge that connects them
    //represent as an adjacency list & adjacency matrix
    //breadth-first search algorithm will print out order of nodes (# links away)

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        AdjacencyList list = new AdjacencyList(filename);
        AdjacencyMatrix matrix = new AdjacencyMatrix(filename);
        System.out.println("\nAdjacency List: ");
        list.printAdjacencyList();
        System.out.println("\nAdjacency Matrix: ");
        matrix.printAdjacencyMatrix();

        System.out.print("\nEnter starting vertx: ");
        String start = keyboard.nextLine();

        System.out.println("\nBFS using Adjacency List: ");
        bfsList(list, start);
        System.out.println("\nBFS using Adjacency Matrix: ");
        bfsMatrix(matrix, start);

        keyboard.close();
    }

    public static void bfsList(AdjacencyList list, String start) {
        ArrayList<String> vertices = list.getVertices();
        ArrayList<ArrayList<Node>> graph = list.getGraph();

        boolean[] visited = new boolean[vertices.size()];
        ArrayList<String> queue = new ArrayList<String>();

        int startIndex = vertices.indexOf(start);

        if (startIndex == -1) {
            System.out.println("Starting vertex not found");
            return;
        }

        visited[startIndex] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.remove(0);
            System.out.print(current + " ");
            int currentIndex = vertices.indexOf(current);

            for (int i = 0; i < graph.get(currentIndex).size(); i++) {
                Node neighbor = graph.get(currentIndex).get(i);
                int neighborIndex = vertices.indexOf(neighbor.cv);

                if (!visited[neighborIndex]) {
                    visited[neighborIndex] = true;
                    queue.add(neighbor.cv);
                }
            }
        }
        System.out.println();
    }

    public static void bfsMatrix(AdjacencyMatrix matrix, String start) {
        ArrayList<String> vertices = matrix.getVertices();
        float[][] graph = matrix.getGraph();
        boolean[] visited = new boolean[vertices.size()];
        ArrayList<String> queue = new ArrayList<String>();

        int startIndex = vertices.indexOf(start);

        if (startIndex == -1) {
            System.out.println("Starting vertex not found");
            return;
        }

        visited[startIndex] = true;
        queue.add(start);

        while (!queue.isEmpty()) {
            String current = queue.remove(0);
            System.out.print(current + " ");
            int currentIndex = vertices.indexOf(current);

            for (int i = 0; i < vertices.size(); i++) {
                if (graph[currentIndex][i] != 0 && !visited[i]) {
                    visited[i] = true;
                    queue.add(vertices.get(i));
                }
            }
        }
        System.out.println();
    }
}
