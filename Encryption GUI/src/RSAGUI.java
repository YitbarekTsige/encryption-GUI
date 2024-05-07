import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.util.ArrayList;

public class RSAGUI implements ActionListener {

     static int abel;
     static int john;
     static int yeab;
     static String yitbe;

    //buttons
     JButton RSAE;
     JButton RSAD;
     JButton RSAE2;
     JButton RSAD2;
     JButton randomM;

     //fields
    JTextField plaintext;
    JTextField key;
    JTextField p;
    JTextField q;

    //icons

    // Assuming "resources" folder stores your images
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


    JFrame frame = new JFrame();

    JTextArea outputA = new JTextArea();

    //labels
        JLabel title = new JLabel();
        JLabel inputPT = new JLabel();
        JLabel inputkey = new JLabel();
        JLabel outputL = new JLabel();
        JLabel randomL = new JLabel();
        JLabel mOneDisp = new JLabel();
        JLabel mTwoDisp = new JLabel();
        JLabel mThreeDisp = new JLabel();
        JLabel mFourDisp = new JLabel();
        JLabel mFiveDisp = new JLabel();
        JLabel mSixDisp = new JLabel();
        JLabel noticeL = new JLabel();
        JLabel nova = new JLabel();
        JLabel novb = new JLabel();
        JLabel novc = new JLabel();
        JLabel courtsy = new JLabel();
        JLabel expla = new JLabel();


    //panels
    JPanel header = new JPanel();
    JPanel messageField = new JPanel();
    JPanel encrypt = new JPanel();
    JPanel decrypt = new JPanel();
    JPanel messageText = new JPanel();
    JPanel result = new JPanel();
    JPanel mOne = new JPanel();
    JPanel mTwo = new JPanel();
    JPanel mThree = new JPanel();
    JPanel mFour = new JPanel();
    JPanel mFive = new JPanel();
    JPanel mSix = new JPanel();
    JPanel copyright = new JPanel();
    JPanel copyrightF = new JPanel();
    JPanel notice = new JPanel();
    JPanel a = new JPanel();
    JPanel b = new JPanel();
    JPanel c = new JPanel();
    JPanel sam = new JPanel();
    JPanel tiger = new JPanel();
    JPanel eye = new JPanel();
    JPanel random = new JPanel();


