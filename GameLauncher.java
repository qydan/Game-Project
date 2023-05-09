import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameLauncher extends JFrame implements ActionListener{

    JButton instructionsButton, gameButton, exitButton; // declare the exit button
    JLabel titleLabel;
    JPanel p1, p2, p3, buttonPanel;

    public GameLauncher() {

        // Set the window title and size
        setTitle("WORDLE Game Launcher");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the title label
        titleLabel = new JLabel("WELCOME TO WORDLE!");
        titleLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Create the instruction button
        instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        instructionsButton.setForeground(Color.WHITE);
        instructionsButton.setBackground(Color.BLACK);
        instructionsButton.addActionListener(this);

        // Create the game button
        gameButton = new JButton("Play Game");
        gameButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        gameButton.setForeground(Color.WHITE);
        gameButton.setBackground(Color.BLACK);
        gameButton.addActionListener(this);

        // Create the exit button
        exitButton = new JButton("Exit"); // initialize the button
        exitButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        exitButton.setForeground(Color.WHITE);
        exitButton.setBackground(Color.BLACK);
        exitButton.addActionListener(this); // add the action listener

        //Panels to space out buttons and create a border
        p1 = new JPanel();
        p2 = new JPanel();
        p3 = new JPanel();
        p1.setBackground(Color.DARK_GRAY);
        p2.setBackground(Color.DARK_GRAY);
        p3.setBackground(Color.DARK_GRAY);
        

        //Adding to button panel
        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(3, 1, 10, 10)); // increase the grid layout to 3 rows
        buttonPanel.setBackground(Color.DARK_GRAY);
        buttonPanel.add(gameButton);
        buttonPanel.add(instructionsButton);
        buttonPanel.add(exitButton); // add the exit button to the panel


        // Add the components to the content pane
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.DARK_GRAY);
        contentPane.setLayout(new BorderLayout());
        contentPane.add(titleLabel, BorderLayout.NORTH);
        contentPane.add(p1, BorderLayout.EAST);
        contentPane.add(p2, BorderLayout.WEST);
        contentPane.add(p3, BorderLayout.SOUTH);
        contentPane.add(buttonPanel, BorderLayout.CENTER);
        
    }

    // action performed mehtod to handle button clicks
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == instructionsButton) {
            // Open the instruction menu
            JOptionPane.showMessageDialog(this, "How To Play:\n\n" +
                    "1. Guess the Wordle in 6 tries.\n" +
                    "2. Each guess must be a valid 5-letter word.\n" +
                    "3. Color tiles will indicate how close your guess was to the word.\n" +
                    "    - Green indicates letter is in the word and correct spot.\n" +
                    "    - Yellow inidcates letter is in the word but incorrect spot.\n" + 
                    "    - Grey indicates letter is not in the word.\n", "Instructions", JOptionPane.INFORMATION_MESSAGE);
        } 
        
        else if (e.getSource() == gameButton) {
            // Open the game menu
            //JOptionPane.showMessageDialog(this, "WORDLE GAME", "WORDLE", JOptionPane.INFORMATION_MESSAGE); 
            setVisible(false);
            new WordleGame();
            
        } 
        
        else if (e.getSource() == exitButton) { // add the exit button handling
            System.exit(0); // exit the application
        }

    }

}

