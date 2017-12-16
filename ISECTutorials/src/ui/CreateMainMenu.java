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

    // TEMPORARIO
    Progression pro = new Progression();
    //

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
        System.err.println("Igot here before path" + path);

//        problem here, its grabing the path before we have it...
//        i think it's adding the panels before activating the buttons
//        so must be passed through the buttons ActionEvents
//        centralCardPanel.add(new EvaluationTest().evaluation(path, centralCard, centralCardPanel), "evaluation");
//        centralCardPanel.add(new ShowTutorial().tutorial(path, centralCard, centralCardPanel), "tutorial");
        frame.add(centralCardPanel, BorderLayout.CENTER);
        frame.setVisible(true);

    }

}

//    public void buildWindow()
//    {
//        Container cp = getContentPane();
//        JPanel centralPanel = new JPanel();
//        cp.setLayout(new BorderLayout());
//        cp.add(centralPanel, BorderLayout.CENTER);
//
//        JPanel label = new JPanel(new BorderLayout());
//        FindPath fp = new FindPath();
//
//        centralPanel.setLayout(new BoxLayout(centralPanel, BoxLayout.X_AXIS));
//        centralPanel.setBorder(BorderFactory.createLineBorder(Color.black));
//        label.setMaximumSize(new Dimension(1000, 10));
//        label.add(new JLabel("Select a language: "));
////        label.setSize(400, 600);
//        cp.add(label);
//
//        for (String buttons : fp.getName())
//        {
//            System.err.println(label);
//            JButton btn = new JButton(buttons);
//            btn.setMaximumSize(new Dimension(100,100));
//            //btn.addActionListener(this);
//            cp.add(btn);
//        }
//        cp.setSize(400, 600);
//        setLayout(new BoxLayout(cp, BoxLayout.Y_AXIS));
//        setVisible(true);
//
//    }
//        Evaluation test card
//        JPanel firstCard = new JPanel();
//        firstCard.setBackground(Color.GREEN);
//        LoadQuestions lq = new LoadQuestions(fp.getPath()[0] + "\\diagnose.txt");
//        quests = lq.getQuestions();
//        for (Question q : quests)
//        {
//            firstCard.add(new JLabel(q.getQuestion()));
//            for (String s : q.getAnswers())
//            {
//                firstCard.add(new JRadioButton(s));
//            }
//        }
//        JButton jj = new JButton("Next");
//        jj.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent event)
//            {
//                cards.next(cardPanel);
//            }
//
//        });
//        firstCard.add(jj);
//Tutorial card
//        JPanel secondCard = new JPanel();
//        secondCard.setBackground(Color.GREEN);
//        LoadTutorial lt = new LoadTutorial();
//        String texto = lt.loadChapter(fp.getPath()[0]+"\\chapters\\chapter0.txt");
//        secondCard.add(new JLabel(texto));
//        JButton jT = new JButton("Next");
//        jT.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent event)
//            {
//                cards.next(cardPanel);
//            }
//
//        });
//        secondCard.add(jT);
//
//    private void addButton(Container parent, String name)
//    {
//        JButton but = new JButton(name);
//        but.setActionCommand(name);
//        parent.add(but);
//    }
//        JButton switchCards = new JButton("Switch Card");
//        switchCards.setActionCommand("Switch Card");
//        switchCards.addActionListener(new ActionListener()
//        {
//            @Override
//            public void actionPerformed(ActionEvent event)
//            {
//                cards.next(cardPanel);
//            }
//
//        });
//        tabsPanel.add(switchCards);

