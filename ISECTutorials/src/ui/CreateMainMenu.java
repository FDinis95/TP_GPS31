package ui;

import data.FindPath;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CreateMainMenu extends JFrame
{

    JFrame frame;
    JPanel cardPanel;
    CardLayout cards;
    String layoutName = "";

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
                    cards.show(cardPanel, layoutName);
                }
            });

            centralPanel.add(btn);
        }

        JPanel firstCard = new JPanel();
        firstCard.setBackground(Color.GREEN);
        addButton(firstCard, "APPLES");
        addButton(firstCard, "ORANGES");
        addButton(firstCard, "BANANAS");

        JPanel secondCard = new JPanel();
        secondCard.setBackground(Color.BLUE);
        addButton(secondCard, "LEEKS");
        addButton(secondCard, "TOMATOES");
        addButton(secondCard, "PEAS");

        cardPanel.add(firstCard, "Fruits");
        cardPanel.add(secondCard, "Veggies");
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
