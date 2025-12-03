import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main2 {
    
    public static void main (String[] args) {

        ArrayList<Long> invalidIds = new ArrayList<Long>();
        long output = 0;
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            
            for (String line : br.lines().toList()) {

                for (String range : line.split(",")) {
                    String[] parts = range.split("-");
                    long start = Long.parseLong(parts[0]);
                    long end   = Long.parseLong(parts[1]);

                    for (long id = start; id <= end; id++) {
                        if (isRepeatedPattern(id)) {
                            invalidIds.add(id);
                            output += id;
                        }
                    }
                }
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean isRepeatedPattern(long number) {
        String s = Long.toString(number);
        int len = s.length();

        for (int blockLen = 1; blockLen <= len / 2; blockLen++) {

            if (len % blockLen != 0) continue;

            String block = s.substring(0, blockLen);

            if (block.charAt(0) == '0') continue;

            int repeats = len / blockLen;

            if (repeats < 2) continue;

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < repeats; i++) {
                sb.append(block);
            }

            if (sb.toString().equals(s)) {
                return true;
            }
        }
        return false;
    }
}
