import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyList {

    private ArrayList<String> vertices;
    private ArrayList<ArrayList<Node>> graph; //a list of each node (with each node having a list of what it connects to)

    public AdjacencyList(String filename) throws FileNotFoundException {
        vertices = new ArrayList<String>();
        graph = new ArrayList<ArrayList<Node>>();

        Scanner input = new Scanner(new File(filename));

        //read file
        while (input.hasNext()) {
            String from = input.next();
            String to = input.next();
            float weight = input.nextFloat();

            if (!vertices.contains(from)) {
                vertices.add(from);
                graph.add(new ArrayList<Node>());
            }
            if (!vertices.contains(to)) {
                vertices.add(to);
                graph.add(new ArrayList<Node>());
            }

            int fromIndex = vertices.indexOf(from);
            int toIndex = vertices.indexOf(to);
            graph.get(fromIndex).add(new Node(to, weight));
            graph.get(toIndex).add(new Node(from, weight));
        }
        input.close();
    }

    public void printAdjacencyList() {
        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + " -> ");
            for (int j = 0; j < graph.get(i).size(); j++) {
                Node neighbor = graph.get(i).get(j);
                System.out.print(neighbor.cv + "(" + neighbor.edge + ") ");
            }
            System.out.println();
        }
    }
}
