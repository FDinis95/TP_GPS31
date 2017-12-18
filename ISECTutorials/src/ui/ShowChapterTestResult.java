package ui;

import data.Progression;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.Helper;
import logic.VerifyEndTutorial;

public class ShowChapterTestResult
{

    public ShowChapterTestResult()
    {
    }

    public JPanel chapterResults(String path, CardLayout cards, JPanel cardPanel, Progression pro, int result, int index)
    {
        JPanel resultPanel;
        JPanel pnPanel1;
        JPanel pnPanel2;
        JPanel pnPanel3;
        JPanel pnButtonPanel;
        JButton btReturn;
        JButton btNext;
        JPanel pnPanel9;
        Helper help;
        String[] stars;

        resultPanel = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        resultPanel.setLayout(gbPanel0);

        pnPanel1 = new JPanel();
        GridBagLayout gbPanel1 = new GridBagLayout();
        GridBagConstraints gbcPanel1 = new GridBagConstraints();
        pnPanel1.setLayout(gbPanel1);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 4;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        help = new Helper();
        stars = help.fillStars(pro);
        //Criar labels das imagens
        JLabel str1 = new JLabel("");
        str1.setBounds(5, 5, 5, 5);
        JLabel str2 = new JLabel("");
        str2.setBounds(10, 10, 5, 5);
        JLabel str3 = new JLabel("");
        str3.setBounds(15, 15, 5, 5);
        JLabel str4 = new JLabel("");
        str4.setBounds(20, 15, 5, 5);
        JLabel str5 = new JLabel("");
        str5.setBounds(25, 15, 5, 5);

        str1.setIcon(new ImageIcon(stars[0]));
        str2.setIcon(new ImageIcon(stars[1]));
        str3.setIcon(new ImageIcon(stars[2]));
        str4.setIcon(new ImageIcon(stars[3]));
        str5.setIcon(new ImageIcon(stars[4]));

        pnPanel1.add(str1);
        pnPanel1.add(str2);
        pnPanel1.add(str3);
        pnPanel1.add(str4);
        pnPanel1.add(str5);

        gbPanel0.setConstraints(pnPanel1, gbcPanel0);
        resultPanel.add(pnPanel1);

        pnPanel2 = new JPanel();
        GridBagLayout gbPanel2 = new GridBagLayout();
        GridBagConstraints gbcPanel2 = new GridBagConstraints();
        pnPanel2.setLayout(gbPanel2);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 4;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 7;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        JLabel lbMessageStats = new JLabel(help.messages(pro) + "\n");
        lbMessageStats.setForeground(Color.DARK_GRAY);
        pnPanel2.add(lbMessageStats);

        gbPanel0.setConstraints(pnPanel2, gbcPanel0);
        resultPanel.add(pnPanel2);

        pnPanel3 = new JPanel();
        GridBagLayout gbPanel3 = new GridBagLayout();
        GridBagConstraints gbcPanel3 = new GridBagConstraints();
        pnPanel3.setLayout(gbPanel3);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 11;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 6;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        if (result > 3)
        {
            JLabel lbMessage = new JLabel("Nice! You got " + result + " answers correct from a total of 7!");
            lbMessage.setForeground(Color.GREEN);
            pnPanel3.add(lbMessage);

        } else
        {
            JLabel lbMessage = new JLabel("Ooops! You got " + result + " answers correct from a total of 7! Try again!");
            lbMessage.setForeground(Color.RED);
            pnPanel3.add(lbMessage);
        }

        gbPanel0.setConstraints(pnPanel3, gbcPanel0);
        resultPanel.add(pnPanel3);

        pnButtonPanel = new JPanel();
        GridBagLayout gbButtonPanel = new GridBagLayout();
        GridBagConstraints gbcButtonPanel = new GridBagConstraints();
        pnButtonPanel.setLayout(gbButtonPanel);

        btReturn = new JButton("Return");
        gbcButtonPanel.gridx = 0;
        gbcButtonPanel.gridy = 0;
        gbcButtonPanel.gridwidth = 5;
        gbcButtonPanel.gridheight = 3;
        gbcButtonPanel.fill = GridBagConstraints.BOTH;
        gbcButtonPanel.weightx = 1;
        gbcButtonPanel.weighty = 0;
        gbcButtonPanel.anchor = GridBagConstraints.NORTH;

        btReturn.addActionListener((ActionEvent event)
                ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, index, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });

        gbButtonPanel.setConstraints(btReturn, gbcButtonPanel);
        pnButtonPanel.add(btReturn);

        btNext = new JButton("Next");
        gbcButtonPanel.gridx = 5;
        gbcButtonPanel.gridy = 0;
        gbcButtonPanel.gridwidth = 5;
        gbcButtonPanel.gridheight = 3;
        gbcButtonPanel.fill = GridBagConstraints.BOTH;
        gbcButtonPanel.weightx = 1;
        gbcButtonPanel.weighty = 0;
        gbcButtonPanel.anchor = GridBagConstraints.NORTH;

        btNext.addActionListener((ActionEvent event)
                ->
        {
            VerifyEndTutorial end = new VerifyEndTutorial();
            Boolean temp = end.verify(pro);
            if (temp)
            {
//                cardPanel.add(new EndTutorial().endScreen(cards, pro), "end"); //CHECK CHAPTER LOCKED
//                cards.next(cardPanel);
            }
            else{
            cardPanel.add(new ShowTutorial().tutorial(path, index + 1, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
            }
        });

        gbButtonPanel.setConstraints(btNext, gbcButtonPanel);
        pnButtonPanel.add(btNext);
        gbcPanel0.gridx = 10;
        gbcPanel0.gridy = 17;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnButtonPanel, gbcPanel0);
        resultPanel.add(pnButtonPanel);

        pnPanel9 = new JPanel();
        GridBagLayout gbPanel9 = new GridBagLayout();
        GridBagConstraints gbcPanel9 = new GridBagConstraints();
        pnPanel9.setLayout(gbPanel9);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 17;
        gbcPanel0.gridwidth = 10;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 1;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnPanel9, gbcPanel0);
        resultPanel.add(pnPanel9);

        return resultPanel;
    }

}
