/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.LoadTutorial;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author simao
 */
public class ShowTutorial extends JPanel
{

    public ShowTutorial()
    {
    }
    
    public JPanel tutorial(String path, CardLayout cards, JPanel cardPanel){
            //Tutorial card
        JPanel secondCard = new JPanel();
        secondCard.setBackground(Color.GREEN);
        LoadTutorial lt = new LoadTutorial();
        String texto = lt.loadChapter(path+"\\chapters\\chapter0.txt");
        secondCard.add(new JLabel(texto));
        JButton jT = new JButton("Next");
        jT.addActionListener((ActionEvent event) ->
        {
            cards.next(cardPanel);
        });
        secondCard.add(jT);
        return secondCard;
    }
    
}
