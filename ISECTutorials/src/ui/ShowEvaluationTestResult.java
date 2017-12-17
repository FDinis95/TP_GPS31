package ui;

import data.Progression;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ShowEvaluationTestResult extends JPanel
{

    public ShowEvaluationTestResult()
    {
    }

    public JPanel results(String path, CardLayout cards, JPanel cardPanel, Progression pro, int result)
    {
        JPanel resultCard = new JPanel();
        resultCard.setBackground(Color.GREEN);
        
        resultCard.add(new JLabel("this will be resutls!"));
        
        JProgressBar progress =  new JProgressBar(0, 20);
        progress.setValue(result);
        resultCard.add(progress);

        JButton btn = new JButton("Next");
        btn.addActionListener((ActionEvent event) ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });
        resultCard.add(btn);

        return resultCard;
    }

}
