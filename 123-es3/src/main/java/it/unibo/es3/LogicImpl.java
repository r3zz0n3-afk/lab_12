package it.unibo.es3;

import java.util.Arrays;
import java.util.Set;

public class LogicImpl implements Logics{
    private String[][] grid;

    public LogicImpl(final int size, final Set<Pair<Integer,Integer>> picks) {
        grid = new String[size][size];
        setUp(picks);
    }

    private void setUp(final Set<Pair<Integer,Integer>> picks) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = " ";
            }
        }
        for (final Pair<Integer, Integer> p : picks) {
            int x = p.x().intValue();
            int y = p.y().intValue();
            grid[x][y] = "*";
        }
    }
    
    private boolean haVicini(final int row, final int col) {
        int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < dc.length; i++) {
            int rowNear = row + dr[i];
            int colNear = col + dc[i];
            if (rowNear >= 0 && rowNear < grid.length && colNear >= 0 && colNear < grid.length) {
                if (grid[rowNear][colNear].equals("*")) {
                    return true;
                }
            } 
        }
        return false;
    }

    @Override
    public void expand() {
        String[][] buckup = new String[grid.length][grid.length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j].equals("*")) {
                    buckup[i][j] = "*";
                } else if (grid[i][j].isBlank()) {
                    if (haVicini(i, j)) {
                       buckup[i][j] = "*";
                    } else {
                        buckup[i][j] = " ";
                    }
                }
            }
        }
        this.grid = buckup;
    }

    @Override
    public String getCell (final Pair<Integer, Integer> p) {
        int x = p.x().intValue();
        int y = p.y().intValue();
        return grid[x][y];
    }

    /**
     *  Use for control if the grid si full of *.
     * 
     * @return if the grid is full of *
     */
    @Override
    public boolean toQuit() {
        // Controlla se la griglia è tutta *
        return Arrays.stream(grid)
            .flatMap(Arrays::stream)
            .allMatch(c -> c.equals("*"));
        
    }
}
