package ui;

import data.LoadQuestions;
import data.Progression;
import data.Question;
import java.awt.CardLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.util.Arrays;
import java.util.List;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import logic.ValidateTestResult;

public class EvaluationTest extends JPanel {

    int[] answers = new int[20];
    int[] corrects = new int[20];
    int[] chapters = new int[20];
    int index = 0;

    public EvaluationTest() {
    }

    public JPanel evaluation(String path, CardLayout cards, JPanel cardPanel, Progression pro) {
        Arrays.fill(answers, -1);
        JPanel evalCard = new JPanel();
        JPanel pnCentral;

        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        evalCard.setLayout(gbPanel0);

        JPanel Menu = new JPanel();
        GridBagLayout gbMenu = new GridBagLayout();
        GridBagConstraints gbcMenu = new GridBagConstraints();
        Menu.setLayout(gbMenu);

        JButton Button = new JButton("SKIP");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 0;
        gbcMenu.gridwidth = 6;
        gbcMenu.gridheight = 5;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 1;
        gbcMenu.anchor = GridBagConstraints.WEST;

        Button.addActionListener((ActionEvent event)
                -> {
            cardPanel.add(new ShowTutorial().tutorial(path, index, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbMenu.setConstraints(Button, gbcMenu);
        Menu.add(Button);

        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 30;
        gbcPanel0.gridheight = 5;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(Menu, gbcPanel0);

        evalCard.add(Menu);

        pnCentral = new JPanel();
        GridBagLayout gbCentral = new GridBagLayout();
        GridBagConstraints gbcCentral = new GridBagConstraints();
        pnCentral.setLayout(gbCentral);
        JScrollPane scpCentral = new JScrollPane(pnCentral);

        gbcPanel0.gridx = 5;
        gbcPanel0.gridy = GridBagConstraints.RELATIVE;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 20;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 2;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        JPanel scrollable = new JPanel();
        scrollable.setLayout(new BoxLayout(scrollable, BoxLayout.Y_AXIS));

        scrollable.add(new JLabel("\n"));
        scrollable.add(new JLabel("Answer the following questions to validate your knowledge\n"));
        scrollable.add(new JLabel("\n"));

        LoadQuestions lq = new LoadQuestions(path + "\\diagnose.txt");
        List<Question> quests = lq.getQuestions();
        for (int i = 0; i < quests.size(); i++) {
            int questionNumber = i;
            Question q = quests.get(i);
            String s[] = q.getAnswers();
            scrollable.add(new JLabel(q.getQuestion()));
            {
                ButtonGroup radioMenu = new ButtonGroup();
                JRadioButton radioBtn0 = new JRadioButton(s[0]);
                radioBtn0.addActionListener((e)
                        -> {
                    if (radioBtn0.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn0.setSelected(true);
                        answers[questionNumber] = 1;
                    }
                });
                JRadioButton radioBtn1 = new JRadioButton(s[1]);
                radioBtn1.addActionListener((e)
                        -> {
                    if (radioBtn1.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn1.setSelected(true);
                        answers[questionNumber] = 2;
                    }
                });
                JRadioButton radioBtn2 = new JRadioButton(s[2]);
                radioBtn2.addActionListener((e)
                        -> {
                    if (radioBtn2.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn2.setSelected(true);
                        answers[questionNumber] = 3;
                    }
                });
                JRadioButton radioBtn3 = new JRadioButton(s[3]);
                radioBtn3.addActionListener((e)
                        -> {
                    if (radioBtn3.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn3.setSelected(true);
                        answers[questionNumber] = 4;
                    }
                });

                radioMenu.add(radioBtn0);
                radioMenu.add(radioBtn1);
                radioMenu.add(radioBtn2);
                radioMenu.add(radioBtn3);
                scrollable.add(radioBtn0);
                scrollable.add(radioBtn1);
                scrollable.add(radioBtn2);
                scrollable.add(radioBtn3);

            }
            corrects[i] = q.getCorrect();
            chapters[i] = q.getChapter();
        }

        JPanel btnPanel = new JPanel();
        JButton btnNext = new JButton("Next");
        btnNext.addActionListener((ActionEvent event)
                -> {
//            for (int j = 0; j < quests.size(); j++)
//            {
//                System.out.println(answers[j] + " " + corrects[j] + " " + chapters[j]);
//            }
            int temp = new ValidateTestResult().validateEvaluationTest(answers, corrects, chapters, pro);
            cardPanel.add(new ShowEvaluationTestResult().results(path, cards, cardPanel, pro, temp), "evaluationresults");
            cards.show(cardPanel, "evaluationresults");
        });
        btnPanel.add(btnNext);
        scrollable.add(btnPanel);
        pnCentral.add(scrollable);

        gbPanel0.setConstraints(scpCentral, gbcPanel0);
        evalCard.add(scpCentral);

        return evalCard;
    }
}
