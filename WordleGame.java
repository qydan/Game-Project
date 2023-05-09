import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class WordleGame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton guessButton;
    //private JLabel resultLabel, wordLabel;
    private JPanel inputPanel, resultPanel, wordPanel;

    private int currentGuess;

    private List<List<JLabel>> labelList = new ArrayList<>();
    private Board gameBoard;

    public WordleGame() {

        setTitle("Wordle Game");
        setSize(400, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        gameBoard = new Board();

        // create components
        inputField = new JTextField();
        guessButton = new JButton("Check Guess");
        guessButton.addActionListener(this);

        // add components to inputpanel
        inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.NORTH);
        inputPanel.add(guessButton, BorderLayout.CENTER);

        //resultLabel = new JLabel();
        resultPanel = new JPanel();
        resultPanel.setLayout(null);
        resultPanel.setBackground(Color.darkGray);

        initLabels();

        //resultPanel.add(resultLabel);

        //wordLabel = new JLabel();
        //wordPanel = new JPanel();
        //wordPanel.set
        //wordPanel.add(wordLabel);
        //resultPanel.setBackground(Color.RED);
        // add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(resultPanel, BorderLayout.CENTER);
        //add(wordPanel, BorderLayout.SOUTH);

        // add action listener to guess button

        setVisible(true);
    }

    private void initLabels() {

        for (int rows = 0; rows < 6; rows++) {

            List<JLabel> tempLabels = new ArrayList<>();

            for (int cols = 0; cols < 5; cols++) {

                int width = getWidth() / 6;

                JLabel label = new JLabel();
                label.setForeground(Color.WHITE);
                label.setBounds(width * cols + width, width * rows + width, width, width);
                label.setText("[ ]");
                tempLabels.add(label);
                resultPanel.add(label);


            }

            this.labelList.add(tempLabels);
        }

        validate();
        repaint();

    }

    public boolean validateText(String t) {

        if (t.length() != 5) return false;
        //add more conditions if necessary

        return true;
    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == guessButton) {

            String textIn = inputField.getText().toLowerCase();

            if (!validateText(textIn)) return;

            inputField.setText("");

            char[] letters = textIn.toCharArray();
            List<JLabel> activeLabels = labelList.get(currentGuess);

            for (int x = 0; x < activeLabels.size(); x++) {

                char l = letters[x];
                JLabel label = activeLabels.get(x);
                label.setForeground(gameBoard.getColorAt(textIn, x));
                label.setText("" + l);


            }

            /* this is the condition for if the user has guessed correctly to be implemented
            if (textIn.equals("hidden word")){
                dispose();
                JOptionPane.showMessageDialog(this, "YOU WON!","CONGRATULATIONS", JOptionPane.INFORMATION_MESSAGE);
                setVisible(true);
            }
            */


            currentGuess++;
        }

    }

}
