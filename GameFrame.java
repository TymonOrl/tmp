import javax.swing.*;

import boardPackage.boardPanel;

import java.awt.*;

public class GameFrame extends JFrame {
    JPanel panelGame, panelOptions, panelClock, panelPlayers, panelEnd;
    JButton buttonEnd, buttonResign;
    JLabel labelPlayer1, labelPlayer2, labelMove, labelClock;

    public GameFrame(Languages currentLanguage) throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 700);

        buttonEnd = new JButton(currentLanguage.getExit());
        buttonResign = new JButton(currentLanguage.getResign());
        labelPlayer1 = new JLabel(currentLanguage.getPlayer()+"1");
        labelPlayer2 = new JLabel(currentLanguage.getPlayer()+"2");
        labelMove = new JLabel(currentLanguage.getMove()+currentLanguage.getPlayer()); //TODO
        labelClock = new JLabel("tu będzie zegar");
        labelPlayer1.setFont(new Font("Serif", Font.PLAIN, 30));
        labelPlayer2.setFont(new Font("Serif", Font.PLAIN, 30));
        labelMove.setFont(new Font("Serif", Font.PLAIN, 30));
        labelClock.setFont(new Font("Serif", Font.PLAIN, 50));

        panelGame = new JPanel();
        add(panelGame, BorderLayout.WEST);
        panelOptions = new JPanel();
        panelClock = new JPanel();
        panelPlayers = new JPanel();
        panelEnd = new JPanel();
        panelPlayers.setLayout(new GridLayout(2,2));
        panelPlayers.add(labelPlayer1);
        panelPlayers.add(labelPlayer2);
        panelPlayers.add(labelMove);
        Dimension buttonResignSize = new Dimension(80,40);
        buttonResign.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        buttonResign.setMaximumSize(buttonResignSize);
        buttonResign.setMinimumSize(buttonResignSize);
        buttonResign.setPreferredSize(buttonResignSize);
        buttonResign.addActionListener(e -> (new EndFrame(currentLanguage)).setVisible(true));
        panelPlayers.add(buttonResign);

        buttonEnd.setAlignmentY(JComponent.BOTTOM_ALIGNMENT);
        Dimension buttonEndSize = new Dimension(300,150);
        buttonEnd.setMaximumSize(buttonEndSize);
        buttonEnd.setMinimumSize(buttonEndSize);
        buttonEnd.setPreferredSize(buttonEndSize);
        buttonEnd.addActionListener(e -> System.exit(0));
        panelEnd.add(Box.createRigidArea(new Dimension(0, 600)));
        panelEnd.add(buttonEnd, BorderLayout.PAGE_END);
        panelClock.add(labelClock);
        panelOptions.setLayout(new BoxLayout(panelOptions,BoxLayout.Y_AXIS));
        panelOptions.add(panelClock);
        panelOptions.add(panelPlayers);
        panelOptions.add(panelEnd);
        add(panelOptions, BorderLayout.EAST);
        add(panelGame, BorderLayout.WEST);
        
        boardPanel board = new boardPanel();
		add(board, BorderLayout.CENTER);
    }
}
