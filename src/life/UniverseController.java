package life;

public class UniverseController {
    UniverseModel universeModel;
    UniverseView view;

    public UniverseController(UniverseModel universeModel, UniverseView view) {
        this.universeModel = universeModel;
        this.view = view;
    }

    public void createUniverse() {
        universeModel.resetRandom();
        for (int i = 0; i < universeModel.getBooleanArrays().length; i++) {
            for (int j = 0; j < universeModel.getBooleanArrays()[i].length; j++) {
                universeModel.getBooleanArrays()[i][j] = false;
            }
        }

        for (int i = 0; i < universeModel.getBooleanArrays().length; i++) {
            for (int j = 0; j < universeModel.getBooleanArrays()[i].length; j++) {
                universeModel.getBooleanArrays()[i][j] = universeModel.getRandom().nextBoolean();
            }
        }

        universeModel.setGeneration(0);
    }

    public void nextGeneration() {
        Generator.generate(universeModel.getBooleanArrays());
        universeModel.setGeneration(universeModel.getGeneration() + 1);
    }

    public int aliveCells() {
        int alive = 0;

        for (int i = 0; i < universeModel.getBooleanArrays().length; i++) {
            for (int j = 0; j < universeModel.getBooleanArrays().length; j++) {
                if (universeModel.getBooleanArrays()[i][j]) {
                    alive++;
                }
            }
        }

        return alive;
    }

    public void togglePause() {
        universeModel.setPaused(!universeModel.isPaused());
    }

    public void setPaused() {
        universeModel.setPaused(true);
    }

    public void setUnpaused() {
        universeModel.setPaused(false);
    }

}
