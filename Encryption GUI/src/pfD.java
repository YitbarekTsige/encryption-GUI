import java.awt.*;
import java.util.Scanner;

public class pfD {

        public int length = 0;
        public static String[][] table;


        public pfD() {

            System.out.print("Enter key: ");
            Scanner sc = new Scanner(System.in);
            //String key = parseString(sc);
            //table = this.cipherTable(key);
            System.out.print("Enter cipher text to decrypt: ");
            //String input = parseString(sc);
            //String decodedOutput = decode(input);
            this.keyTable(table);
            //this.decryptDisplay(decodedOutput);
        }


        public static String[][] cipherTable(String key)
        {

            String[][] playfairTable = new String[5][5];
            String keyString = key + "ABCDEFGHIKLMNOPQRSTUVWXYZ";
            for(int i = 0; i < 5; i++)
                for(int j = 0; j < 5; j++)
                    playfairTable[i][j] = "";
            for(int k = 0; k < keyString.length(); k++)
            {
                boolean repeat = false;
                boolean used = false;
                for(int i = 0; i < 5; i++)
                {
                    for(int j = 0; j < 5; j++)
                    {
                        if(playfairTable[i][j].equals("" + keyString.charAt(k)))
                        {
                            repeat = true;
                        }
                        else if(playfairTable[i][j].equals("") && !repeat && !used)
                        {
                            playfairTable[i][j] = "" + keyString.charAt(k);
                            used = true;
                        }
                    }
                }
            }
            return playfairTable;
        }
        public void decryptDisplay(String decrypt)
        {
            System.out.print("Decrypted text: ");
            System.out.println(decrypt);
        }


        public static String decode(String out)
        {
            String decoded = "";
            for(int i = 0; i < out.length() / 2; i++)
            {
                char a = out.charAt(2*i);
                char b = out.charAt(2*i+1);
                int r1 = (int) getPoint(a).getX();
                int r2 = (int) getPoint(b).getX();
                int c1 = (int) getPoint(a).getY();
                int c2 = (int) getPoint(b).getY();
                if(r1 == r2)
                {
                    c1 = (c1 + 4) % 5;
                    c2 = (c2 + 4) % 5;
                }
                else if(c1 == c2)
                {
                    r1 = (r1 + 4) % 5;
                    r2 = (r2 + 4) % 5;
                }
                else
                {
                    int temp = c1;
                    c1 = c2;
                    c2 = temp;
                }
                decoded = decoded + table[r1][c1] + table[r2][c2];
            }
            return decoded;
        }

        public void keyTable(String[][] printTable)
        {
            System.out.println("Playfair Cipher Key Matrix: ");
            System.out.println();
            for(int i = 0; i < 5; i++)
            {
                for(int j = 0; j < 5; j++)
                {
                    System.out.print("" + printTable[i][j]);
                }
                System.out.println();
            }
            System.out.println();
        }


        static String parseString(String parse)
        {
            parse = parse.toUpperCase();
            parse = parse.replaceAll("[^A-Z]", "");
            parse = parse.replace("J", "I");
            return parse;
        }


        public static Point getPoint(char c)
        {
            Point pt = new Point(0,0);
            for(int i = 0; i < 5; i++)
                for(int j = 0; j < 5; j++)
                    if(c == table[i][j].charAt(0))
                        pt = new Point(i,j);
            return pt;
        }

    }

