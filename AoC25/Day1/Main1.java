import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main1 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            int output = 0;
            int lock = 50;
            for (String line : br.lines().toList()) {

                String rotationDirection = line.substring(0, 1);
                int rotationNumber = Integer.parseInt(line.substring(1));

                if (rotationDirection.equals("R")) {
                    for (int i = 0; i < rotationNumber; i++) {
                        lock++;
                        if (lock == 100) {
                            lock = 0;
                        }
                    }  
                } else {
                    for (int i = 0; i < rotationNumber; i++) {
                        lock--;
                        if (lock == -1) {
                            lock = 99;
                        }
                    } 
                }
                if (lock == 0) {
                    output++;
                }
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
