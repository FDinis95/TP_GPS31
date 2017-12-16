package ui;

import data.LoadQuestions;
import data.Progression;
import data.Question;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import logic.ValidateTestResult;

public class EvaluationTest extends JPanel
{

    int[] answers = new int[20];
    int[] corrects = new int[20];
    int[] chapters = new int[20];
    int tempx;

    public EvaluationTest()
    {
    }

    public JPanel evaluation(String path, CardLayout cards, JPanel cardPanel, Progression pro)
    {
        JPanel evalCard = new JPanel();
        evalCard.setBackground(Color.DARK_GRAY);

        JPanel pnBorderW;
        JLabel lbLabel2;
        JPanel pnBorderE;
        JLabel lbLabel3;
        JPanel pnCentral;

        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        evalCard.setLayout(gbPanel0);

        pnBorderW = new JPanel();
        GridBagLayout gbBorderW = new GridBagLayout();
        GridBagConstraints gbcBorderW = new GridBagConstraints();
        pnBorderW.setLayout(gbBorderW);

        lbLabel2 = new JLabel();
        gbcBorderW.gridx = 0;
        gbcBorderW.gridy = 0;
        gbcBorderW.gridwidth = 5;
        gbcBorderW.gridheight = 3;
        gbcBorderW.fill = GridBagConstraints.BOTH;
        gbcBorderW.weightx = 1;
        gbcBorderW.weighty = 1;
        gbcBorderW.anchor = GridBagConstraints.NORTH;
        gbBorderW.setConstraints(lbLabel2, gbcBorderW);
        pnBorderW.add(lbLabel2);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 5;
        gbcPanel0.gridheight = 20;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnBorderW, gbcPanel0);
        evalCard.add(pnBorderW);

        pnBorderE = new JPanel();
        GridBagLayout gbBorderE = new GridBagLayout();
        GridBagConstraints gbcBorderE = new GridBagConstraints();
        pnBorderE.setLayout(gbBorderE);

        lbLabel3 = new JLabel();
        gbcBorderE.gridx = 0;
        gbcBorderE.gridy = 0;
        gbcBorderE.gridwidth = 5;
        gbcBorderE.gridheight = 3;
        gbcBorderE.fill = GridBagConstraints.BOTH;
        gbcBorderE.weightx = 1;
        gbcBorderE.weighty = 1;
        gbcBorderE.anchor = GridBagConstraints.NORTH;
        gbBorderE.setConstraints(lbLabel3, gbcBorderE);
        pnBorderE.add(lbLabel3);
        gbcPanel0.gridx = 15;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 5;
        gbcPanel0.gridheight = 20;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnBorderE, gbcPanel0);
        evalCard.add(pnBorderE);

        pnCentral = new JPanel();
        GridBagLayout gbCentral = new GridBagLayout();
        GridBagConstraints gbcCentral = new GridBagConstraints();
        pnCentral.setLayout(gbCentral);
        JScrollPane scpCentral = new JScrollPane(pnCentral);
        gbcPanel0.gridx = 5;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 20;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 2;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(scpCentral, gbcPanel0);

        JPanel scrollable = new JPanel();
        scrollable.setLayout(new BoxLayout(scrollable, BoxLayout.Y_AXIS));
        
        scrollable.add(new JLabel("Answer the following questionsAnswer the following questionsAnswer the following questionsAnswer the following questions\n"));
        scrollable.add(new JLabel("\n"));
        
        
        System.err.println("Evauliatio path: " + path);
        LoadQuestions lq = new LoadQuestions(path + "\\diagnose.txt");
        List<Question> quests = lq.getQuestions();
        for (int i = 0; i < quests.size(); i++)
//            for (Question q : quests)
        {
            Question q = quests.get(i);
            scrollable.add(new JLabel(q.getQuestion()));
            for (String s : q.getAnswers())
            {
                JRadioButton radioBtn = new JRadioButton(s);
                //this must be group buttons
                radioBtn.addActionListener((e) ->
                {
                    if (radioBtn.isSelected())
                    //codigo para escolher um dos botoes
                    {
                        tempx = 1;
                    }

                });
                scrollable.add(radioBtn);

            }

            corrects[i] = q.getCorrect();
            chapters[i] = q.getChapter();
            answers[i] = 2;
        }



        JButton btn = new JButton("Skip");
        btn.addActionListener((ActionEvent event) ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, cards, cardPanel), "tutorials");
            cards.show(cardPanel, "tutorials");

        });
        scrollable.add(btn);

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener((ActionEvent event) ->
        {
            int temp = new ValidateTestResult().validateEvaluationTest(answers, corrects, chapters, pro);
            cardPanel.add(new ShowEvaluationTestResult().results(path, cards, cardPanel, pro, temp), "evaluationresults");
            cards.show(cardPanel, "evaluationresults");
        });
        scrollable.add(btnNext);
        pnCentral.add(scrollable);

        evalCard.add(scpCentral);

        return evalCard;
    }

}
