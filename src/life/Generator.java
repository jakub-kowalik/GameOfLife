package life;

import java.util.Random;

public class Generator {

    public static void multipleStep(boolean[][] universe, int steps) {

        if (steps == 0) {
            return;
        }
        for (int i = 0; i < steps; i++) {
            generate(universe);
        }
    }

    public static void generate(boolean[][] universe) {
        boolean[][] copyOfUniverse = deepCopyArray(universe);


        for (int i = 0; i < universe.length; i++) {
            for (int j = 0; j < universe.length; j++) {

                if (copyOfUniverse[i][j]) {
                    universe[i][j] = numberOfNeighbours(copyOfUniverse, i, j) == 2 || numberOfNeighbours(copyOfUniverse, i, j) == 3;
                } else {
                    if (numberOfNeighbours(copyOfUniverse, i, j) == 3) {
                        universe[i][j] = true;
                    }
                }

            }
        }

    }

    public static boolean[][] deepCopyArray(boolean[][] booleans) {
        boolean[][] deepCopy = new boolean[booleans.length][booleans.length];
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans.length; j++) {
                deepCopy[i][j] = booleans[i][j];
            }
        }
        return deepCopy;
    }

    public static int numberOfNeighbours(boolean[][] booleans, int i, int j) {
        int temp = 0;

        if (findNorthNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findSouthNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findEastNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findWestNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findNorthEastNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findNorthWestNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findSouthEastNeighbour(booleans, i, j)) {
            temp++;
        }
        if (findSouthWestNeighbour(booleans, i, j)) {
            temp++;
        }

        return temp;
    }


    public static boolean findNorthNeighbour(boolean[][] booleans, int i, int j) {
        if (i == 0) {
            return booleans[booleans.length - 1][j];
        } else {
            return booleans[i - 1][j];
        }
    }

    public static boolean findSouthNeighbour(boolean[][] booleans, int i, int j) {
        if (i == booleans.length - 1) {
            return booleans[0][j];
        } else {
            return booleans[i + 1][j];
        }
    }

    public static boolean findEastNeighbour(boolean[][] booleans, int i, int j) {
        if (j == 0) {
            return booleans[i][booleans.length - 1];
        } else {
            return booleans[i][j - 1];
        }
    }

    public static boolean findWestNeighbour(boolean[][] booleans, int i, int j) {
        if (j == booleans.length - 1) {
            return booleans[i][0];
        } else {
            return booleans[i][j + 1];
        }
    }

    public static boolean findNorthEastNeighbour(boolean[][] booleans, int i, int j) {
        if (i == 0 && j == 0) {
            return booleans[booleans.length - 1][booleans.length - 1];
        } else if (i == 0) {
            return booleans[booleans.length - 1][j - 1];
        } else if (j == 0) {
            return booleans[i - 1][booleans.length - 1];
        } else {
            return booleans[i - 1][j - 1];
        }
    }

    public static boolean findNorthWestNeighbour(boolean[][] booleans, int i, int j) {
        if (i == 0 && j == booleans.length - 1) {
            return booleans[booleans.length - 1][0];
        } else if (i == 0) {
            return booleans[booleans.length - 1][j + 1];
        } else if (j == booleans.length - 1) {
            return booleans[i - 1][0];
        } else {
            return booleans[i - 1][j + 1];
        }
    }

    public static boolean findSouthEastNeighbour(boolean[][] booleans, int i, int j) {
        if (i == booleans.length - 1 && j == 0) {
            return booleans[0][booleans.length - 1];
        } else if (i == booleans.length - 1) {
            return booleans[0][j - 1];
        } else if (j == 0) {
            return booleans[i + 1][booleans.length - 1];
        } else {
            return booleans[i + 1][j - 1];
        }
    }

    public static boolean findSouthWestNeighbour(boolean[][] booleans, int i, int j) {
        if (i == booleans.length - 1 && j == booleans.length - 1) {
            return booleans[0][0];
        } else if (i == booleans.length - 1) {
            return booleans[0][j + 1];
        } else if (j == booleans.length - 1) {
            return booleans[i + 1][0];
        } else {
            return booleans[i + 1][j + 1];
        }
    }

    public static void createUniverse(boolean[][] booleanArrays, Random random) {
        for (int i = 0; i < booleanArrays.length; i++) {
            for (int j = 0; j < booleanArrays[i].length; j++) {
                booleanArrays[i][j] = random.nextBoolean();
            }
        }
    }

}
