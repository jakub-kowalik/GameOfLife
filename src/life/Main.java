package life;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int universeSize = 50;

        UniverseView universeView = new UniverseView();
        UniverseModel universeModel = new UniverseModel(universeSize);
        UniverseController universeController = new UniverseController(universeModel, universeView);

        universeView.setUniverseController(universeController);

        universeController.createUniverse();

        while (true) {
            if (!universeModel.isPaused()) {
                universeController.nextGeneration();
            }

            universeController.view.repaintUniverse(universeModel.getBooleanArrays());
            universeController.view.generationLabel.setText("Generation #" + universeModel.getGeneration());
            universeController.view.aliveLabel.setText("Alive: " + universeController.aliveCells());
            //printUniverse(universe, i, universeController.aliveCells());
            Thread.sleep(1000);
        }
    }

    public static void printUniverse(UniverseModel universeModel, int generation, int aliveCells) {
        clearConsole();
        System.out.println("Generation #" + generation);
        System.out.println("Alive: " + aliveCells);
        System.out.println(universeModel);
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
