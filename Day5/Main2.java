import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main2 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));

            List<long[]> ranges = new ArrayList<>();
            long output = 0;

            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.isEmpty()) continue;

                if (!line.contains("-")) {
                    continue;
                }

                String[] parts = line.split("-");

                if (parts.length != 2) {
                    continue;
                }

                long start = Long.parseLong(parts[0]);
                long end   = Long.parseLong(parts[1]);
                ranges.add(new long[]{start, end});
            }
            br.close();

            ranges.sort(Comparator.comparingLong(a -> a[0]));

            List<long[]> merged = new ArrayList<>();

            long currentStart = ranges.get(0)[0];
            long currentEnd   = ranges.get(0)[1];

            for (int i = 1; i < ranges.size(); i++) {
                long s = ranges.get(i)[0];
                long e = ranges.get(i)[1];

                if (s <= currentEnd + 1) {
                    currentEnd = Math.max(currentEnd, e);
                } else {
                    merged.add(new long[]{currentStart, currentEnd});
                    currentStart = s;
                    currentEnd = e;
                }
            }

            merged.add(new long[]{currentStart, currentEnd});

            for (long[] r : merged) {
                output += (r[1] - r[0] + 1);
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
