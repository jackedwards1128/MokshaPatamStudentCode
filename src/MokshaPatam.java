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

        int rolls = 0;

        int position = boardsize;

//        System.out.println("Ladders:");
//        for (int ladder[] : ladders) {
//            System.out.println(ladder[0] + " -> " + ladder[1]);
//        }
//        System.out.println("Snakes:");
//        for (int snake[] : snakes) {
//            System.out.println(snake[0] + " -> " + snake[1]);
//        }

        // Create node array
        int[] nodes = new int[boardsize+1];
        int[] map = new int[boardsize+1];

        for (int i = 1; i <= boardsize; i++) {
            // Set destinations for snakes/ladders
            for (int ladder[] : ladders) {
                if (ladder[0] == i) {
                    map[i] = ladder[1];
                }
            }
            if (map[i] == 0) {
                for (int snake[] : snakes) {
                    if (snake[0] == i) {
                        map[i] = snake[1];
                        System.out.println(snake[0]);
                    }
                }
            }

            if (map[i] == 0) {
                map[i] = i;
            }

            nodes[i] = i;
        }

        System.out.println("hello");

        Queue<Integer> queue = new LinkedList<Integer>();
        boolean[] visited = new boolean[boardsize+1];
        int[] traveltime = new int[boardsize+1];

        queue.add(1);

        while(!(queue.isEmpty())) {
            int current = queue.remove();
            if (current == boardsize) {
                return traveltime[current];
            }
            for(int i = 1; (i <= 6) && (current + i <= boardsize); i++) {
                if (!visited[current+i]) {
                    visited[current+i] = true;
                    visited[map[current+i]] = true;
                    traveltime[map[current+i]] = traveltime[current] + 1;
                    queue.add(map[current+i]);
                }
            }
        }

        return -1;
    }


}
