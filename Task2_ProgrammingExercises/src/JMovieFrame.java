import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JMovieFrame extends JFrame implements ActionListener{
    JPanel borderPanel = new JPanel(new BorderLayout());
    JPanel displayPanel = new JPanel(new FlowLayout());

    JButton buttonNorth = new JButton("Fist of the North Star");
    JButton buttonEast = new JButton("East Side Kids");
    JButton buttonSouth = new JButton("South Pacific");
    JButton buttonWest = new JButton("West Side Story");

    JLabel movieDetails = new JLabel("");

    public JMovieFrame() {
        setLayout(new GridLayout(2, 1));
        setSize(500, 200);

        add(borderPanel);
        add(displayPanel);

        borderPanel.add(buttonNorth, BorderLayout.NORTH);
        borderPanel.add(buttonEast, BorderLayout.EAST);
        borderPanel.add(buttonSouth, BorderLayout.SOUTH);
        borderPanel.add(buttonWest, BorderLayout.WEST);

        buttonNorth.addActionListener(this);
        buttonEast.addActionListener(this);
        buttonSouth.addActionListener(this);
        buttonWest.addActionListener(this);

        displayPanel.add(movieDetails);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source == buttonNorth) {
            movieDetails.setText("Year of release: 1995       Starring: Gary Daniels as Kenshiro");
        }
        else if (source == buttonEast) {
            movieDetails.setText("Year of release: 1940     Starring: Leon Ames as Pat O'Day");
        }
        else if (source == buttonSouth) {
            movieDetails.setText("Year of release: 1958     Starring: Rossano Brazi as Emile de Becque");
        }
        else {
            movieDetails.setText("Year of release: 1961     Starring: Natalie Wood as Maria Nunez");
        }
    }

    public static void main(String[] args) {
        JMovieFrame jMovieFrame = new JMovieFrame();
        jMovieFrame.setVisible(true);
        jMovieFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

}
