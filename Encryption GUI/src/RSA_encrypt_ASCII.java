import java.math.BigInteger;
import java.util.Scanner;

public class RSA_encrypt_ASCII {


    public static int getGCD(int mod, int num) {
        if (mod == 0)
            return num;
        else
            return getGCD(num % mod, mod);
    }

    public static String main(String ConvertMessage, int p, int q) {

        Scanner sc = new Scanner(System.in);
        int d = 0, e = 0;
        int[] message;
        //int p = 53;
        //int q = 59;
        int n = p * q;
        int s = (p - 1) * (q - 1);
        System.out.println("Enter plaintext:");
        //String ConvertMessage = sc.nextLine();
        int i = (ConvertMessage.length());
        System.out.println("LENGTH: " + i);
        int ASCII_val[] = new int[i];


        System.out.println("plain text to number(message):\t");
        message = convertToASCII(ConvertMessage, i);


        //System.out.print("plain text to number(message): " + message);
        System.out.println("\nprime number, p = " + p);
        System.out.println("primr number, q = " + q);
        System.out.println(" Φ(n) = " + s + "\n");

        //int s_int = 0;
        // int e_int = 0;

        /*    try {
                s_int = s.intValueExact();
                //e_int = e.intValueExact();
                System.out.println("Converted value to int: ");
            } catch (ArithmeticException exception) {
                System.out.println("BigInteger value is too large to fit into an int.");
            } */

        for (e = 2; e < s; e++) {
            if (getGCD(e, s) == 1) {
                break;
            }
        }
        System.out.println("Public key e = " + e);

        for (int m = 0; m <= 9; m++) {
            int temp = 1 + (m * s);
            if (temp % e == 0) {
                d = temp / e;
                break;
            }
        }
        System.out.println("private key, d = " + d);
        //BigInteger e_bint = new BigInteger(String.valueOf(e));
        RSAGUI.passer(e, d, s,message.toString());
        return displayEncrypt(message, n, e, i);

    }

    public static int[] convertToASCII(String message, int length) {
        StringBuilder sb = new StringBuilder();
        int[] ASCII_val = new int[length];
        char[] charArray = message.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int c = charArray[i];
            System.out.print(c);
            System.out.print(" ");
            ASCII_val[i] = c;
            sb.append(c);
        }
        //send(ASCII_val);
        return ASCII_val;
    }
    

    public static String displayEncrypt(int[] message, int n, int e, int length) {
        StringBuilder DB = new StringBuilder();
        for (int i = 0; i < length; i++) {
            // BigInteger cipher = message[i].modPow(e, n);
            int cipher = (int) ((Math.pow(message[i], e)) % n);
            DB.append(cipher);
            DB.append(" ");
        }
        System.out.println("Cipher text: " + DB);


return DB.toString();
    }

}

