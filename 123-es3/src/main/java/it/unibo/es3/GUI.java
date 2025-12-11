package it.unibo.es3;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.Serial;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * GUI for the game.
 */
public final class GUI extends JFrame {

    @Serial
    private static final long serialVersionUID = 1L;
    private final Map<Pair<Integer,Integer>, JButton> cells = new HashMap<>();
    private final Logics logics;
    private Random rnd = new Random();
    /**
     * Constructor.
     *
     * @param width the size of the grid
     */
    public GUI(final int width) {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Create a panel with a grid layout
        final JPanel panel = new JPanel(new BorderLayout());
        final JPanel grid = new JPanel(new GridLayout(width, width));
        this.getContentPane().add(panel);
        // Create buttons and add them to the panel
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                final var pos = new Pair<>(j, i);
                final JButton button = new JButton(" ");
                this.cells.put(pos, button);
                //button.addActionListener(e -> button.setText(logics.hit(pos)));
                grid.add(button);
            }
        }
        // Mark three distinct random cells with "*" 
        final Set<Pair<Integer, Integer>> picks = new HashSet<>();
        while (picks.size() < 3 ) {
            final int x = this.rnd.nextInt(width);
            final int y = this.rnd.nextInt(width);
            picks.add(new Pair<>(x, y));
        }
        for (final Pair<Integer, Integer> p : picks) {
            this.cells.get(p).setText("*");  
        }
        
        this.logics = new LogicImpl(width, picks);
        final JButton exspantionButton = new JButton(">");
        exspantionButton.addActionListener(e -> {
            this.logics.expand();
            for (final Pair<Integer, Integer> p : cells.keySet()) {
                cells.get(p).setText(this.logics.getCell(p));
            }
            if (logics.toQuit()) {
                dispose();
            }
        });
        panel.add(exspantionButton, BorderLayout.SOUTH);
        panel.add(grid, BorderLayout.AFTER_LINE_ENDS);
        pack();
        this.setVisible(true);
    }


}
