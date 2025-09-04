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

        int ladderScores[] = new int[ladders.length];

        while (true) {
            System.out.println("position: " + position + "     rolls: " + rolls);
            int bestScore = Integer.MIN_VALUE;
            int bestScoreIndex = -1;
            for (int i = 0; i < ladders.length; i++) {
                if (ladders[i][1] > position)
                    continue;

                int lengthRolls = (int) Math.ceil((ladders[i][1] - ladders[i][0]) / 6);
                int distanceRolls = (int) Math.ceil((position - ladders[i][1]) / 6);
                int score = lengthRolls - distanceRolls;
                ladderScores[i] = score;

                if (score > bestScore) {
                    bestScore = score;
                    bestScoreIndex = i;
                }
            }
            if (bestScoreIndex == -1) {
                System.out.println("breaking; pos: " + position);
                break;
            }
            System.out.println("next ladder: " + ladders[bestScoreIndex][1]);
            rolls += (int) Math.ceil((position - ladders[bestScoreIndex][1]) / 6.0);
            position = ladders[bestScoreIndex][0];
        }

        rolls += (int) Math.ceil((position - 1) / 6.0);
        // Start at finishing square (work backwards)
        // Ladder score = ceiling(length / 6) - ceiling(distance away from player - 6)
        // find all ladder scores
        // find ladder with highest score
        // roll to that ladder
        // go down it
        // repeat
        // profit

        System.out.println("ROLLS " + rolls);
        return rolls;
    }

}
