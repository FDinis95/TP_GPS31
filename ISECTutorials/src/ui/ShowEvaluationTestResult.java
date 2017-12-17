package ui;

import data.Progression;
import java.awt.BorderLayout;
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


        resultCard.add(new JLabel("this will be resutls!"));
        JProgressBar progress = new JProgressBar(0, 20);
        result = 5;
        progress.setValue(result);
        resultCard.add(progress);

////Calcular Número de estrelas completas ou incompletas
        int total = pro.getTotalNumberOfQuestionsAnswered();
        int chapter[] = pro.getChapter();
        int correct = 7;

        JButton btn = new JButton("Next");
        btn.addActionListener((ActionEvent event) ->
        {
            cardPanel.add(new ShowTutorial().tutorial(path, 0, cards, cardPanel), "tutorial"); //CHECK CHAPTER LOCKED
            cards.next(cardPanel);
        });
        
//        for(int i = 0; i <10 ; i++)
//        {
//            if( chapter[i] == pro.getCorrect())
//                correct++;
//        }
//      somar os valores do array chapter[] para saber nº de capitulos desbloqueados

        
        resultCard.add(btn);
            

//        Verificar valor do "result" e preencher as estrelas       
        
// Estrelas vazias
        if (correct==0) {
        str1.setIcon(new ImageIcon("images/star-outline.png"));
        str2.setIcon(new ImageIcon("images/star-outline.png"));
        str3.setIcon(new ImageIcon("images/star-outline.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
            
            }
// Meia estrela
            if (1 < correct && correct <=2 ) {
        str1.setIcon(new ImageIcon("images/star-half.png"));
        str2.setIcon(new ImageIcon("images/star-outline.png"));
        str3.setIcon(new ImageIcon("images/star-outline.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
//  Uma estrela            
            if (2 < correct && correct <=4 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star-outline.png"));
        str3.setIcon(new ImageIcon("images/star-outline.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
//  Uma estrela   e meia         
            if (5 < correct && correct <=6 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star-half.png"));
        str3.setIcon(new ImageIcon("images/star-outline.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
//            Duas estrelas         
            if (6 < correct && correct <=8 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star-outline.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
//            Duas estrelas  e meia
            if (8 < correct && correct <=10 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star-half.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
//          Tres estrelas
                if (10 < correct && correct <=12 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star.png"));
        str4.setIcon(new ImageIcon("images/star-outline.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
 //          Tres estrelas e meia       
                if (12 < correct && correct <=14 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star.png"));
        str4.setIcon(new ImageIcon("images/star-half.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
        
 //         Quatro estrelas    
                if (14 < correct && correct <=16 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star.png"));
        str4.setIcon(new ImageIcon("images/star.png"));
        str5.setIcon(new ImageIcon("images/star-outline.png"));
        }
 //         Quatro estrelas  e meia  
                if (16 < correct && correct <=18 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star.png"));
        str4.setIcon(new ImageIcon("images/star.png"));
        str5.setIcon(new ImageIcon("images/star-half.png"));
        }
//        Cinco Estrelas 
                if (18 < correct && correct <= 20 ) {
        str1.setIcon(new ImageIcon("images/star.png"));
        str2.setIcon(new ImageIcon("images/star.png"));
        str3.setIcon(new ImageIcon("images/star.png"));
        str4.setIcon(new ImageIcon("images/star.png"));
        str5.setIcon(new ImageIcon("images/star.png"));
        }
                
        resultCard.add(str1);
        resultCard.add(str2);
        resultCard.add(str3);
        resultCard.add(str4);
        resultCard.add(str5);
        
        return resultCard;
    }

}
