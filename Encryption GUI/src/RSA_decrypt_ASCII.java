import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RSA_decrypt_ASCII {

    public static int getGCD(int mod, int num) {
        if (mod == 0)
            return num;
        else
            return getGCD(num % mod, mod);
    }
    public static String[] main(String ConvertMessage, int p, int q) {
        Scanner sc = new Scanner(System.in);
        int d = 0, e;
       // int p = 53;
       // int q = 59;
        int n = p * q;
        int s = (p - 1) * (q - 1);
        //int num =5;
        BigInteger message[] = countOccurrences(ConvertMessage);
        for(int i=0; i<2; i++)
        {
            System.out.println(message[i]);
        }


        System.out.println("\nprime number, p = " + p);
        System.out.println("prime number, q = " + q);
        System.out.println("Φ(n) =  : " + s + "\n");
        for (e = 2; e < s; e++) {
            if (getGCD(e, s) == 1) {
                break;
            }
        }
        System.out.println("Public key, e = " + e);

        for (int m = 0; m <= 9; m++) {
            int temp = 1 + (m * s);
            if (temp % e == 0) {
                d = temp / e;
                break;
            }
        }
        System.out.println("private key, d = "  +d);
        RSAGUI.passer(e, d,s, message.toString());
        return displayDecrypt(message, n, d, length(ConvertMessage));
    }


    public static String convertFromASCII(BigInteger asciiValue) {

        int asciiCode = Integer.parseInt(asciiValue.toString());
        char character = (char) asciiCode;

        return String.valueOf(character);
    }


    public static String[] displayDecrypt(BigInteger cipher[], int n, int d, int p)
    {
        StringBuilder DB = new StringBuilder();
        StringBuilder DS = new StringBuilder();
        BigInteger d_message;
        BigInteger bigN = BigInteger.valueOf(n);
        BigInteger bigD = BigInteger.valueOf(d);
        for(int i =0; i<p; i++)
        {
            d_message = cipher[i].modPow(bigD, bigN);
            String message = convertFromASCII(d_message);
            DB.append(d_message);
            DB.append(" ");
            DS.append(message);


        }
        System.out.println("Decrypted ASCII: " + DB);
        System.out.println("Decrypted text: " + DS);
        String results[] = new String[2];
        results[0] = DB.toString();
        results[1] = DS.toString();
        return results;

    }
    public static BigInteger[] countOccurrences(String commaSeparatedString) {
        if (commaSeparatedString.isEmpty()) {
            return new BigInteger[0]; // Empty array for empty string
        }

        //Map<Integer, Integer> counts = new HashMap<>();
        String[] numbers = commaSeparatedString.split(",");
        BigInteger[] g = new BigInteger[numbers.length];

        for(int i = 0; i < numbers.length; ++i) {
            try {
                g[i] = BigInteger.valueOf(Integer.parseInt(numbers[i]));
            } catch (NumberFormatException var5) {
                throw new IllegalArgumentException("Input string contains non-numeric characters");
            }
        }


        return g;
    }


    public static int length(String commaSeparatedString) {
        if (commaSeparatedString.isEmpty()) {
            return 0; // Empty array for empty string
        }

        Map<BigInteger, BigInteger> counts = new HashMap<>();

        String[] numbers = commaSeparatedString.split(",");

        for (String numberStr : numbers) {
            int number;
            try {
                number = Integer.parseInt(numberStr.trim()); // Remove leading/trailing whitespaces before parsing
            } catch (NumberFormatException e) {
                System.out.println("Invalid integer format: " + numberStr);
                continue; // Skip invalid entries
            }

            counts.put(BigInteger.valueOf(number), counts.getOrDefault(number, BigInteger.valueOf(0)));
        }

        int uniqueNumbers = counts.size();
        // System.out.println(uniqueNumbers);

        return uniqueNumbers;
    }


}

