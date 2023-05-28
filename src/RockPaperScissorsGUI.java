import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RockPaperScissorsGUI extends JFrame {
    private JButton rockButton;
    private JButton paperButton;
    private JButton scissorsButton;
    private JLabel resultLabel;

    public RockPaperScissorsGUI() {
        setTitle("Rock Paper Scissors");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        rockButton = new JButton("Rock");
        rockButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Rock");
            }
        });
        add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Paper");
            }
        });
        add(paperButton);

        scissorsButton = new JButton("Scissors");
        scissorsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                playGame("Scissors");
            }
        });
        add(scissorsButton);

        resultLabel = new JLabel("Choose your move!");
        add(resultLabel);

        pack();
        setVisible(true);
    }

    private void playGame(String playerMove) {
        String[] options = {"Rock", "Paper", "Scissors"};
        int computerMoveIndex = (int) (Math.random() * 3);
        String computerMove = options[computerMoveIndex];

        String result = determineWinner(playerMove, computerMove);

        String message = "Player chose: " + playerMove + "\n"
                + "Computer chose: " + computerMove + "\n"
                + "Result: " + result;
        resultLabel.setText(message);
    }

    private String determineWinner(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "It's a tie!";
        } else if (playerMove.equals("Rock") && computerMove.equals("Scissors")
                || playerMove.equals("Paper") && computerMove.equals("Rock")
                || playerMove.equals("Scissors") && computerMove.equals("Paper")) {
            return "Player wins!";
        } else {
            return "Computer wins!";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RockPaperScissorsGUI();
            }
        });
    }
}
