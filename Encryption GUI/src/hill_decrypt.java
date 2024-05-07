import java.util.ArrayList;

public class hill_decrypt {

// displays the decrypted text
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


//decrypts the given plaintext
    public static ArrayList<Integer> decrypt(String phrase,int[][] keyMatrix)
    {
        int i;
        int[][] revKeyMatrix;
        ArrayList<Integer> phraseToNum = new ArrayList<>();
        ArrayList<Integer> phraseDecoded = new ArrayList<>();

        phrase = phrase.replaceAll("[^a-zA-Z]","").toUpperCase();

        //accepting and checking the validity of the key matrix by calling function from hill_matrix class
        //keyMatrix = hill_matrix.getKeyMatrix();
        hill_matrix.isValidMatrix(keyMatrix);

        for(i=0; i < phrase.length(); i++)
        {
            phraseToNum.add(phrase.charAt(i) - (65));
        }

        System.out.println("~~~\nKey Matrix: ");
        System.out.println(keyMatrix[0][0] + "\t" + keyMatrix[0][1] + "\n" + keyMatrix[1][0] + "\t" + keyMatrix[1][1]);


        //computing and checking the validity of reverse of matrix by calling function from hill_matrix class
        revKeyMatrix = hill_matrix.reverseMatrix(keyMatrix);
        hill_matrix.isValidReverseMatrix(keyMatrix, revKeyMatrix);

        for(i=0; i < phraseToNum.size(); i += 2)
        {
            phraseDecoded.add((revKeyMatrix[0][0] * phraseToNum.get(i) + revKeyMatrix[0][1] * phraseToNum.get(i+1)) % 26);
            phraseDecoded.add((revKeyMatrix[1][0] * phraseToNum.get(i) + revKeyMatrix[1][1] * phraseToNum.get(i+1)) % 26);
        }

        //displayHill("Deciphered text: ", phraseDecoded);
        return  phraseDecoded;
    }
}

