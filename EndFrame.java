import javax.swing.*;
import java.awt.*;

public class EndFrame extends JFrame {
    JPanel panel;
    JLabel labelWinner, labelPlayer;
    JButton buttonExit, buttonRematch;
    public EndFrame(Languages currentLanguage) throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(800, 500);

        panel = new JPanel();
        labelPlayer = new JLabel(currentLanguage.getPlayer());
        labelWinner = new JLabel(currentLanguage.getWinner());
        buttonExit = new JButton(currentLanguage.getExit());
        buttonRematch = new JButton(currentLanguage.getRematch());
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        labelWinner.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        labelPlayer.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttonRematch.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttonExit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        labelPlayer.setFont(new Font("Serif", Font.PLAIN, 50));
        labelWinner.setFont(new Font("Serif", Font.PLAIN, 50));
        Dimension buttonSize = new Dimension(150,50);
        buttonExit.setMaximumSize(buttonSize);
        buttonExit.setMinimumSize(buttonSize);
        buttonExit.setPreferredSize(buttonSize);
        buttonRematch.setMaximumSize(buttonSize);
        buttonRematch.setMinimumSize(buttonSize);
        buttonRematch.setPreferredSize(buttonSize);
        buttonExit.addActionListener(e -> System.exit(0));
        //
        // buttonRematch.addActionListener(e -> );

        panel.add(labelWinner);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(labelPlayer);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(buttonRematch);
        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(buttonExit);

        add(panel);
    }
}
