import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class HillGUI implements ActionListener {

    //buttons
    JButton hillE;
    JButton hillD;
    JButton randomM;

    //text fields
    JTextField plaintext;
    JTextField key;
    ArrayList<Integer> x;

    public ImageIcon getScaledIcon(String imageName, int width, int height) {
        URL imageURL = getClass().getResource("/resources/" + imageName);
        if (imageURL != null) {
            ImageIcon icon = new ImageIcon(imageURL);
            Image image = icon.getImage();
            Image scaledImage = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            return new ImageIcon(scaledImage);
        } else {
            System.out.println("Error: Image not found - " + imageName);
            return null; // Or provide a default icon (optional)
        }
    }

    //icons
    ImageIcon Ico = getScaledIcon("key.png",50,50);
    ImageIcon email = getScaledIcon("email2.png",35,35);
    //ImageIcon email = new ImageIcon(new ImageIcon("email2.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    ImageIcon keyI = getScaledIcon("key.png",35,35);
    //ImageIcon keyI = new ImageIcon(new ImageIcon("key.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    ImageIcon encryptI = getScaledIcon("encrypted.png",30,35);
    //ImageIcon encryptI = new ImageIcon(new ImageIcon("encrypted.png").getImage().getScaledInstance(30, 35, Image.SCALE_SMOOTH));
    ImageIcon decryptI = getScaledIcon("decrypted.png",30,35);
    //ImageIcon decryptI = new ImageIcon(new ImageIcon("decrypted.png").getImage().getScaledInstance(30, 35, Image.SCALE_SMOOTH));
    ImageIcon notificationI = getScaledIcon("notification.png",35,35);
    //ImageIcon notificationI = new ImageIcon(new ImageIcon("notification.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));
    ImageIcon generateI = getScaledIcon("generate.png",35,35);
    //ImageIcon generateI = new ImageIcon(new ImageIcon("generate.png").getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH));


    //labels
    JFrame frame = new JFrame();
    JLabel title = new JLabel();
    JLabel inputPT = new JLabel();
    JLabel inputkey = new JLabel();
    JLabel output = new JLabel();
    JLabel mOneDisp = new JLabel();
    JLabel mTwoDisp = new JLabel();
    JLabel mThreeDisp = new JLabel();
    JLabel mFourDisp = new JLabel();
    JLabel mFiveDisp = new JLabel();
    JLabel mSixDisp = new JLabel();
    JLabel noticeL = new JLabel();

    //panels
    JPanel header = new JPanel();
    JPanel messageField = new JPanel();
    JPanel keyField = new JPanel();
    JPanel encrypt = new JPanel();
    JPanel decrypt = new JPanel();
    JPanel messageText = new JPanel();
    JPanel keyText = new JPanel();
    JPanel result = new JPanel();
    JPanel random = new JPanel();
    JPanel mOne = new JPanel();
    JPanel mTwo = new JPanel();
    JPanel mThree = new JPanel();
    JPanel mFour = new JPanel();
    JPanel mFive = new JPanel();
    JPanel mSix = new JPanel();
    JPanel copyright = new JPanel();
    JPanel notice = new JPanel();

    HillGUI()
    {
        hillE = new JButton("Encrypt", encryptI);
        hillE.setBackground(Color.lightGray);
        hillE.addActionListener(this);
        hillD = new JButton("Decrypt", decryptI);
        hillD.addActionListener(this);
        hillD.setBackground(Color.lightGray);
        randomM = new JButton("Generate", generateI);
        randomM.addActionListener(this);
        randomM.setBackground(Color.LIGHT_GRAY);
        plaintext = new JTextField();
        key = new JTextField();
        plaintext.setPreferredSize(new Dimension(250, 40));
        key.setPreferredSize(new Dimension(250, 40));





        header.setBounds(0, 0, 500, 50);
        messageText.setBounds(0, 50, 150, 50);
        keyText.setBounds(0, 100, 150, 50);
        messageField.setBounds(150, 50, 350, 50);
        keyField.setBounds(150, 100, 350, 50);
        notice.setBounds(0, 150, 500, 65);
        random.setBounds(200, 215, 100, 50);
        mOne.setBounds(25, 265, 150, 40);
        mTwo.setBounds(175, 265, 150, 40);
        mThree.setBounds(325, 265, 150, 40);
        mFour.setBounds(25, 305, 150, 40);
        mFive.setBounds(175, 305, 150, 40);
        mSix.setBounds(325, 305, 150, 40);
        encrypt.setBounds(134, 355, 100, 75);
        decrypt.setBounds(259, 355, 100, 75);
        result.setBounds(0, 430, 500, 50);
        copyright.setBounds(0, 450, 500, 50);


        messageField.setBackground(Color.lightGray);
        header.setBackground(Color.black);
        keyField.setBackground(Color.lightGray);
        encrypt.setBackground(Color.LIGHT_GRAY);
        decrypt.setBackground(Color.LIGHT_GRAY);
        messageText.setBackground(Color.lightGray);
        keyText.setBackground(Color.lightGray);
        result.setBackground(Color.LIGHT_GRAY);
        notice.setBackground(Color.decode("#CE1844"));
        random.setBackground(Color.LIGHT_GRAY);
        mOne.setBackground(Color.LIGHT_GRAY);
        mTwo.setBackground(Color.LIGHT_GRAY);
        mThree.setBackground(Color.LIGHT_GRAY);
        mFour.setBackground(Color.LIGHT_GRAY);
        mFive.setBackground(Color.LIGHT_GRAY);
        mSix.setBackground(Color.LIGHT_GRAY);
        copyright.setBackground(Color.LIGHT_GRAY);


        title.setText("Hill Algorithm");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Consolas", Font.BOLD, 40));
        inputPT.setText("Message ");
        inputPT.setIcon(email);
        inputkey.setText("Enter key ");
        inputkey.setIcon(keyI);
        noticeL.setText("<html>NOTICE:  Choosing your own key matrix can be complex.<br> Use Pre-validated matrices." +
                "Custom matrices are allowed, <br>but ensure invertibility and modular constraints (values modulo 26).");
        noticeL.setForeground(Color.BLACK);
        noticeL.setIcon(notificationI);


        frame.setTitle("Encryption Algorithms");
        frame.setDefaultCloseOperation(3);
        //frame.setLayout((LayoutManager)null);
        frame.setResizable(false);
        frame.setSize(500, 600);
        frame.setVisible(true);
        header.add(title);
        messageField.add(plaintext);
        keyField.add(key);
        encrypt.add(hillE);
        decrypt.add(hillD);
        messageText.add(inputPT);
        keyText.add(inputkey);
        notice.add(noticeL);
        random.add(randomM);
        mOne.add(mOneDisp);
        mTwo.add(mTwoDisp);
        mThree.add(mThreeDisp);
        mFour.add(mFourDisp);
        mFive.add(mFiveDisp);
        mSix.add(mSixDisp);
        result.add(output);

        frame.add(header);
        frame.add(messageField);
        frame.add(keyField);
        frame.add(encrypt);
        frame.add(decrypt);
        frame.add(messageText);
        frame.add(keyText);
        frame.add(result);
        frame.add(notice);
        frame.add(random);
        frame.add(mOne);
        frame.add(mTwo);
        frame.add(mThree);
        frame.add(mFour);
        frame.add(mFive);
        frame.add(mSix);
        frame.add(copyright);
        frame.setIconImage(Ico.getImage());

    }

    public void actionPerformed (ActionEvent e){
        String getKey;
        String text;
        int[][] key2Matrix;
        StringBuilder outputS;
        if (e.getSource() == randomM) {
            mOneDisp.setText(hill_encrypt.recommend(1));
            mTwoDisp.setText(hill_encrypt.recommend(2));
            mThreeDisp.setText(hill_encrypt.recommend(3));
            mFourDisp.setText(hill_encrypt.recommend(4));
            mFiveDisp.setText(hill_encrypt.recommend(5));
            mSixDisp.setText(hill_encrypt.recommend(6));

        } else if (e.getSource() == hillE) {

            getKey = key.getText();
            text = plaintext.getText();
            key2Matrix = hill_matrix.convertStringToIntMatrix(getKey);
            x = hill_encrypt.encrypt(text, key2Matrix);
            outputS = hill_encrypt.displayHill(x);
            output.setText("" + outputS);
            output.setFont(new Font("Consolas", Font.BOLD, 25));
            //  }


        }

        if (e.getSource() == hillD) {
            getKey = key.getText();
            text = plaintext.getText();
            key2Matrix = hill_matrix.convertStringToIntMatrix(getKey);
            x = hill_decrypt.decrypt(text, key2Matrix);
            outputS = hill_decrypt.displayHill(x);
            output.setText(" " + outputS);
        }

    }
}
