import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main2 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            List<String> lines = new ArrayList<>();

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            br.close();

            int rows = lines.size();
            int cols = lines.get(0).length();

            char[][] grid = new char[rows][cols];

            for (int r = 0; r < rows; r++) {
                grid[r] = lines.get(r).toCharArray();
            }

            int totalRemoved = 0;
            boolean changed;

            do {
                changed = false;
                List<int[]> toRemove = new ArrayList<>();

                for (int r = 0; r < rows; r++) {
                    for (int c = 0; c < cols; c++) {
                        if (grid[r][c] == '@') {
                            int neighbors = countNeighborAt(grid, r, c);
                            if (neighbors < 4) {
                                toRemove.add(new int[]{r, c});
                            }
                        }
                    }
                }

                if (!toRemove.isEmpty()) {
                    changed = true;
                    totalRemoved += toRemove.size();

                    for (int[] pos : toRemove) {
                        grid[pos[0]][pos[1]] = 'x';
                    }
                }

            } while (changed);

            System.out.println(totalRemoved);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static int countNeighborAt(char[][] grid, int r, int c) {
        int count = 0;

        int[] dirs = {-1, 0, 1};

        for (int dr : dirs) {
            for (int dc : dirs) {
                if (dr == 0 && dc == 0) continue;

                int nr = r + dr;
                int nc = c + dc;

                if (nr >= 0 && nr < grid.length &&
                    nc >= 0 && nc < grid[0].length &&
                    grid[nr][nc] == '@') {

                    count++;
                }
            }
        }
        return count;
    }
}
