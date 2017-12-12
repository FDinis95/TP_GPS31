package ui;

import data.LoadTutorial;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class ShowTutorial extends JPanel
{

    public ShowTutorial()
    {
    }
    
    public JPanel tutorial(String path, CardLayout cards, JPanel cardPanel){
            //Tutorial card
        JPanel tutorialCard = new JPanel();
        tutorialCard.setBackground(Color.GREEN);
        LoadTutorial lt = new LoadTutorial();
        String texto = lt.loadChapter(path+"\\chapters\\chapter0.txt");
        tutorialCard.add(new JLabel(texto));
        JButton btn = new JButton("Next");
        btn.addActionListener((ActionEvent event) ->
        {
            cards.next(cardPanel);
        });
        tutorialCard.add(btn);
        return tutorialCard;
    }
    
}
