/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author simao
 */
public class TestingCardLayout
{

    JFrame guiFrame;
    CardLayout cards;
    JPanel cardPanel;

    public TestingCardLayout()
    {
        guiFrame = new JFrame();

        //make sure the program exits when the frame closes
        guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiFrame.setTitle("CardLayout Example");
        guiFrame.setSize(400, 300);

        //This will center the JFrame in the middle of the screen
        guiFrame.setLocationRelativeTo(null);
        guiFrame.setLayout(new BorderLayout());

        JPanel tabsPanel = new JPanel();
        tabsPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        
        
        
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

        guiFrame.add(tabsPanel, BorderLayout.NORTH);

        cards = new CardLayout();
        cardPanel = new JPanel();
        cardPanel.setLayout(cards);
        cards.show(cardPanel, "Fruits");

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

        guiFrame.add(tabsPanel, BorderLayout.NORTH);
        guiFrame.add(cardPanel, BorderLayout.CENTER);
        guiFrame.setVisible(true);
    }

    //All the buttons are following the same pattern
    //so create them all in one place.
    private void addButton(Container parent, String name)
    {
        JButton but = new JButton(name);
        but.setActionCommand(name);
        parent.add(but);
    }
}
