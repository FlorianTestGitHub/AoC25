import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Main2 {
    
    public static void main (String[] args) {
        
        try {
            BufferedReader br = new BufferedReader(new FileReader("Input.txt"));
            //BufferedReader br = new BufferedReader(new FileReader("InputTest.txt"));
            long output = 0;
            for (String line : br.lines().toList()) {

                String result = maxSubsequence(line, 12);

                long voltage = Long.parseLong(result);
                output += voltage;
            }
            System.out.println(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String maxSubsequence(String s, int k) {
        int n = s.length();
        int toRemove = n - k;

        StringBuilder stack = new StringBuilder();

        for (char c : s.toCharArray()) {
            while (stack.length() > 0 &&
                   stack.charAt(stack.length() - 1) < c &&
                   toRemove > 0) {
                stack.deleteCharAt(stack.length() - 1);
                toRemove--;
            }
            stack.append(c);
        }

        return stack.substring(0, k);
    }
}
