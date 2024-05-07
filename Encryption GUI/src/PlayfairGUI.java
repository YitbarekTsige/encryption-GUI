import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class PlayfairGUI implements ActionListener {
    //buttons
     JButton playfairE;
     JButton playfairD;
     JButton randomM;

     //fields
     JTextField plaintext;
     JTextField key;

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


    JFrame frame = new JFrame();

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
    JPanel mSeven = new JPanel();
    JPanel mEight = new JPanel();
    JPanel mNine = new JPanel();
    JPanel mTen = new JPanel();
    JPanel mEleven = new JPanel();
    JPanel mTwelve = new JPanel();
    JPanel mThirteen = new JPanel();
    JPanel mFourteen = new JPanel();
    JPanel mFiveteen = new JPanel();
    JPanel mSixteen = new JPanel();
    JPanel mSeventeen = new JPanel();
    JPanel mEighteen = new JPanel();
    JPanel mNineteen = new JPanel();
    JPanel mTwenty = new JPanel();
    JPanel mTwentyOne = new JPanel();
    JPanel mTwentyTwo = new JPanel();
    JPanel mTwentyThree = new JPanel();
    JPanel mTwentyFour = new JPanel();
    JPanel mTwentyFive = new JPanel();
    JPanel copyright = new JPanel();
    JPanel notice = new JPanel();

    //labels
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
    JLabel mSevenDisp = new JLabel();
    JLabel mEightDisp = new JLabel();
    JLabel mNineDisp = new JLabel();
    JLabel mTenDisp = new JLabel();
    JLabel mElevenDisp = new JLabel();
    JLabel mTwelveDisp = new JLabel();
    JLabel mThirteenDisp= new JLabel();
    JLabel mFouteenDisp = new JLabel();
    JLabel mFivteenDisp = new JLabel();
    JLabel mSixteenDisp = new JLabel();
    JLabel mSeventeenDisp = new JLabel();
    JLabel mEighteenDisp = new JLabel();
    JLabel mNineteenDisp = new JLabel();
    JLabel mTwentyDisp = new JLabel();
    JLabel mTwentyOneDisp = new JLabel();
    JLabel mTwentyTwoDisp = new JLabel();
    JLabel mTwentyThreeDisp = new JLabel();
    JLabel mTwentyFourDisp = new JLabel();
    JLabel mTwentyFiveDisp = new JLabel();
    JLabel noticeL = new JLabel();

    PlayfairGUI()
    {
        playfairE = new JButton("Encrypt", encryptI);
        playfairE.setBackground(Color.lightGray);
        playfairE.addActionListener(this);
        playfairD = new JButton("Decrypt", decryptI);
        playfairD.addActionListener(this);
        playfairD.setBackground(Color.lightGray);
        randomM = new JButton("Key Matrix");
        randomM.addActionListener(this);
        randomM.setBackground(Color.LIGHT_GRAY);
        randomM.setPreferredSize(new Dimension(300,50));

        plaintext = new JTextField();
        plaintext.setPreferredSize(new Dimension(250, 40));
        key = new JTextField();
        key.setPreferredSize(new Dimension(250, 40));

        header.setBounds(0, 0, 500, 50);
        messageText.setBounds(0, 50, 150, 50);
        keyText.setBounds(0, 100, 150, 50);
        messageField.setBounds(150, 50, 350, 50);
        keyField.setBounds(150, 100, 350, 50);
        notice.setBounds(0, 150, 500, 65);
        random.setBounds(185,215,100,50);

        mOne.setBounds(200, 265, 15, 25);
        mTwo.setBounds(215, 265, 15, 25);
        mThree.setBounds(230, 265, 15, 25);
        mFour.setBounds(245, 265, 15, 25);
        mFive.setBounds(260, 265, 15, 25);

        mSix.setBounds(200, 290, 15, 25);
        mSeven.setBounds(215, 290, 15, 25);
        mEight.setBounds(230, 290, 15, 25);
        mNine.setBounds(245, 290, 15, 25);
        mTen.setBounds(260, 290, 15, 25);

        mEleven.setBounds(200, 315, 15, 25);
        mTwelve.setBounds(215, 315, 15, 25);
        mThirteen.setBounds(230, 315, 15, 25);
        mFourteen.setBounds(245, 315, 15, 25);
        mFiveteen.setBounds(260, 315, 15, 25);

        mSixteen.setBounds(200, 340, 15, 25);
        mSeventeen.setBounds(215, 340, 15, 25);
        mEighteen.setBounds(230, 340, 15, 25);
        mNineteen.setBounds(245, 340, 15, 25);
        mTwenty.setBounds(260, 340, 15, 25);

        mTwentyOne.setBounds(200, 365, 15, 25);
        mTwentyTwo.setBounds(215, 365, 15, 25);
        mTwentyThree.setBounds(230, 365, 15, 25);
        mTwentyFour.setBounds(245, 365, 15, 25);
        mTwentyFive.setBounds(260, 365, 15, 25);

        encrypt.setBounds(134, 400, 100, 75);
        decrypt.setBounds(259, 400, 100, 75);
        result.setBounds(0, 490, 500, 50);
        copyright.setBounds(0, 585, 500, 50);

        messageField.setBackground(Color.lightGray);
        header.setBackground(Color.black);
        keyField.setBackground(Color.lightGray);
        encrypt.setBackground(Color.LIGHT_GRAY);
        decrypt.setBackground(Color.LIGHT_GRAY);
        messageText.setBackground(Color.white);
        keyText.setBackground(Color.white);
        result.setBackground(Color.LIGHT_GRAY);
        notice.setBackground(Color.decode("#CE1844"));
        random.setBackground(Color.LIGHT_GRAY);
        copyright.setBackground(Color.lightGray);

        title.setText("Playfair Algorithm");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Consolas", Font.BOLD,40));
        inputPT.setText("Message ");
        inputPT.setIcon(email);
        inputkey.setText("Enter key ");
        inputkey.setIcon(keyI);
        noticeL.setText("<html>No special characters are not allowed! Keys should be entered in plaintext.<br>");
        notice.setForeground(Color.BLACK);
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
        encrypt.add(playfairE);
        decrypt.add(playfairD);
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

        mSeven.add(mSevenDisp);
        mEight.add(mEightDisp);
        mNine.add(mNineDisp);
        mTen.add(mTenDisp);
        mEleven.add(mElevenDisp);
        mTwelve.add(mTwelveDisp);

        mThirteen.add(mThirteenDisp);
        mFourteen.add(mFouteenDisp);
        mFiveteen.add(mFivteenDisp);
        mSixteen.add(mSixteenDisp);
        mSeventeen.add(mSeventeenDisp);
        mEighteen.add(mEighteenDisp);

        mNineteen.add(mNineteenDisp);
        mTwenty.add(mTwentyDisp);
        mTwentyOne.add(mTwentyOneDisp);
        mTwentyTwo.add(mTwentyTwoDisp);
        mTwentyThree.add(mTwentyThreeDisp);
        mTwentyFour.add(mTwentyFourDisp);
        mTwentyFive.add(mTwentyFiveDisp);
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

        frame.add(mSeven);
        frame.add(mEight);
        frame.add(mNine);
        frame.add(mTen);
        frame.add(mEleven);
        frame.add(mTwelve);

        frame.add(mThirteen);
        frame.add(mFourteen);
        frame.add(mFiveteen);
        frame.add(mSixteen);
        frame.add(mSeventeen);
        frame.add(mEighteen);

        frame.add(mNineteen);
        frame.add(mTwenty);
        frame.add(mTwentyOne);
        frame.add(mTwentyTwo);
        frame.add(mTwentyThree);
        frame.add(mTwentyFour);
        frame.add(mTwentyFive);
        frame.add(copyright);

        frame.setIconImage(Ico.getImage());
    }

    public void actionPerformed(ActionEvent e) {
        String getKey;
        String text;
        if (e.getSource() == playfairE) {
            getKey = key.getText();
            pfE.table = pfE.cipherTable(pfE.parseString(getKey));
            text = plaintext.getText();
            String PlayfairResult = pfE.cipher(pfE.parseString(text));;
            output.setText(PlayfairResult);
            output.setFont(new Font("Consolas", Font.BOLD,25));

            String[][] jack = pfE.table;
            mOneDisp.setText(jack[0][0]);
            mTwoDisp.setText(jack[0][1]);
            mThreeDisp.setText(jack[0][2]);
            mFourDisp.setText(jack[0][3]);
            mFiveDisp.setText(jack[0][4]);

            mSixDisp.setText(jack[1][0]);
            mSevenDisp.setText(jack[1][1]);
            mEightDisp.setText(jack[1][2]);
            mNineDisp.setText(jack[1][3]);
            mTenDisp.setText(jack[1][4]);

            mElevenDisp.setText(jack[2][0]);
            mTwelveDisp.setText(jack[2][1]);
            mThirteenDisp.setText(jack[2][2]);
            mFouteenDisp.setText(jack[2][3]);
            mFivteenDisp.setText(jack[2][4]);

            mSixteenDisp.setText(jack[3][0]);
            mSeventeenDisp.setText(jack[3][1]);
            mEighteenDisp .setText(jack[3][2]);
            mNineteenDisp.setText(jack[3][3]);
            mTwentyDisp.setText(jack[3][4]);

            mTwentyOneDisp.setText(jack[4][0]);
            mTwentyTwoDisp.setText(jack[4][1]);
            mTwentyThreeDisp.setText(jack[4][2]);
            mTwentyFourDisp.setText(jack[4][3]);
            mTwentyFiveDisp.setText(jack[4][4]);
            //  }


        }

        if (e.getSource() == playfairD) {

            getKey = key.getText();
            pfD.table = pfD.cipherTable(pfD.parseString(getKey));
            text = plaintext.getText();
            String PlayfairResult2 = pfD.decode(pfD.parseString(text));;
            output.setText(PlayfairResult2);
            output.setFont(new Font("Consolas", Font.BOLD,25));

            String[][] jack = pfD.table;
            mOneDisp.setText(jack[0][0]);
            mTwoDisp.setText(jack[0][1]);
            mThreeDisp.setText(jack[0][2]);
            mFourDisp.setText(jack[0][3]);
            mFiveDisp.setText(jack[0][4]);

            mSixDisp.setText(jack[1][0]);
            mSevenDisp.setText(jack[1][1]);
            mEightDisp.setText(jack[1][2]);
            mNineDisp.setText(jack[1][3]);
            mTenDisp.setText(jack[1][4]);

            mElevenDisp.setText(jack[2][0]);
            mTwelveDisp.setText(jack[2][1]);
            mThirteenDisp.setText(jack[2][2]);
            mFouteenDisp.setText(jack[2][3]);
            mFivteenDisp.setText(jack[2][4]);

            mSixteenDisp.setText(jack[3][0]);
            mSeventeenDisp.setText(jack[3][1]);
            mEighteenDisp .setText(jack[3][2]);
            mNineteenDisp.setText(jack[3][3]);
            mTwentyDisp.setText(jack[3][4]);

            mTwentyOneDisp.setText(jack[4][0]);
            mTwentyTwoDisp.setText(jack[4][1]);
            mTwentyThreeDisp.setText(jack[4][2]);
            mTwentyFourDisp.setText(jack[4][3]);
            mTwentyFiveDisp.setText(jack[4][4]);
        }

    }
}
