package ui;

import data.LoadTutorial;
import data.Progression;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

public class ShowTutorial extends JPanel
{

    JButton bnt0 = new JButton("Chapter  1");
    JButton bnt1 = new JButton("Chapter  2");
    JButton bnt2 = new JButton("Chapter  3");
    JButton bnt3 = new JButton("Chapter  4");
    JButton bnt4 = new JButton("Chapter  5");
    JButton bnt5 = new JButton("Chapter  6");
    JButton bnt6 = new JButton("Chapter  7");
    JButton bnt7 = new JButton("Chapter  8");
    JButton bnt8 = new JButton("Chapter  9");
    JButton bnt9 = new JButton("Chapter 10");
    int chapter;

    public ShowTutorial()
    {
    }

    public JPanel tutorial(String path, int index, CardLayout cards, JPanel cardPanel, Progression pro)
    {
        //Tutorial card
        chapter = index;
        JPanel tutorialCard = new JPanel();

        JPanel Menu;
        JButton Button;
        JButton Button1;
        JPanel ChapText;
        JPanel ChapterList;
        JPanel TutorialText;

        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        tutorialCard.setLayout(gbPanel0);

        //TRATAMENTO DO MENU DE CIMA
        Menu = new JPanel();
        GridBagLayout gbMenu = new GridBagLayout();
        GridBagConstraints gbcMenu = new GridBagConstraints();
        Menu.setLayout(gbMenu);

        Button = new JButton("Do Test");
        gbcMenu.gridx = 0;
        gbcMenu.gridy = 0;
        gbcMenu.gridwidth = 6;
        gbcMenu.gridheight = 5;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 1;
        gbcMenu.anchor = GridBagConstraints.WEST;

        Button.addActionListener((ActionEvent event) ->
        {
//            cardPanel.add(new EndTutorial().EndScreen(tutorialCard, pro), "tutorial");//, answers, corrects, chapter
//            cards.show(cardPanel, "tutorial");

            cardPanel.add(new ChapterTest().chapEvaluation(path, cards, cardPanel, pro, chapter), "chapterevaluation");//, answers, corrects, chapter
            cards.show(cardPanel, "chapterevaluation");
        });

        gbMenu.setConstraints(Button, gbcMenu);
        Menu.add(Button);

        Button1 = new JButton("Progress");
        gbcMenu.gridx = 7;
        gbcMenu.gridy = 0;
        gbcMenu.gridwidth = 6;
        gbcMenu.gridheight = 5;
        gbcMenu.fill = GridBagConstraints.BOTH;
        gbcMenu.weightx = 1;
        gbcMenu.weighty = 1;
        gbcMenu.anchor = GridBagConstraints.WEST;
        gbMenu.setConstraints(Button1, gbcMenu);
        Menu.add(Button1);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 30;
        gbcPanel0.gridheight = 5;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        Button1.addActionListener((ActionEvent event) ->
        {
            cardPanel.add(new ShowProgression().showPro(path, index, cards, cardPanel, pro), "progression");
            cards.show(cardPanel, "progression");
        });

        gbPanel0.setConstraints(Menu, gbcPanel0);

        tutorialCard.add(Menu);

        //FIM DO TRATAMENTO DO MENU DE CIMA
        //TRATAMENTO DA LISTAGEM DOS CAPITULOS
        ChapText = new JPanel();
        GridBagLayout gbChapText = new GridBagLayout();
        GridBagConstraints gbcChapText = new GridBagConstraints();
        ChapText.setLayout(gbChapText);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 7;
        gbcPanel0.gridheight = 4;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 0;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(ChapText, gbcPanel0);
        ChapText.setBackground(Color.BLACK);
        JLabel chapTextList = new JLabel("Chapter List");
        ChapText.add(chapTextList);

        tutorialCard.add(ChapText);

        ChapterList = new JPanel();
        GridBagLayout gbChapterList = new GridBagLayout();
        GridBagConstraints gbcChapterList = new GridBagConstraints();
        ChapterList.setLayout(gbChapterList);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 7;
        gbcPanel0.gridheight = 21;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 0;
        gbcPanel0.weighty = 10;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(ChapterList, gbcPanel0);
        ChapterList.setBackground(Color.WHITE);

        //BUTTONS!
        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 1;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;
        gbcChapterList.insets = new Insets(2, 1, 2, 1);

        bnt0.addActionListener((ActionEvent event) ->
        {
            chapter = 0;
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt0, gbcChapterList);
        ChapterList.add(bnt0);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 4;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt1.addActionListener((ActionEvent event) ->
        {
            chapter = 1;
            cardPanel.add(new ShowTutorial().tutorial(path, 1, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt1, gbcChapterList);
        ChapterList.add(bnt1);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 7;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt2.addActionListener((ActionEvent event) ->
        {
            chapter = 2;
            cardPanel.add(new ShowTutorial().tutorial(path, 2, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt2, gbcChapterList);
        ChapterList.add(bnt2);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 10;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt3.addActionListener((ActionEvent event) ->
        {
            chapter = 3;
            cardPanel.add(new ShowTutorial().tutorial(path, 3, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt3, gbcChapterList);
        ChapterList.add(bnt3);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 13;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt4.addActionListener((ActionEvent event) ->
        {
            chapter = 4;
            cardPanel.add(new ShowTutorial().tutorial(path, 4, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt4, gbcChapterList);
        ChapterList.add(bnt4);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 16;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt5.addActionListener((ActionEvent event) ->
        {
            chapter = 5;
            cardPanel.add(new ShowTutorial().tutorial(path, 5, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt5, gbcChapterList);
        ChapterList.add(bnt5);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 19;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt6.addActionListener((ActionEvent event) ->
        {
            chapter = 6;
            cardPanel.add(new ShowTutorial().tutorial(path, 6, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt6, gbcChapterList);
        ChapterList.add(bnt6);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 21;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt7.addActionListener((ActionEvent event) ->
        {
            chapter = 7;
            cardPanel.add(new ShowTutorial().tutorial(path, 7, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt7, gbcChapterList);
        ChapterList.add(bnt7);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 24;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt8.addActionListener((ActionEvent event) ->
        {
            chapter = 8;
            cardPanel.add(new ShowTutorial().tutorial(path, 8, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt8, gbcChapterList);
        ChapterList.add(bnt8);

        gbcChapterList.gridx = 1;
        gbcChapterList.gridy = 27;
        gbcChapterList.gridwidth = 4;
        gbcChapterList.gridheight = 2;
        gbcChapterList.fill = GridBagConstraints.BOTH;
        gbcChapterList.weightx = 1;
        gbcChapterList.weighty = 1;
        gbcChapterList.anchor = GridBagConstraints.NORTH;

        bnt9.addActionListener((ActionEvent event) ->
        {
            chapter = 9;
            cardPanel.add(new ShowTutorial().tutorial(path, 9, cards, cardPanel, pro), "tutorials");
            cards.show(cardPanel, "tutorials");

        });

        gbChapterList.setConstraints(bnt9, gbcChapterList);
        ChapterList.add(bnt9);

//        gbcPanel0.gridx = 0;
//        gbcPanel0.gridy = 7;
//        gbcPanel0.gridwidth = 7;
//        gbcPanel0.gridheight = 23;
//        gbcPanel0.fill = GridBagConstraints.BOTH;
//        gbcPanel0.weightx = 1;
//        gbcPanel0.weighty = 0;
//        gbcPanel0.anchor = GridBagConstraints.NORTH;
//        gbPanel0.setConstraints(pnPanel1, gbcPanel0);
//        pnPanel0.add(pnPanel1);
        tutorialCard.add(ChapterList);

        //FIM DO TRATAMENTO DA LISTAGEM DOS CAPITULOS
        //TRATAMENTO DO TEXTO DO TUTORIAL
        LoadTutorial lt = new LoadTutorial();
        String texto = lt.loadChapter(path + "\\chapters\\chapter" + index + ".txt");

        TutorialText = new JPanel();
        GridBagLayout gbTutorialText = new GridBagLayout();
        GridBagConstraints gbcTutorialText = new GridBagConstraints();
        TutorialText.setLayout(gbTutorialText);

        JTextArea jta = new JTextArea(texto);
        jta.setEditable(false);
        jta.setWrapStyleWord(true);
        jta.setLineWrap(true);

        gbcTutorialText.gridx = 7;
        gbcTutorialText.gridy = 5;
        gbcTutorialText.gridwidth = 23;
        gbcTutorialText.gridheight = 25;
        gbcTutorialText.fill = GridBagConstraints.BOTH;
        gbcTutorialText.weightx = 8;
        gbcTutorialText.weighty = 1;
        gbcTutorialText.anchor = GridBagConstraints.NORTH;
        gbTutorialText.setConstraints(jta, gbcTutorialText);
        TutorialText.add(jta);

        JScrollPane jsp = new JScrollPane(TutorialText);
        jsp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

        gbcPanel0.gridx = 7;
        gbcPanel0.gridy = 5;
        gbcPanel0.gridwidth = 23;
        gbcPanel0.gridheight = 25;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 8;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        gbPanel0.setConstraints(jsp, gbcPanel0);

        tutorialCard.add(jsp);

        //FIM DO TRATAMENTO DO TEXTO DO TUTORIAL
//        //NEXT BUTTON!
//        JButton btn = new JButton("Next");
//        btn.addActionListener((ActionEvent event) ->
//        {
//            cards.next(cardPanel);
//        });
//        tutorialCard.add(btn);
        return tutorialCard;
    }

}
