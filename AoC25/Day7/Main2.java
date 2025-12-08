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
            for (int i = 0; i < rows; i++) {
                grid[i] = lines.get(i).toCharArray();
            }

            long[][] beams = new long[rows][cols];

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 'S') {
                        beams[r][c] = 1;
                    }
                }
            }

            for (int r = 0; r < rows - 1; r++) {
                for (int c = 0; c < cols; c++) {
                    if (beams[r][c] > 0) {
                        if (grid[r + 1][c] == '.') {
                            beams[r + 1][c] += beams[r][c];
                        } else if (grid[r + 1][c] == '^') {
                            if (c - 1 >= 0) beams[r + 1][c - 1] += beams[r][c];
                            if (c + 1 < cols) beams[r + 1][c + 1] += beams[r][c];
                        }
                    }
                }
            }

            char[][] visual = new char[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == '^' || grid[r][c] == 'S') {
                        visual[r][c] = grid[r][c];
                    } else if (beams[r][c] > 0) {
                        visual[r][c] = '|';
                    } else {
                        visual[r][c] = '.';
                    }
                }
            }

            long output = 0;
            for (int c = 0; c < cols; c++) {
                output += beams[rows - 1][c];
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
