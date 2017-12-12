package ui;

import data.LoadQuestions;
import data.Progression;
import data.Question;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
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
    {//int answers[], int corrects[], int chapter[]
        JPanel evalCard = new JPanel();
        evalCard.setBackground(Color.DARK_GRAY);
        System.err.println("Evauliatio path: " + path);
        LoadQuestions lq = new LoadQuestions(path + "\\diagnose.txt");
        List<Question> quests = lq.getQuestions();
        for (int i = 0; i < quests.size(); i++)
//            for (Question q : quests)
        {
            Question q = quests.get(i);
            evalCard.add(new JLabel(q.getQuestion()));
            for (String s : q.getAnswers())
            {
                JRadioButton radioBtn = new JRadioButton(s);
                radioBtn.addActionListener((e) ->
                {
                    if (radioBtn.isSelected())
                    //codigo para escolher um dos botoes
                    {
                        tempx = 1;
                    }

                });

                evalCard.add(radioBtn);

            }
            corrects[i] = q.getCorrect();
            chapters[i] = q.getChapter();
            answers[i] = 2;
        }
//        for (int j = 0; j < 20; j++)
//        {
//            System.err.println("ans" + answers[j]);
//            System.err.println("chap" + chapters[j]);
//            System.err.println("corr" + corrects[j]);
//        }

        JButton btn = new JButton("Skip");
        btn.addActionListener((ActionEvent event) ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, cards, cardPanel), "tutorials");
            cards.show(cardPanel, "tutorials");

        });
        evalCard.add(btn);

        JButton btnNext = new JButton("Next");
        btnNext.addActionListener((ActionEvent event) ->
        {
            int temp = new ValidateTestResult().validateEvaluationTest(answers, corrects, chapters, pro);
            cardPanel.add(new ShowEvaluationTestResult().results(path, cards, cardPanel, pro, temp), "evaluationresults");
            cards.show(cardPanel, "evaluationresults");
        });
        evalCard.add(btnNext);

        return evalCard;
    }

}
