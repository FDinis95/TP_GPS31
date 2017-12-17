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

public class ChapterTest {

    int[] answers = new int[20];
    int[] corrects = new int[20];
    int[] chapters = new int[20];
    int index = 0;

    public ChapterTest()
    {
    }

    public JPanel chapEvaluation(String path, CardLayout cards, JPanel cardPanel, Progression pro, int index) {
        Arrays.fill(answers, -1);
        JPanel chapCard = new JPanel();
        JPanel pnCentral;

        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        chapCard.setLayout(gbPanel0);

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
        scrollable.add(new JLabel("Answer the following questions to validate the chapter\n"));
        scrollable.add(new JLabel("\n"));

        System.err.println("chapter path: " + path);
        LoadQuestions lq = new LoadQuestions(path + "\\tests\\chapter" + index + ".txt");
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
                        answers[questionNumber] = 0;
                    }
                });
                JRadioButton radioBtn1 = new JRadioButton(s[1]);
                radioBtn1.addActionListener((e)
                        -> {
                    if (radioBtn1.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn1.setSelected(true);
                        answers[questionNumber] = 1;
                    }
                });
                JRadioButton radioBtn2 = new JRadioButton(s[2]);
                radioBtn2.addActionListener((e)
                        -> {
                    if (radioBtn2.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn2.setSelected(true);
                        answers[questionNumber] = 2;
                    }
                });
                JRadioButton radioBtn3 = new JRadioButton(s[3]);
                radioBtn3.addActionListener((e)
                        -> {
                    if (radioBtn3.isSelected()) {
                        radioMenu.clearSelection();
                        radioBtn3.setSelected(true);
                        answers[questionNumber] = 3;
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

        JButton btnNext = new JButton("Submit");
        btnNext.addActionListener((ActionEvent event)
                -> {
            for (int j = 0; j < quests.size(); j++) {
                System.out.println(answers[j] + " " + corrects[j] + " " + chapters[j]);
            }
            int temp = new ValidateTestResult().validateEvaluationTest(answers, corrects, chapters, pro);
//            cardPanel.add(new ShowChapterTestResult().results(path, cards, cardPanel, pro, temp), "chapresults");
//            cards.show(cardPanel, "chapresults");
        });
        
        JButton btnCancel = new JButton("Cancel");
        btnCancel.addActionListener((ActionEvent event)
                -> {
            
            cardPanel.add(new ShowTutorial().tutorial(path, index, cards, cardPanel, pro), "tutorial");
            cards.show(cardPanel, "tutorial");
        });
        
        btnPanel.add(btnNext);
        btnPanel.add(btnCancel);
        scrollable.add(btnPanel);
        pnCentral.add(scrollable);

        gbPanel0.setConstraints(scpCentral, gbcPanel0);
        chapCard.add(scpCentral);

        return chapCard;
    }
}
