package ui;

import logic.Helper;
import data.Progression;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ShowEvaluationTestResult extends JPanel
{

    JPanel pnPanel0;
    JPanel pnHeader;
    JPanel pnStars;
    JPanel pnMessage;
    JPanel pnProgression;
    JProgressBar pbProgressBar1;
    JLabel lbCorrect;
    JLabel lbTotal;
    JPanel pnPanel6;
    JButton btContinue;

    Helper help;
    String[] stars;

    public ShowEvaluationTestResult()
    {
    }

    public JPanel results(String path, CardLayout cards, JPanel cardPanel, Progression pro, int result)
    {
        pnPanel0 = new JPanel();
        GridBagLayout gbPanel0 = new GridBagLayout();
        GridBagConstraints gbcPanel0 = new GridBagConstraints();
        pnPanel0.setLayout(gbPanel0);

        pnHeader = new JPanel();
        GridBagLayout gbHeader = new GridBagLayout();
        GridBagConstraints gbcHeader = new GridBagConstraints();
        pnHeader.setLayout(gbHeader);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 0;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnHeader, gbcPanel0);
        pnPanel0.add(pnHeader);

        pnStars = new JPanel();
        GridBagLayout gbStars = new GridBagLayout();
        GridBagConstraints gbcStars = new GridBagConstraints();
        pnStars.setLayout(gbStars);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 3;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 6;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
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

        pnStars.add(str1);
        pnStars.add(str2);
        pnStars.add(str3);
        pnStars.add(str4);
        pnStars.add(str5);
        
        gbcStars.insets = new Insets( 10,0,10,0 );

        gbPanel0.setConstraints(pnStars, gbcPanel0);
        pnPanel0.add(pnStars);

        pnMessage = new JPanel();
        GridBagLayout gbMessage = new GridBagLayout();
        GridBagConstraints gbcMessage = new GridBagConstraints();
        pnMessage.setLayout(gbMessage);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 9;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        
        JLabel text =  new JLabel(help.messages(pro));
        pnMessage.add(text);
        
        gbcMessage.insets = new Insets(20, 0, 20, 0);
        
        gbPanel0.setConstraints(pnMessage, gbcPanel0);
        pnPanel0.add(pnMessage);

        pnProgression = new JPanel();
        GridBagLayout gbProgression = new GridBagLayout();
        GridBagConstraints gbcProgression = new GridBagConstraints();
        pnProgression.setLayout(gbProgression);

        pbProgressBar1 = new JProgressBar(0, 20);
        pbProgressBar1.setValue(result);

        gbcProgression.gridx = 4;
        gbcProgression.gridy = 2;
        gbcProgression.gridwidth = 12;
        gbcProgression.gridheight = 1;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 0;
        gbcProgression.anchor = GridBagConstraints.NORTH;

        gbcProgression.insets = new Insets(10, 0, 10, 0);

        gbProgression.setConstraints(pbProgressBar1, gbcProgression);
        pnProgression.add(pbProgressBar1);

        lbCorrect = new JLabel("Correct: " + result);
        lbCorrect.setForeground(Color.GREEN);
        gbcProgression.gridx = 0;
        gbcProgression.gridy = 2;
        gbcProgression.gridwidth = 4;
        gbcProgression.gridheight = 1;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;
        gbcProgression.insets = new Insets(0, 100, 0, 0);
        gbProgression.setConstraints(lbCorrect, gbcProgression);
        pnProgression.add(lbCorrect);

        lbTotal = new JLabel("Total: 20");
        gbcProgression.gridx = 16;
        gbcProgression.gridy = 2;
        gbcProgression.gridwidth = 4;
        gbcProgression.gridheight = 1;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;
        gbcProgression.insets = new Insets(0, 100, 0, 0);
        gbProgression.setConstraints(lbTotal, gbcProgression);
        pnProgression.add(lbTotal);

        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 12;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 5;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;
        gbPanel0.setConstraints(pnProgression, gbcPanel0);
        pnPanel0.add(pnProgression);

        pnPanel6 = new JPanel();
        GridBagLayout gbPanel6 = new GridBagLayout();
        GridBagConstraints gbcPanel6 = new GridBagConstraints();
        pnPanel6.setLayout(gbPanel6);

        btContinue = new JButton("Continue");
        gbcPanel6.gridx = 14;
        gbcPanel6.gridy = 0;
        gbcPanel6.gridwidth = 6;
        gbcPanel6.gridheight = 3;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;

        gbcPanel6.insets = new Insets(20, 100, 20, 100);

        gbPanel6.setConstraints(btContinue, gbcPanel6);
        pnPanel6.add(btContinue);
        gbcPanel0.gridx = 0;
        gbcPanel0.gridy = 17;
        gbcPanel0.gridwidth = 20;
        gbcPanel0.gridheight = 3;
        gbcPanel0.fill = GridBagConstraints.BOTH;
        gbcPanel0.weightx = 1;
        gbcPanel0.weighty = 0;
        gbcPanel0.anchor = GridBagConstraints.NORTH;

        btContinue.addActionListener((ActionEvent event)
                ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });

        gbPanel0.setConstraints(pnPanel6, gbcPanel0);
        pnPanel0.add(pnPanel6);

        return pnPanel0;
    }
}
