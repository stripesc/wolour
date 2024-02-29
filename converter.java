import javax.swing.*;
import java.util.*;

public class converter {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String contS, output, wordToConvert;
        wolourUI frame = new wolourUI();
        SwingUtilities.invokeLater((Runnable) frame);
        boolean cont = true;
        while (cont){
            System.out.println("Input word to text");
            wordToConvert = input.nextLine();
            output = convert(wordToConvert);
            System.out.println(output);
            System.out.println("Go again? Y/N");
            contS = input.nextLine().toUpperCase();
            if (contS.equals("N")){
                cont = false;
            }
        }
        System.out.println("Goodbye");
        System.exit(0);

    }

    public static String convert(String word) {
        String output = "";
        word = word.toLowerCase();
        String[] letters = new String[3];
        int[] values = new int[]{0,0,0};
        int third = 0, sections = 0;
        if (word.length() >= 3){
            word = word.substring(0, word.length() - (word.length()%3));
            third = word.length()/3;
            sections = 3;
            letters[0] = word.substring(0, third);
            letters[1] = word.substring(third, third*2);
            letters[2] = word.substring(third*2);
        }
        else if (word.length() == 2) {
            third = 1;
            sections = 2;
            letters[0] = word.substring(0,1);
            letters[1] = word.substring(1);
            letters[2] = "";
        }
        else if (word.length() == 1) {
            third = 1;
            sections = 1;
            letters[0] = word;
            letters[1] = "";
            letters[2] = "";
        }
        for (int i = 0; i < sections; i++){
            for (int j = 0; j < third; j++){
                values[i] += letters[i].charAt(j);
//                System.out.println("|" + letters[i].charAt(j) + " : " + (int) letters[i].charAt(j)); // TESTING
            }
//            System.out.println("|" + letters[i] + " : " + values[i]); // TESTING
//            System.out.println("|--:----"); // TESTING
        }
        for (int i = 0; i < 3; i++){
            values[i] = values[i]%256;
            if (values[i] < 16){
                output += "0";
            }
            output += Integer.toHexString(values[i]);
        }
//        System.out.println("After Trimming: " + word); // TESTING
//        System.out.println("After Dividing: " + letters[0] + " | " + letters[1] + " | " + letters[2]); // TESTING
//        System.out.println("After Converting, adding, and modulo: " + values[0] + " | " + values[1] + " | " + values[2]); // TESTING
//        System.out.println("After to hex: " + Integer.toHexString(values[0]) + " | " + Integer.toHexString(values[1]) + " | " + Integer.toHexString(values[2])); // TESTING
//        System.out.println("After Concat and adding #: " + "#"+output); // TESTING
        return "#"+output;
    }
}
