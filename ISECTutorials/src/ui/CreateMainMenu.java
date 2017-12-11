package ui;

import data.FindPath;
import data.LoadQuestions;
import data.LoadTutorial;
import data.Question;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class CreateMainMenu extends JFrame
{

    JFrame frame;
    JPanel cardPanel;
    CardLayout cards;
    String layoutName = "";
    String path = "";
    

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

        JPanel tabsPanel = new JPanel();
        tabsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        tabsPanel.add(new JLabel("Select a language: "));
        JButton switchCards = new JButton("Switch Card");
        switchCards.setActionCommand("Switch Card");
        switchCards.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                cards.next(cardPanel);
            }

        });
        tabsPanel.add(switchCards);

        frame.add(tabsPanel, BorderLayout.NORTH);

        cardPanel = new JPanel();
        cards = new CardLayout();

        cardPanel.setLayout(cards);
        cards.show(cardPanel, "main");

        //Main menu card
        JPanel centralPanel = new JPanel();
        FindPath fp = new FindPath();
        centralPanel.setBackground(Color.red);
        for (String buttons : fp.getName())
        {
            JButton btn = new JButton(buttons);
            btn.addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent e)
                {
                    layoutName = buttons;
                    System.out.println(layoutName);
                    cards.show(cardPanel, "Fruits");
                }
            });

            centralPanel.add(btn);
        }

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
        
        path = fp.getPath()[0];
        cardPanel.add(new EvaluationTest().evaluation(path, cards, cardPanel), "Veggies");
        cardPanel.add(new ShowTutorial().tutorial(path, cards, cardPanel), "Fruits");
        
        cardPanel.add(centralPanel, layoutName);

        frame.add(tabsPanel, BorderLayout.NORTH);
        frame.add(cardPanel, BorderLayout.CENTER);

        frame.setVisible(true);

    }

    private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        parent.add(but);
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
