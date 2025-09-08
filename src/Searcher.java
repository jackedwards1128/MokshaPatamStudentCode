import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Searcher {

    private int boardsize;
    private Node[] nodes;

    private Queue<Node> nodesToVisitQueue = new LinkedList<Node>();

    public int InitiateSearch(int boardsize, Node[] nodes) {
        this.boardsize = boardsize;
        this.nodes = nodes;

        int rolls = 0;



        return BreadthFirstSearch(0, nodes[0]);
    }

    public int BreadthFirstSearch(int rolls, Node position) {
        if (position.getNumber() == boardsize) {
            return rolls;
        }
        ArrayList<Node> edges = position.getEdges();

        for (int i = 0; i < edges.size(); i++) {
            if (edges.get(i).getVisited() == false) {
                Node newNode = edges.get(i);
                if (newNode.getDirectTravel() != null) {
                    newNode.setVisited(true);
                    newNode = newNode.getDirectTravel();
                }

                nodesToVisitQueue.add(newNode);
                newNode.setRollsToGetHere(rolls+1);
                newNode.setVisited(true);
            }
        }

        if (nodesToVisitQueue.isEmpty() == false) {
            Node nextNode = nodesToVisitQueue.remove();
            return BreadthFirstSearch(nextNode.getRollsToGetHere(), nextNode);
        } else {
            return -1;
        }
    }
}