    RSAGUI()
    {
        RSAE = new JButton("Encrypt [Alphabet Indexing]", encryptI);
        RSAE.setBackground(Color.lightGray);
        RSAE.setPreferredSize(new Dimension(300, 50));
        RSAE.addActionListener(this);
        RSAD = new JButton("Decrypt [Alphabet Indexing]", decryptI);
        RSAD.setPreferredSize(new Dimension(300, 50));
        RSAD.addActionListener(this);
        RSAD.setBackground(Color.lightGray);
        RSAE2 = new JButton("Encrypt [ASCII method]", encryptI);
        RSAE2.setPreferredSize(new Dimension(300, 50));
        RSAE2.setBackground(Color.lightGray);
        RSAE2.addActionListener(this);
        RSAD2 = new JButton("Decrypt [ASCII method]", decryptI);
        RSAD2.setPreferredSize(new Dimension(300, 50));
        RSAD2.addActionListener(this);
        RSAD2.setBackground(Color.lightGray);
        randomM = new JButton("Generate");
        randomM.addActionListener(this);
        randomM.setBackground(Color.LIGHT_GRAY);

        p = new JTextField();
        q = new JTextField();
        p.setPreferredSize(new Dimension(75, 30));
        q.setPreferredSize(new Dimension(75, 30));

        outputA.setRows(5);
        outputA.setColumns(30);
        outputA.setLineWrap(true);

        plaintext = new JTextField();
        //key = new JTextField();
        plaintext.setPreferredSize(new Dimension(250, 40));
        //key.setPreferredSize(new Dimension(250, 40));

        header.setBounds(0, 0, 500, 50);
        messageText.setBounds(0, 50, 150, 50);
        //keyText.setBounds(0, 100, 150, 50);
        messageField.setBounds(150, 50, 350, 50);
        //keyField.setBounds(150, 100, 350, 50);
        notice.setBounds(50, 100, 100, 45);
        a.setBounds(150, 100, 100, 45);
        b.setBounds(250, 100, 100, 45);
        c.setBounds(350, 100, 100, 45);
        sam.setBounds(0, 145, 500, 45);
        random.setBounds(200,200,100,45);
        mOne.setBounds(25, 245, 150, 40);
        mTwo.setBounds(175, 245, 150, 40);
        mThree.setBounds(325, 245, 150, 40);
        mFour.setBounds(25, 285, 150, 40);
        mFive.setBounds(175, 285, 150, 40);
        mSix.setBounds(325, 285, 150, 40);
        tiger.setBounds(30, 325, 200, 50);
        eye.setBounds(259, 325, 200, 50);
        encrypt.setBounds(30, 375, 200, 50);
        decrypt.setBounds(259, 375, 200, 50);
        result.setBounds(0, 450, 500, 75);
        copyright.setBounds(0,525 , 500, 50);
        copyrightF.setBounds(150,650 , 200, 50);

        outputA.setBackground(Color.lightGray);
        messageField.setBackground(Color.lightGray);
        header.setBackground(Color.black);
        //keyField.setBackground(Color.lightGray);
        encrypt.setBackground(Color.LIGHT_GRAY);
        decrypt.setBackground(Color.LIGHT_GRAY);
        tiger.setBackground(Color.lightGray);
        eye.setBackground(Color.lightGray);
        messageText.setBackground(Color.lightGray);
        //keyText.setBackground(Color.white);
        result.setBackground(Color.LIGHT_GRAY);
        notice.setBackground(Color.lightGray);
        a.setBackground(Color.lightGray);
        b.setBackground(Color.lightGray);
        c.setBackground(Color.lightGray);
        sam.setBackground(Color.decode("#CE1844"));
        random.setBackground(Color.LIGHT_GRAY);
        mOne.setBackground(Color.LIGHT_GRAY);
        mTwo.setBackground(Color.LIGHT_GRAY);
        mThree.setBackground(Color.LIGHT_GRAY);
        mFour.setBackground(Color.LIGHT_GRAY);
        mFive.setBackground(Color.LIGHT_GRAY);
        mSix.setBackground(Color.LIGHT_GRAY);
        copyright.setBackground(Color.lightGray);
        copyrightF.setBackground(Color.lightGray);


        title.setText("RSA Algorithm");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Consolas", Font.BOLD,40));
        inputPT.setText("Message ");
        inputPT.setIcon(email);
        inputkey.setText("Enter key ");
        inputkey.setIcon(keyI);
        novb.setText("q");
        novb.setFont(new Font("Consolas", Font.BOLD,30));
        nova.setText("p");
        nova.setFont(new Font("Consolas", Font.BOLD,30));
        courtsy.setForeground(Color.BLACK);
        courtsy.setIcon(notificationI);

        courtsy.setText("<html>Struggling to find suitable prime numbers?<br> use random prime number generators");


        frame.setTitle("Encryption Algorithms");
        frame.setDefaultCloseOperation(3);
        //frame.setLayout((LayoutManager)null);
        frame.setResizable(false);
        frame.setSize(500, 1000);
        frame.setVisible(true);
        header.add(title);
        messageField.add(plaintext);
        //keyField.add(key);
        encrypt.add(RSAE);
        decrypt.add(RSAD);
        tiger.add(RSAE2);
        eye.add(RSAD2);

        messageText.add(inputPT);
        a.add(p);
        notice.add(nova);
        b.add(novb);
        c.add(q);
        random.add(randomM);
        mOne.add(mOneDisp);
        mTwo.add(mTwoDisp);
        mThree.add(mThreeDisp);
        mFour.add(mFourDisp);
        mFive.add(mFiveDisp);
        mSix.add(mSixDisp);
        result.add(outputA);
        sam.add(courtsy);
        copyright.add(expla);

        frame.add(header);
        frame.add(messageField);
        //frame.add(keyField);
        frame.add(encrypt);
        frame.add(decrypt);
        frame.add(messageText);
        //frame.add(keyText);
        frame.add(result);
        frame.add(notice);
        frame.add(a);
        frame.add(b);
        frame.add(c);
        frame.add(sam);
        frame.add(tiger);
        frame.add(eye);
        frame.add(random);
        frame.add(mOne);
        frame.add(mTwo);
        frame.add(mThree);
        frame.add(mFour);
        frame.add(mFive);
        frame.add(mSix);
        frame.add(copyright);
        frame.add(copyrightF);
        frame.setIconImage(Ico.getImage());

    }

    public static void passer(int e, int d, int phi, String nummes)
    {
        abel = e;
        john = d;
        yeab = phi;
        yitbe = nummes;

    }

