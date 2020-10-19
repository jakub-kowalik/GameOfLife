package life;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GameOfLife extends JFrame {

    UniverseController universeController;
    JPanel universeView = new JPanel();
    JLabel generationLabel = new JLabel("", SwingConstants.LEFT);
    JLabel aliveLabel = new JLabel("", SwingConstants.LEFT);
    JToggleButton playButton = new JToggleButton();
    JButton resetButton = new JButton();

    public GameOfLife() {
        super("Game of Life");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setResizable(false);
        setLayout(null);
        setBackground(Color.LIGHT_GRAY);

        generationLabel.setName("GenerationLabel");
        generationLabel.setBounds(10, 5, 150, 20);
        generationLabel.setFont(generationLabel.getFont().deriveFont(16.0f));
        generationLabel.setText("Generation #0");
        add(generationLabel);

        aliveLabel.setName("AliveLabel");
        aliveLabel.setBounds(10, 25, 150, 20);
        aliveLabel.setFont(aliveLabel.getFont().deriveFont(16.0f));
        aliveLabel.setText("Alive: 0");
        add(aliveLabel);

        playButton.setName("PlayToggleButton");
        playButton.setBounds(25, 500, 75, 50);
        playButton.setText("Play");
        playButton.addActionListener(actionEvent -> {
            if (playButton.isSelected()) {
                universeController.setPaused();
                playButton.setText("Pause");
            } else {
                universeController.setUnpaused();
                playButton.setText("Play");
            }
        });
        add(playButton);

        resetButton.setName("ResetButton");
        resetButton.setBounds(125, 500, 75, 50);
        resetButton.setText("Reset");
        resetButton.addActionListener(actionEvent -> {
            universeController.createUniverse();
            universeController.nextGeneration();
        });
        add(resetButton);

        universeView.setBounds(230, 5, 550, 550);
        add(universeView);
        setVisible(true);

    }

    public void repaintUniverse(boolean[][] booleans) {
        universeView.removeAll();
        universeView.setLayout(new GridLayout(booleans.length, booleans.length));
        universeView.setBounds(230, 5, 550, 550);
        for (int i = 0; i < booleans.length; i++) {
            for (int j = 0; j < booleans.length; j++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                if (booleans[i][j]) {
                    cell.setBackground(Color.BLACK);
                } else {
                    cell.setBackground(new Color(255, 255, 255, 0));
                }
                universeView.add(cell);
            }
        }
        universeView.revalidate();
        universeView.repaint();
    }

    public void setUniverseController(UniverseController universeController) {
        this.universeController = universeController;
    }
}



