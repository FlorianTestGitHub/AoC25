import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main1 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            List<long[]> ranges = new ArrayList<>();
            List<Long> ids = new ArrayList<>();
            long output = 0;

            String line;
            boolean secondPart = false;

            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) {
                    secondPart = true;
                    continue;
                }

                if (!secondPart) {
                    String[] parts = line.split("-");
                    long start = Long.parseLong(parts[0]);
                    long end = Long.parseLong(parts[1]);
                    ranges.add(new long[]{start, end});

                } else {
                    ids.add(Long.parseLong(line));
                }
            }

            for (long id : ids) {
                if (isInAnyRange(id, ranges)) {
                    output++;
                }
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isInAnyRange(long id, List<long[]> ranges) {
        for (long[] r : ranges) {
            if (id >= r[0] && id <= r[1]) {
                return true;
            }
        }
        return false;
    }
}
