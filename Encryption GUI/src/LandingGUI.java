import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class LandingGUI implements ActionListener {

    //buttons
    JButton rsa;
    JButton hill;
    JButton playfair;

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

    ImageIcon email = getScaledIcon("unilogo.jpg",120,100);
    ImageIcon Ico = getScaledIcon("key.png",50,50);
    JFrame frame = new JFrame();
    JLabel title = new JLabel();
    JLabel inputPT = new JLabel();
    JLabel inputkey = new JLabel();
    JLabel output = new JLabel();
    JLabel randomL = new JLabel();
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
    JPanel copyright = new JPanel();
    JPanel notice = new JPanel();
    LandingGUI()
    {

        rsa = new JButton("RSA");
        rsa.setBackground(Color.lightGray);
        rsa.addActionListener(this);
        hill = new JButton("Hill");
        hill.addActionListener(this);
        hill.setBackground(Color.lightGray);
        playfair = new JButton("Playfair");
        playfair.addActionListener(this);
        playfair.setBackground(Color.LIGHT_GRAY);



        header.setBounds(0, 0, 500, 150);
        messageText.setBounds(0, 50, 150, 50);
        keyText.setBounds(0, 100, 150, 50);

        notice.setBounds(0, 150, 500, 65);
        random.setBounds(200,215,100,50);
        encrypt.setBounds(200, 270, 100, 50);
        decrypt.setBounds(200, 330, 100, 50);
        result.setBounds(150, 430, 200, 50);
        copyright.setBounds(0, 450, 500, 50);


        header.setBackground(Color.white);
        encrypt.setBackground(Color.LIGHT_GRAY);
        decrypt.setBackground(Color.LIGHT_GRAY);
        messageText.setBackground(Color.lightGray);
        keyText.setBackground(Color.lightGray);
        result.setBackground(Color.LIGHT_GRAY);
        notice.setBackground(Color.lightGray);
        random.setBackground(Color.LIGHT_GRAY);
        copyright.setBackground(Color.LIGHT_GRAY);


        title.setText("<html>University of Gondar<br>Institute of Technology<br>Departement of <br> Computer Engineering");
        title.setIcon(email);
        title.setForeground(Color.BLACK);
        title.setFont(new Font("Consolas", Font.BOLD,25));
        inputPT.setText("<html>Encryption Algorithms<br>Choose");
        //inputPT.setIcon(email);
        inputkey.setText("Enter key ");
        noticeL.setText("Choose any Algorithm");
        noticeL.setForeground(Color.BLACK);


        frame.setTitle("Encryption Algorithms");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        //frame.setLayout((LayoutManager)null);
        frame.setResizable(false);
        frame.setSize(500, 450);
        frame.setVisible(true);
        header.add(title);
        encrypt.add(rsa);
        decrypt.add(hill);
        messageText.add(inputPT);
        keyText.add(inputkey);
        notice.add(noticeL);
        random.add(playfair);
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
        frame.add(copyright);
        frame.setIconImage(Ico.getImage());

    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playfair) {
            PlayfairGUI x = new PlayfairGUI();

        }

        else if (e.getSource() == rsa) {
            RSAGUI a = new RSAGUI();



        }

        if (e.getSource() == hill) {
            HillGUI y = new HillGUI();


        }

    }
}
