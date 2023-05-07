import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class WordleGame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton guessButton;
    private JLabel resultLabel, wordLabel;
    private JPanel inputPanel, resultPanel, wordPanel;

    public WordleGame() {

        setTitle("Wordle Game");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // create components
        inputField = new JTextField();
        guessButton = new JButton("Check Guess");
        guessButton.addActionListener(this);

        // add components to inputpanel
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.NORTH);
        inputPanel.add(guessButton, BorderLayout.CENTER);

        resultLabel = new JLabel();
        resultPanel = new JPanel();
        resultPanel.add(resultLabel);

        wordLabel = new JLabel();
        wordPanel = new JPanel();
        wordPanel.add(wordLabel);

        // add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        add(wordPanel, BorderLayout.SOUTH);

        // add action listener to guess button

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Back end to be implemented in another class by Uros.
    }
    
}