    public boolean check(String input)
    {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public void actionPerformed(ActionEvent e) {
        String text, PKey, QKey;
        String[] specical_output;
        String output;
        if (e.getSource() == randomM) {
            mOneDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
            mTwoDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
            mThreeDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
            mFourDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
            mFiveDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
            mSixDisp.setText(String.valueOf(RSA_encrypt.generatePrimeNumber()));
        }

        else if (e.getSource() == RSAE) {

            PKey = p.getText();
            QKey = q.getText();
            text = plaintext.getText();
            if(!check(PKey) || !check(QKey))
            {
                JOptionPane.showMessageDialog(null,"You Entered a text in p or q field.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }

            if(!RSA_encrypt.isPrime(Integer.parseInt(PKey)) || !RSA_encrypt.isPrime(Integer.parseInt(QKey)))
            {
                JOptionPane.showMessageDialog(null,"You Entered a number(s) that are not prime", "Invalid p or/and q value", JOptionPane.ERROR_MESSAGE);
            }


            else {
                output = RSA_encrypt.main(text, Integer.parseInt(PKey), Integer.parseInt(QKey));
                outputA.setText("" + output);
                outputA.setFont(new Font("Consolas", Font.BOLD, 25));
                expla.setText("e: " + abel + "     d: " + john + "      Φ(n): " + yeab);
            }
        }
        else if (e.getSource() == RSAD) {

            PKey = p.getText();
            QKey = q.getText();
            text = plaintext.getText();
            if(!check(PKey) || !check(QKey))
            {
                JOptionPane.showMessageDialog(null,"You Entered a text in p or q field.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }

            if(!RSA_encrypt.isPrime(Integer.parseInt(PKey)) || !RSA_encrypt.isPrime(Integer.parseInt(QKey)))
            {
                JOptionPane.showMessageDialog(null,"You Entered a number(s) that are not prime", "Invalid p or/and q value", JOptionPane.ERROR_MESSAGE);
            }
            else {
                specical_output = RSA_decrypt.main(text, Integer.parseInt(PKey), Integer.parseInt(QKey));
                outputA.setText(specical_output[0]);
                outputA.setFont(new Font("Consolas", Font.BOLD, 25));
                expla.setText("Decoded into: " + specical_output[1] + "    e: " + abel + "     d: " + john + "      Φ(n): " + yeab);
            }

        }

        else if (e.getSource() == RSAE2) {

            PKey = p.getText();
            QKey = q.getText();
            text = plaintext.getText();
            if(!check(PKey) || !check(QKey))
            {
                JOptionPane.showMessageDialog(null,"You Entered a text in p or q field.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }

            if(!RSA_encrypt.isPrime(Integer.parseInt(PKey)) || !RSA_encrypt.isPrime(Integer.parseInt(QKey)))
            {
                JOptionPane.showMessageDialog(null,"You Entered a number(s) that are not prime", "Invalid p or/and q value", JOptionPane.ERROR_MESSAGE);
            }
            else {
                output = RSA_encrypt_ASCII.main(text, Integer.parseInt(PKey), Integer.parseInt(QKey));
                outputA.setText("" + output);
                outputA.setFont(new Font("Consolas", Font.BOLD, 25));
                expla.setText("e: " + abel + "     d: " + john + "      Φ(n): " + yeab);
            }
        }

        if (e.getSource() == RSAD2) {
            PKey = p.getText();
            QKey = q.getText();
            text = plaintext.getText();
            if(!check(PKey) || !check(QKey) )
            {
                JOptionPane.showMessageDialog(null,"You Entered a text in p or q field.", "Invalid input", JOptionPane.ERROR_MESSAGE);
            }

            if(!RSA_encrypt.isPrime(Integer.parseInt(PKey)) || !RSA_encrypt.isPrime(Integer.parseInt(QKey)))
            {
                JOptionPane.showMessageDialog(null,"You Entered a number(s) that are not prime", "Invalid p or/and q value", JOptionPane.ERROR_MESSAGE);
            }
            else {
                specical_output = RSA_decrypt_ASCII.main(text, Integer.parseInt(PKey), Integer.parseInt(QKey));
                outputA.setText(specical_output[0]);
                outputA.setFont(new Font("Consolas", Font.BOLD, 25));
                expla.setText("Decoded into : " + specical_output[1] + "    e: " + abel + "     d: " + john + "      Φ(n): " + yeab);
            }
        }

    }
}

