import java.util.ArrayList;

public class Node {

    private int number;
    private int directTravel;
    private boolean visited;
    private int rollsToGetHere;
    private int boardsize;
    private ArrayList<Node> edges;
    private Node[] nodes;


    public Node(int number, int directTravel, int boardsize) {
        this.number = number;
        this.directTravel = directTravel;
        this.visited = false;
        this.boardsize = boardsize;
        this.rollsToGetHere = -1;
    }

    public void setNodes(Node[] nodes) {
        this.nodes = nodes;
    }

    public void setEdges() {
        edges = new ArrayList<Node>();

        if (directTravel == -1) {
            for (int i = 1; i <= 6; i++) {
                if (number + i <= boardsize)
                    edges.add(nodes[number+i-1]);
            }
        } else {
            edges.add(nodes[directTravel-1]);
        }
    }

    public void setRollsToGetHere(int rolls) {
        rollsToGetHere = rolls;
    }

    public int getRollsToGetHere() {
        return rollsToGetHere;
    }

    public boolean getVisited() {
        return visited;
    }

    public void setVisited(boolean visit) {
        this.visited = visit;
    }

    public int getNumber() {
        return number;
    }

    public ArrayList<Node> getEdges() {
        return edges;
    }

    public Node getDirectTravel() {
        if (directTravel == -1)
            return null;

        return nodes[directTravel-1];
    }
}
