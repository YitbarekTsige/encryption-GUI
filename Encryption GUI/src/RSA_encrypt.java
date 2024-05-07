import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class RSA_encrypt {
    public static int getGCD(int mod, int num) {
        if (mod == 0)
            return num;
        else
            return getGCD(num % mod, mod);
    }
    public static String main(String ConvertMessage, int p, int q) {
        // , int a, int b
       // String ConvertMessage = null;
        Scanner sc = new Scanner(System.in);
        int d = 0, e;
        BigInteger message;
        //int p = 53;
        //int q = 59;
        int n = p * q;
        int s = (p - 1) * (q - 1);
        System.out.println(ConvertMessage);
        System.out.println("Enter plaintext:");
        //String ConvertMessage = sc.nextLine();
        int messageLength = (ConvertMessage.length());
        System.out.println("LENGTH: " + messageLength);
        int Num[] = new int[messageLength];

        String out = "";
        System.out.print("plain text to number(message):\t");
        for (int i = 0; i < messageLength; i++)
        {
            char ch = ConvertMessage.toUpperCase().charAt(i);
            System.out.print("");
            Num[i] = (int)ch-'A';
            System.out.print((int)ch-'A');
            System.out.print("");
             out = out.concat(String.valueOf((ch-'A')));
        }

        message = new BigInteger(out);
        System.out.println("\n"+ message);
        System.out.println("\nprime number, p = " + p);
        System.out.println("primr number, q = " + q);
        System.out.println(" Φ(n) = " + s + "\n");

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
        RSAGUI.passer(e, d, s, out);
        return displayEncrypt(Num, n, e, messageLength);

    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static int generatePrimeNumber() {
        Random random = new Random();
        int finall = 0;

        while(true)
        {
            int primeNum = random.nextInt(100) + 1;
            if(isPrime(primeNum))
            {
                finall = primeNum;
                break;
            }

        }
            return finall;
    }




    public static String displayEncrypt(int message[], int n, int e, int z)
    {
        StringBuilder DB = new StringBuilder();
        for (int i = 0; i < z; i++) {
            int cipher = (int) ((Math.pow(message[i], e)) % n);
            //double cipher = (Math.pow(message, e)) % n;
            DB.append(cipher);
            DB.append(" ");
        }
        System.out.println("Cipher text: " + DB);
        return DB.toString();
    }




}
