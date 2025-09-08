/**
 * Moksha Patam
 * A puzzle created by Zach Blick
 * for Adventures in Algorithms
 * at Menlo School in Atherton, CA
 *
 * Completed by: [YOUR NAME HERE]
 *
 */

public class MokshaPatam {

    /**
     * TODO: Complete this function, fewestMoves(), to return the minimum number of moves
     *  to reach the final square on a board with the given size, ladders, and snakes.
     */
    public static int fewestMoves(int boardsize, int[][] ladders, int[][] snakes) {

        int rolls = 0;

        int position = boardsize;

        // Create node array
        Node[] nodes = new Node[boardsize];

        for (int i = 1; i <= boardsize; i++) {
            // Set destinations for snakes/ladders
            int direct_travel = -1;
            for (int ladder[] : ladders) {
                if (ladder[0] == i) {
                    direct_travel = ladder[1];
                }
            }
            if (direct_travel != -1) {
                for (int snake[] : snakes) {
                    if (snake[0] == i) {
                        direct_travel = snake[1];
                        System.out.println(snake[0]);
                    }
                }
            }
            // Add node to array
            nodes[i-1] = new Node(i, direct_travel, boardsize);
        }

        for (Node node : nodes) {
            node.setNodes(nodes);
            node.setEdges();
        }

        System.out.println("hello");

        Searcher search = new Searcher();

        return search.InitiateSearch(boardsize, nodes);
    }


}
