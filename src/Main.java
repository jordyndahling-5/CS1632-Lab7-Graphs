import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    //read file (each line has both nodes and the weight of the edge that connects them
    //represent as an adjacency list & adjacency matrix
    //breadth-first search algorithm will print out order of nodes (# links away)

    public static void main(String[] args) throws FileNotFoundException {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = keyboard.nextLine();

        AdjacencyList list = new AdjacencyList(filename);
        System.out.println("/nAdjacency List: ");
        list.printAdjacencyList();

        keyboard.close();
    }
}
