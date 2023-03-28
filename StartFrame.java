import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class StartFrame extends JFrame {
    JPanel panelFlags, panelTitle, panelOptions;
    JButton buttonStart, buttonExit, buttonRanking, buttonChoosing;
    JLabel title;
    JLabel flagPl, flagEng, flagFr;
    Languages currentLanguage = Languages.POLISH;


    public StartFrame() throws HeadlessException {
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setSize(1280, 700);

        panelFlags = new JPanel();
        panelOptions = new JPanel();
        panelTitle = new JPanel();
        title = new JLabel(currentLanguage.getTitle());
        buttonChoosing = new JButton(currentLanguage.getChoose());
        buttonExit = new JButton(currentLanguage.getExit());
        buttonStart = new JButton(currentLanguage.getStart());
        buttonRanking = new JButton(currentLanguage.getRanking());

        add(panelFlags, BorderLayout.SOUTH);
        add(panelTitle, BorderLayout.NORTH);
        add(panelOptions, BorderLayout.CENTER);

        panelTitle.add(title);
        title.setFont(new Font("Serif", Font.PLAIN, 50));
        panelOptions.setLayout(new BoxLayout(panelOptions, BoxLayout.Y_AXIS));
        Dimension buttonSize = new Dimension(150,50);
        buttonStart.setMaximumSize(buttonSize);
        buttonStart.setMinimumSize(buttonSize);
        buttonStart.setPreferredSize(buttonSize);
        buttonExit.setMaximumSize(buttonSize);
        buttonExit.setMinimumSize(buttonSize);
        buttonExit.setPreferredSize(buttonSize);
        buttonChoosing.setMaximumSize(buttonSize);
        buttonChoosing.setMinimumSize(buttonSize);
        buttonChoosing.setPreferredSize(buttonSize);
        buttonRanking.setMaximumSize(buttonSize);
        buttonRanking.setMinimumSize(buttonSize);
        buttonRanking.setPreferredSize(buttonSize);
        buttonStart.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttonExit.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttonRanking.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        buttonChoosing.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        panelOptions.add(Box.createRigidArea(new Dimension(0, 50)));
        panelOptions.add(buttonStart);
        panelOptions.add(Box.createRigidArea(new Dimension(0, 50)));
        panelOptions.add(buttonChoosing);
        panelOptions.add(Box.createRigidArea(new Dimension(0, 50)));
        panelOptions.add(buttonRanking);
        panelOptions.add(Box.createRigidArea(new Dimension(50, 50)));
        panelOptions.add(buttonExit);

        BufferedImage imageFr;
        BufferedImage imageEng;
        BufferedImage imagePl;
        try {
            imageEng = ImageIO.read(new File("images/british-flag-medium.png"));
            imagePl = ImageIO.read(new File("images/polish-flag-medium.png"));
            imageFr = ImageIO.read(new File("images/french-flag-medium.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        flagEng = new JLabel(new ImageIcon(imageEng.getScaledInstance(getWidth()/9, (getWidth()/9)*imageEng.getHeight()/imageEng.getWidth(), Image.SCALE_DEFAULT)));
        flagPl = new JLabel(new ImageIcon(imagePl.getScaledInstance(getWidth()/9, (getWidth()/9)*imagePl.getHeight()/imagePl.getWidth(), Image.SCALE_DEFAULT)));
        flagFr = new JLabel(new ImageIcon(imageFr.getScaledInstance(getWidth()/9, (getWidth()/9)*imageFr.getHeight()/imageFr.getWidth(), Image.SCALE_DEFAULT)));
        panelFlags.setLayout(new GridLayout(1, 3));
        flagEng.addMouseListener(new LangListener(Languages.ENGLISH));
        flagFr.addMouseListener(new LangListener(Languages.FRENCH));
        flagPl.addMouseListener(new LangListener(Languages.POLISH));
        buttonExit.addActionListener(e -> System.exit(0));
        buttonStart.addActionListener(e -> (new GameFrame(currentLanguage)).setVisible(true));
        flagPl.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        flagFr.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        flagEng.setBorder(BorderFactory.createLineBorder(Color.BLACK, 3));
        panelFlags.add(flagEng);
        panelFlags.add(flagFr);
        panelFlags.add(flagPl);


    }

    public void setCurrentLanguage(Languages currentLanguage) {
        this.currentLanguage = currentLanguage;
    }

    class LangListener implements MouseListener{

        Languages newLanguage;
        public LangListener(Languages language){
            newLanguage = language;
        }
        @Override
        public void mouseClicked(MouseEvent e) {
            System.out.println(newLanguage);
            StartFrame.this.setCurrentLanguage(newLanguage);
            title.setText(currentLanguage.getTitle());
            buttonStart.setText(currentLanguage.getStart());
            buttonChoosing.setText(currentLanguage.getChoose());
            buttonExit.setText(currentLanguage.getExit());
            buttonRanking.setText(currentLanguage.getRanking());
        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }
}
