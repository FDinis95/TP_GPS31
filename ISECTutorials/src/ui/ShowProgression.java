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
import org.knowm.xchart.PieChart;
import org.knowm.xchart.PieChartBuilder;
import org.knowm.xchart.XChartPanel;
import org.knowm.xchart.style.PieStyler;
import org.knowm.xchart.style.Styler.ChartTheme;

public class ShowProgression
{

    JPanel pnProgression;
    JPanel pnPanel1;
    JPanel pnPanel2;
    JPanel pnPanel3;
    JPanel pnPanel5;
    JPanel pnPanel6;
    JButton btReturn;
    Helper help;
    String[] stars;

    public ShowProgression()
    {
    }

    public JPanel showPro(String path, int index, CardLayout cards, JPanel cardPanel, Progression pro)
    {

        pnProgression = new JPanel();
        GridBagLayout gbProgression = new GridBagLayout();
        GridBagConstraints gbcProgression = new GridBagConstraints();
        pnProgression.setLayout(gbProgression);

        pnPanel1 = new JPanel();
        GridBagLayout gbPanel1 = new GridBagLayout();
        GridBagConstraints gbcPanel1 = new GridBagConstraints();
        pnPanel1.setLayout(gbPanel1);
        gbcProgression.gridx = 0;
        gbcProgression.gridy = 0;
        gbcProgression.gridwidth = 20;
        gbcProgression.gridheight = 3;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;

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

        gbProgression.setConstraints(pnPanel1, gbcProgression);
        pnProgression.add(pnPanel1);

        pnPanel2 = new JPanel();
        GridBagLayout gbPanel2 = new GridBagLayout();
        GridBagConstraints gbcPanel2 = new GridBagConstraints();
        pnPanel2.setLayout(gbPanel2);
        gbcProgression.gridx = 0;
        gbcProgression.gridy = 3;
        gbcProgression.gridwidth = 20;
        gbcProgression.gridheight = 5;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;

        int[] chapters = pro.getChapter();
        int var = 0;
        for (int i = 0; i < 10; i++)
        {
            var += chapters[i];
        }

        JLabel text = new JLabel(var + " chapters unlocked!");
        pnPanel2.add(text);
        
        gbProgression.setConstraints(pnPanel2, gbcProgression);
        pnProgression.add(pnPanel2);

        pnPanel3 = new JPanel();
        GridBagLayout gbPanel3 = new GridBagLayout();
        GridBagConstraints gbcPanel3 = new GridBagConstraints();
        pnPanel3.setLayout(gbPanel3);
        gbcProgression.gridx = 0;
        gbcProgression.gridy = 8;
        gbcProgression.gridwidth = 20;
        gbcProgression.gridheight = 3;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;

        JLabel lbMessage = new JLabel(help.messages(pro));
        lbMessage.setForeground(Color.DARK_GRAY);

        pnPanel3.add(lbMessage);

        gbProgression.setConstraints(pnPanel3, gbcProgression);
        pnProgression.add(pnPanel3);

        pnPanel5 = new JPanel();
        GridBagLayout gbPanel5 = new GridBagLayout();
        GridBagConstraints gbcPanel5 = new GridBagConstraints();
        pnPanel5.setLayout(gbPanel5);
        gbcProgression.gridx = 0;
        gbcProgression.gridy = 11;
        gbcProgression.gridwidth = 10;
        gbcProgression.gridheight = 9;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;

        PieChart chart = new PieChartBuilder().width(400).height(300).title("Results").theme(ChartTheme.GGPlot2).build();
        chart.getStyler().setLegendVisible(false);
        chart.getStyler().setAnnotationType(PieStyler.AnnotationType.LabelAndPercentage);
        chart.getStyler().setAnnotationDistance(1.15);
        chart.getStyler().setPlotContentSize(.7);
        chart.getStyler().setStartAngleInDegrees(90);
        
        if(pro.getCorrect() == 0)
            chart.setTitle("Ainda não ha resultados!");

        chart.addSeries("Right", pro.getCorrect());
        chart.addSeries("Wrong", (pro.getTotalNumberOfQuestionsAnswered() - pro.getCorrect()));

        JPanel chartPanel = new XChartPanel(chart);
        pnPanel5.add(chartPanel);

        gbProgression.setConstraints(pnPanel5, gbcProgression);
        pnProgression.add(pnPanel5);

        pnPanel6 = new JPanel();
        GridBagLayout gbPanel6 = new GridBagLayout();
        GridBagConstraints gbcPanel6 = new GridBagConstraints();
        pnPanel6.setLayout(gbPanel6);

        btReturn = new JButton("Return");
        gbcPanel6.gridx = 6;
        gbcPanel6.gridy = 6;
        gbcPanel6.gridwidth = 3;
        gbcPanel6.gridheight = 2;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;

        btReturn.addActionListener((ActionEvent event)
                ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, index, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.show(cardPanel, "tutorial");
        });

        gbPanel6.setConstraints(btReturn, gbcPanel6);
        pnPanel6.add(btReturn);

        JLabel lbCorrect = new JLabel("Number of correct answers: " + pro.getCorrect());
        lbCorrect.setForeground(Color.GREEN);
        gbcPanel6.gridx = 1;
        gbcPanel6.gridy = 1;
        gbcPanel6.gridwidth = 8;
        gbcPanel6.gridheight = 2;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 1;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints(lbCorrect, gbcPanel6);
        pnPanel6.add(lbCorrect);

        JLabel lbTotal = new JLabel("Total number of questions answered: " + pro.getTotalNumberOfQuestionsAnswered());
        lbTotal.setForeground(Color.BLUE);
        gbcPanel6.gridx = 1;
        gbcPanel6.gridy = 3;
        gbcPanel6.gridwidth = 8;
        gbcPanel6.gridheight = 2;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 1;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints(lbTotal, gbcPanel6);
        pnPanel6.add(lbTotal);
        gbcProgression.gridx = 10;
        gbcProgression.gridy = 11;
        gbcProgression.gridwidth = 10;
        gbcProgression.gridheight = 9;
        gbcProgression.fill = GridBagConstraints.BOTH;
        gbcProgression.weightx = 1;
        gbcProgression.weighty = 1;
        gbcProgression.anchor = GridBagConstraints.NORTH;
        gbProgression.setConstraints(pnPanel6, gbcProgression);
        pnProgression.add(pnPanel6);

        return pnProgression;
    }

}
