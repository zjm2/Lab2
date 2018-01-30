import edu.illinois.cs.cs125.lib.mazemaker.Maze;

/**
 * Solve a randomly-generated maze.
 *
 * @see <a href="https://github.com/cs125-illinois/mazemaker">Mazemaker on GitHub</a>
 * @see <a href="https://cs125-illinois.github.io/mazemaker/">Mazemaker Documentation</a>
 * @see <a href="https://cs125.cs.illinois.edu/lab/2/#maze">Lab 2 Writeup</a>
 */
@SuppressWarnings("checkstyle:emptyblock")
public class SolveMaze {

    /**
     * Implement your maze solving algorithm in the main method below.
     *
     * @param unused unused input arguments
     */

    public static void main(final String[] unused) {
        /*
         * Create a new 10 x 10 maze. Feel free to change these values.
         */
        Maze maze = new Maze(10, 10);

        /*
         * Pick (0, 0), the bottom left corner, as the starting point.
         * Put the end in the top right corner.
         */
        maze.startAtZero();
        maze.endAtTopRight();

        /*
         * You should be able to solve a 10 x 10 maze in (far fewer than) 1000 steps.
         * Feel free to adjust this number if you experiment with other mazes.
         */
        for (int step = 0; step < 1000; step++) {
            // Implement your maze solving algorithm here
            if (maze.isFinished()) {
                break;
            }
            if (!maze.isFinished()) {
                while (maze.canMove()) {
                    maze.move();
                }
                if (Math.random() < .5) {
                    maze.turnRight();
                    while (maze.canMove()) {
                        maze.move();
                    }
                }
                if (Math.random() >= .5) {
                    maze.turnLeft();
                    while (maze.canMove()) {
                        maze.move();
                    }
                }
            }
            System.out.println(step);

        }
        if (maze.isFinished()) {
            System.out.println("You solved the maze!");
        } else {
            System.out.println("Try again!");
        }
    }
}
/* 1. It takes about 50-100 steps to complete the maze
   2. N + M - 1
   3. Alot worse in general.
   4. Try and  move diagonally.
 */

