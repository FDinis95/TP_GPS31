package ui;

import data.FindPath;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class CreateMainMenu extends JFrame implements ActionListener {

    
    JLabel text;
    FindPath fp = new FindPath();

    public CreateMainMenu() throws HeadlessException {
        

        JFrame f = new JFrame("Main Menu");
        text = new JLabel("Select a language:");
        text.setHorizontalAlignment(JLabel.CENTER);
        text.setSize(400,100);
        text.setBounds(50, 50, 300, 20);

        for (String label : fp.getName()) {
            System.err.println(label);
            JButton btn = new JButton(label);
            btn.setBounds(100, 250, 80, 30);
            btn.addActionListener(this);
            add(btn);
        }
        f.setSize(400,400);
        setLayout(new java.awt.GridLayout(3, 0));
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
