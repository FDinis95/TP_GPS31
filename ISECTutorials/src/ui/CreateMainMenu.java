package ui;

import data.FindPath;
import data.Progression;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public final class CreateMainMenu
{

    JFrame frame;
    JPanel northCardPanel;
    JPanel centralCardPanel;
    CardLayout northCard;
    CardLayout centralCard;
    String layoutName = "";
    String path = "";
    Progression pro = new Progression();

    public CreateMainMenu()
    {
        buildWindow();
    }

    public void buildWindow()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("ISEC Tutorials");
        frame.setSize(new Dimension(800, 600));
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        northCardPanel = new JPanel();
        northCard = new CardLayout();

        //TopPanel
        northCardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //TopPanel version One
        JPanel greetings = new JPanel();
        greetings.add(new JLabel("Welcome to ISEC Tutorials!"));
        northCardPanel.setLayout(northCard);
        northCardPanel.add(greetings, "greetings");
        frame.add(northCardPanel, BorderLayout.NORTH);

        //CentralPanel
        centralCardPanel = new JPanel();
        centralCard = new CardLayout();
        centralCardPanel.setLayout(centralCard);

        JPanel menuPanel = new JPanel();
        FindPath fp = new FindPath();
        menuPanel.setBackground(Color.DARK_GRAY);
        menuPanel.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;

        for (String buttons : fp.getName())
        {
            JButton btn = new JButton(buttons);
            btn.addActionListener((ActionEvent e) ->
            {
                for (String s : fp.getPath())
                {
                    if (s.contains(buttons))
                    {
                        path = s;
                    }
                }

                centralCardPanel.add(new EvaluationTest().evaluation(path, centralCard, centralCardPanel, pro), "evaluation");//, answers, corrects, chapter
                centralCard.show(centralCardPanel, "evaluation");
            });
            menuPanel.add(btn, gbc);
        }

        centralCardPanel.add(menuPanel, "menu");
        centralCard.show(centralCardPanel, "menu");

        frame.add(centralCardPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}
