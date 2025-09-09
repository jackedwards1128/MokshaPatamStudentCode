import java.util.LinkedList;
import java.util.Queue;

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

        // Create node array and map for destinations of nodes
        // Note that our arrays are length  boardsize+1. This choice is so that nodes can hold the values of their
        // index, rather than their index + 1 . This adds only constant time to the runtime,
        // but makes the code much easier to read and comprehend.
        int[] nodes = new int[boardsize+1];
        int[] map = new int[boardsize+1];

        for (int i = 1; i <= boardsize; i++) {
            // Create map for ladders
            for (int ladder[] : ladders) {
                if (ladder[0] == i) {
                    map[i] = ladder[1];
                }
            }
            if (map[i] == 0) {
                // Add snakes to map
                for (int snake[] : snakes) {
                    if (snake[0] == i) {
                        map[i] = snake[1];
                    }
                }
            }
            // If no snake or ladder present, set the destination of the node equal to it's index
            if (map[i] == 0) {
                map[i] = i;
            }

            nodes[i] = i;
        }

        // Create the queue, which is the primary data structure for breadth first search
        Queue<Integer> queue = new LinkedList<Integer>();

        // Create more associative arrays which house whether the node has been explored (visited) and how many rolls
        // it took to get to a given node (traveltime)
        // Arrays are length boardsize + 1 for reasons described on line 23
        boolean[] visited = new boolean[boardsize+1];
        int[] traveltime = new int[boardsize+1];

        // Add the start of the board to the queue, as the search needs a beginning to run
        queue.add(1);

        // This loop will only finish if the board is impossible, as the winning spot will come up in all other cases
        while(!(queue.isEmpty())) {
            // Get the head of the queue
            int current = queue.remove();
            // Base case: if we are at the winning spot, return how many rolls it took to get to "here"
            if (current == boardsize) {
                return traveltime[current];
            }
            // Add the 6 possible rolls (1-6) from the current node to the queue of nodes to explore
            for(int i = 1; (i <= 6) && (current + i <= boardsize); i++) {
                // If we haven't already been to this node
                if (!visited[current+i]) {
                    // Visit both the node and the node's destination, as if a ladder comes from this spot, we are
                    // visiting both the top and bottom of the ladder in a single step
                    visited[current+i] = true;
                    visited[map[current+i]] = true;
                    // Set the travel time of the visited node to 1 more than the current travel time (i.e "rolls"++)
                    traveltime[map[current+i]] = traveltime[current] + 1;
                    // Add the to-be-explored node to the queue
                    queue.add(map[current+i]);
                }
            }
        }
        // If the queue empties, that means the winning spot was never encountered, which means we can return -1 to
        // signify an impossible board
        return -1;
    }


}
