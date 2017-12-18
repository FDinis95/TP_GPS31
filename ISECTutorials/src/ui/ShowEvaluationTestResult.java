package ui;

import logic.Helper;
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
import javax.swing.JProgressBar;

public class ShowEvaluationTestResult extends JPanel {
    
    JPanel pnEvaluationTest;
    JPanel pnPanel1;
    JPanel pnPanel2;
    JPanel pnPanel3;
    JPanel pnPanel5;
    JPanel pnPanel6;
    JButton btNext;
    JProgressBar pbProgressBar;
    Helper help;
    String[] stars;

    public ShowEvaluationTestResult() {
    }

    public JPanel results(String path, CardLayout cards, JPanel cardPanel, Progression pro, int result) {

////Calcular Número de estrelas completas ou incompletas

pnEvaluationTest = new JPanel();
        GridBagLayout gbEvaluationTest = new GridBagLayout();
        GridBagConstraints gbcEvaluationTest = new GridBagConstraints();
        pnEvaluationTest.setLayout(gbEvaluationTest);

        pnPanel1 = new JPanel();
        GridBagLayout gbPanel1 = new GridBagLayout();
        GridBagConstraints gbcPanel1 = new GridBagConstraints();
        pnPanel1.setLayout(gbPanel1);
        gbcEvaluationTest.gridx = 0;
        gbcEvaluationTest.gridy = 0;
        gbcEvaluationTest.gridwidth = 20;
        gbcEvaluationTest.gridheight = 3;
        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
        gbcEvaluationTest.weightx = 1;
        gbcEvaluationTest.weighty = 1;
        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;
        gbEvaluationTest.setConstraints(pnPanel1, gbcEvaluationTest);
        pnEvaluationTest.add(pnPanel1);

        pnPanel2 = new JPanel();
        GridBagLayout gbPanel2 = new GridBagLayout();
        GridBagConstraints gbcPanel2 = new GridBagConstraints();
        pnPanel2.setLayout(gbPanel2);
        gbcEvaluationTest.gridx = 0;
        gbcEvaluationTest.gridy = 3;
        gbcEvaluationTest.gridwidth = 20;
        gbcEvaluationTest.gridheight = 5;
        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
        gbcEvaluationTest.weightx = 1;
        gbcEvaluationTest.weighty = 1;
        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;

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

        pnPanel2.add(str1);
        pnPanel2.add(str2);
        pnPanel2.add(str3);
        pnPanel2.add(str4);
        pnPanel2.add(str5);

        gbEvaluationTest.setConstraints(pnPanel2, gbcEvaluationTest);
        pnEvaluationTest.add(pnPanel2);

        pnPanel3 = new JPanel();
        GridBagLayout gbPanel3 = new GridBagLayout();
        GridBagConstraints gbcPanel3 = new GridBagConstraints();
        pnPanel3.setLayout(gbPanel3);
        gbcEvaluationTest.gridx = 0;
        gbcEvaluationTest.gridy = 8;
        gbcEvaluationTest.gridwidth = 20;
        gbcEvaluationTest.gridheight = 3;
        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
        gbcEvaluationTest.weightx = 1;
        gbcEvaluationTest.weighty = 1;
        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;

        
        gbEvaluationTest.setConstraints(pnPanel3, gbcEvaluationTest);
        pnEvaluationTest.add(pnPanel3);

        pnPanel5 = new JPanel();
        GridBagLayout gbPanel5 = new GridBagLayout();
        GridBagConstraints gbcPanel5 = new GridBagConstraints();
        pnPanel5.setLayout(gbPanel5);
        gbcEvaluationTest.gridx = 0;
        gbcEvaluationTest.gridy = 11;
        gbcEvaluationTest.gridwidth = 10;
        gbcEvaluationTest.gridheight = 9;
        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
        gbcEvaluationTest.weightx = 1;
        gbcEvaluationTest.weighty = 1;
        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;
        gbEvaluationTest.setConstraints(pnPanel5, gbcEvaluationTest);
        pnEvaluationTest.add(pnPanel5);

        pnPanel6 = new JPanel();
        GridBagLayout gbPanel6 = new GridBagLayout();
        GridBagConstraints gbcPanel6 = new GridBagConstraints();
        pnPanel6.setLayout(gbPanel6);

        btNext = new JButton("Next");
        gbcPanel6.gridx = 6;
        gbcPanel6.gridy = 6;
        gbcPanel6.gridwidth = 3;
        gbcPanel6.gridheight = 2;
        gbcPanel6.fill = GridBagConstraints.BOTH;
        gbcPanel6.weightx = 1;
        gbcPanel6.weighty = 0;
        gbcPanel6.anchor = GridBagConstraints.NORTH;
        gbPanel6.setConstraints(btNext, gbcPanel6);
        pnPanel6.add(btNext);

        JLabel lbCorrect = new JLabel("Number of correct answers: " + result);
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

        JLabel lbTotal = new JLabel("Total number of questions answered: 20");
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
        gbcEvaluationTest.gridx = 10;
        gbcEvaluationTest.gridy = 11;
        gbcEvaluationTest.gridwidth = 10;
        gbcEvaluationTest.gridheight = 9;
        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
        gbcEvaluationTest.weightx = 1;
        gbcEvaluationTest.weighty = 1;
        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;
        gbEvaluationTest.setConstraints(pnPanel6, gbcEvaluationTest);
        pnEvaluationTest.add(pnPanel6);
//
//        pbProgressBar = new JProgressBar(0, 20);
//        pbProgressBar.setValue(result);
//        gbcEvaluationTest.gridx = 6;
//        gbcEvaluationTest.gridy = 1;
//        gbcEvaluationTest.gridwidth = 9;
//        gbcEvaluationTest.gridheight = 2;
//        gbcEvaluationTest.fill = GridBagConstraints.BOTH;
//        gbcEvaluationTest.weightx = 1;
//        gbcEvaluationTest.weighty = 1;
//        gbcEvaluationTest.anchor = GridBagConstraints.NORTH;
//        gbEvaluationTest.setConstraints( pbProgressBar, gbcEvaluationTest );
//        pnEvaluationTest.add(pbProgressBar);




        btNext.addActionListener((ActionEvent event)
                -> {
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });


        return pnEvaluationTest;
    }

//    public void ShowStars(JPanel resultCard, Progression pro, Helper help) {
////        Verificar capítulos concluídos Helper     
//        String stars[];
//        stars = help.fillStars(pro);
//        //Criar labels das imagens
//        JLabel str1 = new JLabel("");
//        str1.setBounds(5, 5, 5, 5);
//        JLabel str2 = new JLabel("");
//        str2.setBounds(10, 10, 5, 5);
//        JLabel str3 = new JLabel("");
//        str3.setBounds(15, 15, 5, 5);
//        JLabel str4 = new JLabel("");
//        str4.setBounds(20, 15, 5, 5);
//        JLabel str5 = new JLabel("");
//        str5.setBounds(25, 15, 5, 5);
//
//        str1.setIcon(new ImageIcon(stars[0]));
//        str2.setIcon(new ImageIcon(stars[1]));
//        str3.setIcon(new ImageIcon(stars[2]));
//        str4.setIcon(new ImageIcon(stars[3]));
//        str5.setIcon(new ImageIcon(stars[4]));
//             System.out.println(stars[0]);
//              System.out.println(stars[1]);
//               System.out.println(stars[2]);
//                System.out.println(stars[3]);
//                 System.out.println(stars[4]);
//                 System.out.println(pro.getCorrect());
//        resultCard.add(str1);
//        resultCard.add(str2);
//        resultCard.add(str3);
//        resultCard.add(str4);
//        resultCard.add(str5);
//    }
}
