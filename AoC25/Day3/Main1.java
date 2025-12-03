import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main1 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int output = 0;
            for (String line : br.lines().toList()) {

                System.out.println(line);

                int joltage = -1;

                int n = line.length();
                for (int i = 0; i < n - 1; i++) {
                    int first = line.charAt(i) - '0';
                    for (int j = i + 1; j < n; j++) {
                        int second = line.charAt(j) - '0';
                        int value = first * 10 + second;

                        if (value > joltage) {
                            joltage = value;
                        }
                    }
                }
                
                output += joltage;
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
