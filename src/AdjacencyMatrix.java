import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdjacencyMatrix {
    private ArrayList<String> vertices;
    private float[][] graph;

    public AdjacencyMatrix(String filename) throws FileNotFoundException {
        vertices = new ArrayList<String>();
        Scanner input = new Scanner(new File(filename));

        while (input.hasNext()) {
            String from = input.next();
            String to = input.next();
            float weight = input.nextFloat();

            if (!vertices.contains(to)) {
                vertices.add(to);
            }
            if (!vertices.contains(to)) {
                vertices.add(to);
            }
        }
        input.close();

        graph = new float[vertices.size()][vertices.size()];

        input = new Scanner(new File(filename));

        while (input.hasNext()) {
            String from = input.next();
            String to = input.next();
            float weight = input.nextFloat();

            int fromIndex = vertices.indexOf(from);
            int toIndex = vertices.indexOf(to);

            graph[fromIndex][toIndex] = weight;
            graph[toIndex][fromIndex] = weight;
        }
        input.close();
    }

    public void printAdjacencyMatrix() {
        System.out.print("   ");
        for (int i=0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + "   ");
        }
        System.out.println();

        for (int i = 0; i < vertices.size(); i++) {
            System.out.print(vertices.get(i) + "   ");
            for (int j = 0; j < vertices.size(); j++) {
                System.out.print(graph[i][j] + "   ");
            }
            System.out.println();

        }
    }
}
