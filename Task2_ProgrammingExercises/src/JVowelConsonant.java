import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ThreadLocalRandom;

public class JVowelConsonant extends JFrame implements ActionListener{
    JPanel panelOne = new JPanel(new GridLayout(2,2));
    JPanel panelTwo = new JPanel(new GridLayout(2, 2));
    JPanel panelThree = new JPanel(new FlowLayout());

    JButton[] alphabets = {new JButton("A"), new JButton("B"), new JButton("C"), new JButton("D"),
            new JButton("E"), new JButton("F"), new JButton("G"), new JButton("H"), new JButton("I"),
            new JButton("J"), new JButton("K"), new JButton("L"), new JButton("M"), new JButton("N"),
            new JButton("O"), new JButton("P"), new JButton("Q"), new JButton("R"), new JButton("S"),
            new JButton("T"), new JButton("U"), new JButton("V"), new JButton("W"), new JButton("X"),
            new JButton("Y"), new JButton("Z")};

    JLabel display = new JLabel("This letter is: ");

    public JVowelConsonant() {
        setLayout(new GridLayout(2,2,2,4));
        setSize(500, 200);

        add(panelOne);
        add(panelTwo);
        add(panelThree);

        for (int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 26);
            panelOne.add(alphabets[randomNum]);
            alphabets[randomNum].addActionListener(this);
        }

        for (int i = 0; i < 5; i++) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 26);
            panelTwo.add(alphabets[randomNum]);
            alphabets[randomNum].addActionListener(this);
        }

        panelThree.add(display);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == alphabets[0] || source == alphabets[4] || source == alphabets[8] || source == alphabets[14] ||
                source == alphabets[20]) {
            display.setText("This letter is: Vowel");
        } else {
            display.setText("This letter is: Consonant");
        }
        JButton buttonClicked = (JButton)e.getSource();
        Container parent = buttonClicked.getParent();
        parent.remove(buttonClicked);
        parent.revalidate();
        parent.repaint();
        int randomNum = ThreadLocalRandom.current().nextInt(0, 26);
        parent.add(alphabets[randomNum]);
        alphabets[randomNum].addActionListener(this);
        parent.repaint();
    }

    public static void main(String[] args) {
        JVowelConsonant jVowelConsonant = new JVowelConsonant();
        jVowelConsonant.setVisible(true);
        jVowelConsonant.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
