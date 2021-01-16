import com.weimin.Graph;

public class Test {
    public static void main(String[] args) {
        Graph<String> stringGraph = new Graph<String>(5);
        stringGraph.addNode("A");
        stringGraph.addNode("B");
        stringGraph.addNode("C");
        stringGraph.addNode("D");
        stringGraph.addNode("E");

        stringGraph.addEdges(0,1,1);
        stringGraph.addEdges(0,2,1);
        stringGraph.addEdges(1,2,1);
        stringGraph.addEdges(1,3,1);
        stringGraph.addEdges(1,4,1);

        stringGraph.show();

        //stringGraph.dfs();
        stringGraph.bfs();
    }
}
