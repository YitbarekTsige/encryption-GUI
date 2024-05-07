import java.awt.*;

public class pfE {

        public static int length = 0;
        public static String[][] table;

        public pfE(String input1, String input2) {
            System.out.print("Enter key: ");
            //Scanner sc = new Scanner(System.in);
            String key = parseString(input1);
            //table = this.cipherTable(key);
            System.out.print("Enter the plaintext to encrypt: ");
            String input = parseString(input2);

            String output = cipher(input);
            this.keyTable(table);
            this.encryptDisplay(output);
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

        public void encryptDisplay(String encrypt)
        {
            System.out.print("Encrypted text: ");
            System.out.println(encrypt);

        }


        static String cipher(String in)
        {
            length = in.length() / 2 + in.length() % 2;

            for(int i = 0; i < (length - 1); i++)
            {
                if(in.charAt(2 * i) == in.charAt(2 * i + 1))
                {
                    in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                    length = (int) in.length() / 2 + in.length() % 2;
                }
            }

            String[] digraph = new String[length];
            for(int j = 0; j < length ; j++)
            {
                if(j == (length - 1) && in.length() / 2 == (length - 1))
                    in = in + "X";
                digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
            }

            String out = "";
            String[] encDigraphs = new String[length];
            encDigraphs = encodeDigraph(digraph);
            for(int k = 0; k < length; k++)
                out = out + encDigraphs[k];
            return out;
        }


        public static String[] encodeDigraph(String di[])
        {
            String[] encipher = new String[length];
            for(int i = 0; i < length; i++)
            {
                char a = di[i].charAt(0);
                char b = di[i].charAt(1);
                int r1 = (int) getPoint(a).getX();
                int r2 = (int) getPoint(b).getX();
                int c1 = (int) getPoint(a).getY();
                int c2 = (int) getPoint(b).getY();
                if(r1 == r2)
                {
                    c1 = (c1 + 1) % 5;
                    c2 = (c2 + 1) % 5;
                }
                else if(c1 == c2)
                {
                    r1 = (r1 + 1) % 5;
                    r2 = (r2 + 1) % 5;
                }
                else
                {
                    int temp = c1;
                    c1 = c2;
                    c2 = temp;
                }
                encipher[i] = table[r1][c1] + "" + table[r2][c2];
            }
            return encipher;
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

        public static String convertToString(String[][] data) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < data.length; i++) {
                for (int j = 0; j < data[i].length; j++) {
                    sb.append(data[i][j]);
                    // Add delimiter (optional)
                    if (j < data[i].length - 1) {
                        //sb.append(" "); // Add space as delimiter between elements
                    }
                }
                //sb.append("\n"); // Add newline after each row
            }
            return sb.toString();
        }

    }

