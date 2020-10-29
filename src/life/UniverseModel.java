package life;

import java.util.Random;

public class UniverseModel {

    private boolean[][] booleanArrays;
    private Random random;
    private int generation;
    private boolean paused;

    public UniverseModel(int size) {
        booleanArrays = new boolean[size][size];
        resetRandom();
        generation = 0;
        paused = false;
    }

    public Random getRandom() {
        return random;
    }

    public void resetRandom() {
        this.random = new Random();
    }

    public boolean[][] getBooleanArrays() {
        return booleanArrays;
    }

    public void setBooleanArrays(boolean[][] booleanArrays) {
        this.booleanArrays = booleanArrays;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public boolean isPaused() {
        return this.paused;
    }

    public void setPaused(boolean paused) {
        this.paused = paused;
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < booleanArrays.length; i++) {
            for (int j = 0; j < booleanArrays[i].length; j++) {
                if (booleanArrays[i][j]) {
                    output.append("O");
                } else {
                    output.append(" ");
                }
            }
            output.append("\n");
        }

        return output.toString();
    }


}
