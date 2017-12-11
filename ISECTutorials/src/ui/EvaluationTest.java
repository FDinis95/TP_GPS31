/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import data.LoadQuestions;
import data.LoadTutorial;
import data.Question;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author simao
 */
public class EvaluationTest extends JPanel
{

    public EvaluationTest()
    {
    }
    
    public JPanel evaluation(String path, CardLayout cards, JPanel cardPanel){
        JPanel firstCard = new JPanel();
        firstCard.setBackground(Color.GREEN);
        LoadQuestions lq = new LoadQuestions(path + "\\diagnose.txt");
        List<Question> quests = lq.getQuestions();
        for (Question q : quests)
        {
            firstCard.add(new JLabel(q.getQuestion()));
            for (String s : q.getAnswers())
            {
                firstCard.add(new JRadioButton(s));
            }
        }
        JButton jj = new JButton("Next");
        jj.addActionListener((ActionEvent event) ->
        {
            cards.next(cardPanel);
        });
        firstCard.add(jj);
        
        return firstCard;
    }
    
}
