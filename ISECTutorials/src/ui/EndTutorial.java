package ui;

import data.Progression;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import logic.Helper;

public class EndTutorial {

    public EndTutorial() {
    }

    public JPanel endScreen(Progression pro) {
//        Verificar capítulos concluídos Helper

        JPanel pnEndCard;

        JPanel pnBlank;
        JLabel lbTEXT;

        JPanel pnBlankEsq;

        JPanel pnBlankDir;

        JPanel pnBlankTOP;

        JPanel pnBotao;
        JButton btExit;

        JPanel pnCentral;
        JLabel lbLabel4;

        pnEndCard = new JPanel();
        GridBagLayout gbEndCard = new GridBagLayout();
        GridBagConstraints gbcEndCard = new GridBagConstraints();
        pnEndCard.setLayout(gbEndCard);

        pnBlank = new JPanel();
        GridBagLayout gbBlank = new GridBagLayout();
        GridBagConstraints gbcBlank = new GridBagConstraints();
        pnBlank.setLayout(gbBlank);

        lbTEXT = new JLabel("Congratulations on completing the tutorial, we hope you liked it and have learned something out of it!");
        Font lbTEXTFont = lbTEXT.getFont();
        lbTEXT.setFont(new Font(lbTEXTFont.getName(), Font.PLAIN, 17));
        JLabel test1 = new JLabel(" ");
        gbcBlank.gridx = 0;
        gbcBlank.gridy = 0;
        gbcBlank.gridwidth = 30;
        gbcBlank.gridheight = 5;
        gbcBlank.fill = GridBagConstraints.VERTICAL;
        gbcBlank.weightx = 1;
        gbcBlank.weighty = 1;
        gbcBlank.anchor = GridBagConstraints.NORTH;
        gbBlank.setConstraints(lbTEXT, gbcBlank);
        pnBlank.add(lbTEXT);
        pnBlank.add(test1);
        gbcEndCard.gridx = 0;
        gbcEndCard.gridy = 0;
        gbcEndCard.gridwidth = 30;
        gbcEndCard.gridheight = 5;
        gbcEndCard.fill = GridBagConstraints.BOTH;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 1;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnBlank, gbcEndCard);
        pnEndCard.add(pnBlank);

        pnBlankEsq = new JPanel();
        GridBagLayout gbBlankEsq = new GridBagLayout();
        GridBagConstraints gbcBlankEsq = new GridBagConstraints();
        pnBlankEsq.setLayout(gbBlankEsq);
        gbcEndCard.gridx = 0;
        gbcEndCard.gridy = 18;
        gbcEndCard.gridwidth = 9;
        gbcEndCard.gridheight = 12;
        gbcEndCard.fill = GridBagConstraints.BOTH;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 0;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnBlankEsq, gbcEndCard);
        pnEndCard.add(pnBlankEsq);

        pnBlankDir = new JPanel();
        GridBagLayout gbBlankDir = new GridBagLayout();
        GridBagConstraints gbcBlankDir = new GridBagConstraints();
        pnBlankDir.setLayout(gbBlankDir);
        gbcEndCard.gridx = 21;
        gbcEndCard.gridy = 18;
        gbcEndCard.gridwidth = 9;
        gbcEndCard.gridheight = 12;
        gbcEndCard.fill = GridBagConstraints.BOTH;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 0;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnBlankDir, gbcEndCard);
        pnEndCard.add(pnBlankDir);

        pnBlankTOP = new JPanel();
        GridBagLayout gbBlankTOP = new GridBagLayout();
        GridBagConstraints gbcBlankTOP = new GridBagConstraints();
        pnBlankTOP.setLayout(gbBlankTOP);
        gbcEndCard.gridx = 9;
        gbcEndCard.gridy = 18;
        gbcEndCard.gridwidth = 12;
        gbcEndCard.gridheight = 6;
        gbcEndCard.fill = GridBagConstraints.BOTH;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 1;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnBlankTOP, gbcEndCard);
        pnEndCard.add(pnBlankTOP);

        pnBotao = new JPanel();
        GridBagLayout gbBotao = new GridBagLayout();
        GridBagConstraints gbcBotao = new GridBagConstraints();
        pnBotao.setLayout(gbBotao);

        btExit = new JButton("EXIT");
        gbcBotao.gridx = 2;
        gbcBotao.gridy = 1;
        gbcBotao.gridwidth = 8;
        gbcBotao.gridheight = 4;
        gbcBotao.fill = GridBagConstraints.BOTH;
        gbcBotao.weightx = 1;
        gbcBotao.weighty = 1;
        gbcBotao.anchor = GridBagConstraints.SOUTH;
        
        btExit.addActionListener((ActionEvent event) ->
        {
            System.exit(0);           
        });
        
        gbBotao.setConstraints(btExit, gbcBotao);
        pnBotao.add(btExit);
        gbcEndCard.gridx = 9;
        gbcEndCard.gridy = 24;
        gbcEndCard.gridwidth = 12;
        gbcEndCard.gridheight = 6;
        gbcEndCard.fill = GridBagConstraints.CENTER;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 1;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnBotao, gbcEndCard);
        pnEndCard.add(pnBotao);

        pnCentral = new JPanel();
        GridBagLayout gbCentral = new GridBagLayout();
        GridBagConstraints gbcCentral = new GridBagConstraints();
        pnCentral.setLayout(gbCentral);

        Helper help = new Helper();

        String stars[] =  new String[5];
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

        stars[0] = "src/logic/images/star.png";
        str1.setIcon(new ImageIcon(stars[0]));
        stars[1] = "src/logic/images/star.png";
        str2.setIcon(new ImageIcon(stars[1]));
        stars[2] = "src/logic/images/star.png";
        str3.setIcon(new ImageIcon(stars[2]));
        stars[3] = "src/logic/images/star.png";
        str4.setIcon(new ImageIcon(stars[3]));
        stars[4] = "src/logic/images/star.png";
        str5.setIcon(new ImageIcon(stars[4]));
        
        pnCentral.add(str1);
        pnCentral.add(str2);
        pnCentral.add(str3);
        pnCentral.add(str4);
        pnCentral.add(str5);        
        
        gbcEndCard.gridx = 0;
        gbcEndCard.gridy = 5;
        gbcEndCard.gridwidth = 30;
        gbcEndCard.gridheight = 13;
        gbcEndCard.fill = GridBagConstraints.BOTH;
        gbcEndCard.weightx = 1;
        gbcEndCard.weighty = 0;
        gbcEndCard.anchor = GridBagConstraints.NORTH;
        gbEndCard.setConstraints(pnCentral, gbcEndCard);
        pnEndCard.add(pnCentral);

        return pnEndCard;
    }

}
