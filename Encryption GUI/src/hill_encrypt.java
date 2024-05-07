import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;

public class hill_encrypt {



    public static StringBuilder displayHill(ArrayList<Integer> phrase) {
        int i;
        StringBuilder DS = new StringBuilder();
        for (i = 0; i < phrase.size(); i += 2) {
            System.out.print(Character.toChars(phrase.get(i) + (65)));
            DS.append(Character.toChars(phrase.get(i) + (65)));
            System.out.print(Character.toChars(phrase.get(i + 1) + (65)));
            DS.append(Character.toChars(phrase.get(i+1) + (65)));
        }
        return DS;
    }

    public static ArrayList<Integer> encrypt(String phrase,int[][] keyMatrix) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> phraseToNum = new ArrayList<>();
        ArrayList<Integer> phraseEncoded = new ArrayList<>();
        phrase = phrase.replaceAll("[^a-zA-Z]", "").toUpperCase();

        if (phrase.length() % 2 == 1) {
            phrase += "X";
        }
        //keyMatrix = hill_matrix.getKeyMatrix();
        hill_matrix.isValidMatrix(keyMatrix);
        for (int i = 0; i < phrase.length(); i++) {
            phraseToNum.add(phrase.charAt(i) - (65));
        }
        for (int i = 0; i < phraseToNum.size(); i += 2) {
            int x = (keyMatrix[0][0] * phraseToNum.get(i) + keyMatrix[0][1] * phraseToNum.get(i + 1)) % 26;
            int y = (keyMatrix[1][0] * phraseToNum.get(i) + keyMatrix[1][1] * phraseToNum.get(i + 1)) % 26;
            phraseEncoded.add(x);
            phraseEncoded.add(y);
        }
        System.out.println("Key Matrix: ");
        System.out.println(keyMatrix[0][0] + "\t" + keyMatrix[0][1] + "\n" + keyMatrix[1][0] + "\t" + keyMatrix[1][1]);

        //displayHill("Cipher text: ", phraseEncoded);
        return phraseEncoded;

    }

    public static String recommend(int count) {
        Random random = new Random();
        int bound = 10;

        String s = null;
        while (count < 7) {
            // Choose relatively prime positive integers for diagonal elements
            int a = random.nextInt(2, bound) + 1;
            int b = random.nextInt(2, bound) + 1;
            while (!isPrimeFactors(a, b)) {
                a = random.nextInt(2, bound) + 1;
                b = random.nextInt(2, bound) + 1;
            }

            int c = random.nextInt(0, bound);
            int d = random.nextInt(0, bound);

            int det = (a * d) - (b * c);

            if (det == 1) {
                s = a + "," + c + "," + b + "," + d;
                count++;
            }
        }
        return s;
    }
            // function to check if two numbers are relatively prime
   public static boolean isPrimeFactors ( int a, int b)
   {
       while (b != 0)
       {
           int temp = a % b;
           a = b;
           b = temp;
       }
       return a == 1;
   }
}




