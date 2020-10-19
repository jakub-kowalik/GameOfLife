package life;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        int universeSize = 50;

        GameOfLife gameOfLife = new GameOfLife();
        Universe universe = new Universe(universeSize);
        UniverseController universeController = new UniverseController(universe, gameOfLife);

        gameOfLife.setUniverseController(universeController);

        universeController.createUniverse();

        while (true) {
            if (!universe.isPaused()) {
                universeController.nextGeneration();

            }

            universeController.view.repaintUniverse(universe.getBooleanArrays());
            universeController.view.generationLabel.setText("Generation #" + universe.getGeneration());
            universeController.view.aliveLabel.setText("Alive: " + universeController.aliveCells());
            //printUniverse(universe, i, universeController.aliveCells());
            Thread.sleep(1000);

        }
    }

    public static void printUniverse(Universe universe, int generation, int aliveCells) {
        clearConsole();
        System.out.println("Generation #" + generation);
        System.out.println("Alive: " + aliveCells);
        System.out.println(universe);
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
