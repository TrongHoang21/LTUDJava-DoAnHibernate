package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import HibernateProject.main;

public class MainMenu extends JFrame {
    private JButton LOGOUTButton;
    private JPanel panelMain;
    private JLabel welcomeLabel;

    public MainMenu(int isGiaoVuScreen)
    {
        welcomeLabel.setText("");
        welcomeLabel.setBounds(0, 50, 150, 50);
        add(welcomeLabel);

        setSize(500, 500);
        LOGOUTButton.setBounds(0, 450, 50, 50);
        add(panelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.f = new Login_Form();
                dispose();
            }
        });

        if(isGiaoVuScreen == 1) {
            welcomeLabel.setText("Xin chao giao vu");
        }
        else
        {
            welcomeLabel.setText("Xin chao sinh vien");
        }
    }
}
