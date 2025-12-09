package it.unibo.es2;

public class LogicsImpl implements Logics {

    private String[][] grid;

    public LogicsImpl(final int size) {
        grid = new String[size][size];
        setUp();
    }

    private void setUp() {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                grid[i][j] = " ";
            }
        }
    }

    @Override
    public String hit(Pair<Integer, Integer> elem) {
        int x = elem.x().intValue();
        int y = elem.y().intValue();
        if(grid[x][y] == " " ) {
            grid[x][y] = "*";
        } else {
            grid[x][y] = " ";
        }

        return grid[x][y] ;
    }

    @Override
    public boolean toQuit() {
        // Controlla se una riga è tutta *
        for (int i = 0; i < grid.length; i++) {
            boolean rowAllStars = true;
            for (int j = 0; j < grid.length; j++) {
                if (!grid[i][j].equals("*")) {
                    rowAllStars = false;
                    break;
                }
            }
            if (rowAllStars) {
                return true;
            }
        }
        
        // Controlla se una colonna è tutta *
        for (int j = 0; j < grid.length; j++) {
            boolean colAllStars = true;
            for (int i = 0; i < grid.length; i++) {
                if (!grid[i][j].equals("*")) {
                    colAllStars = false;
                    break;
                }
            }
            if (colAllStars) {
                return true;
            }
        }
        
        return false;
    }
}
