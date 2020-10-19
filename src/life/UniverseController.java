package life;

public class UniverseController {
    Universe universe;
    GameOfLife view;

    public UniverseController(Universe universe, GameOfLife view) {
        this.universe = universe;
        this.view = view;
    }

    public void createUniverse() {
        universe.resetRandom();
        for (int i = 0; i < universe.getBooleanArrays().length; i++) {
            for (int j = 0; j < universe.getBooleanArrays()[i].length; j++) {
                universe.getBooleanArrays()[i][j] = false;
            }
        }

        for (int i = 0; i < universe.getBooleanArrays().length; i++) {
            for (int j = 0; j < universe.getBooleanArrays()[i].length; j++) {
                universe.getBooleanArrays()[i][j] = universe.getRandom().nextBoolean();
            }
        }
        universe.setGeneration(0);
    }

    public void nextGeneration() {
        Generator.generate(universe.getBooleanArrays());
        universe.setGeneration(universe.getGeneration() + 1);
    }

    public int aliveCells() {
        int alive = 0;
        for (int i = 0; i < universe.getBooleanArrays().length; i++) {
            for (int j = 0; j < universe.getBooleanArrays().length; j++) {
                if (universe.getBooleanArrays()[i][j]) {
                    alive++;
                }
            }
        }
        return alive;
    }

    public void togglePause() {
        universe.setPaused(!universe.isPaused());
    }

    public void setPaused() {
        universe.setPaused(true);
    }

    public void setUnpaused() {
        universe.setPaused(false);
    }

}
