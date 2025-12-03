import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main1 {
    
    public static void main (String[] args) {

        ArrayList<Long> invalidIds = new ArrayList<Long>();
        long output = 0;
        
        try {
            //BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            
            for (String line : br.lines().toList()) {

                for (String range : line.split(",")) {
                    String[] parts = range.split("-");
                    long start = Long.parseLong(parts[0]);
                    long end   = Long.parseLong(parts[1]);

                    for (long id = start; id <= end; id++) {
                        if (isRepeatedTwice(id)) {
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

    private static boolean isRepeatedTwice(long number) {
        String s = Long.toString(number);

        if (s.length() % 2 != 0) return false;

        int half = s.length() / 2;
        String first = s.substring(0, half);
        String second = s.substring(half);

        return first.equals(second);
    }
}
