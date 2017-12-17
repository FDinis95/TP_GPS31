package ui;

import logic.Helper;
import data.Progression;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class ShowEvaluationTestResult extends JPanel {

    public ShowEvaluationTestResult() {
    }

    public JPanel results(String path, CardLayout cards, JPanel cardPanel, Progression pro, int result) {
        JPanel resultCard = new JPanel();
        resultCard.setBackground(Color.GREEN);
        Helper help = new Helper();

        ShowStars(resultCard, pro, help);
        resultCard.add(new JLabel("this will be resutls!"));
        JProgressBar progress = new JProgressBar(0, 20);
        progress.setValue(result);
        resultCard.add(progress);

////Calcular Número de estrelas completas ou incompletas
        int total = pro.getTotalNumberOfQuestionsAnswered();

        JButton btn = new JButton("Next");
        btn.addActionListener((ActionEvent event)
                -> {
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel, pro), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });

        resultCard.add(btn);

        return resultCard;
    }

    public void ShowStars(JPanel resultCard, Progression pro, Helper help) {
//        Verificar capítulos concluídos Helper     
        String stars[];
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
//             System.out.println(stars[0]);
//              System.out.println(stars[1]);
//               System.out.println(stars[2]);
//                System.out.println(stars[3]);
//                 System.out.println(stars[4]);
        resultCard.add(str1);
        resultCard.add(str2);
        resultCard.add(str3);
        resultCard.add(str4);
        resultCard.add(str5);
    }
}
