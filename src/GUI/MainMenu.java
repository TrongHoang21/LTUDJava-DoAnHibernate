package GUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import HibernateProject.main;

public class MainMenu extends JFrame {
    private JButton LOGOUTButton;
    private JPanel panelMain;
    private JLabel welcomeLabel;
    private JButton registrationSessionButton;
    private JButton CourseButton;

    public MainMenu(int isGiaoVuScreen)
    {
        welcomeLabel.setText("");
        welcomeLabel.setBounds(0, 0, 150, 50);
        add(welcomeLabel);

        setSize(500, 500);
        LOGOUTButton.setBounds(0, 450, 50, 50);
        add(panelMain);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        if(isGiaoVuScreen == 1) {
            welcomeLabel.setText("Xin chao giao vu");
        }
        else
        {
            welcomeLabel.setText("Xin chao sinh vien");
        }

        //Button config AREA

        LOGOUTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main.f = new Login_Form();
                dispose();
            }
        });

        CourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CourseForm().setVisible(true);
                dispose();
            }
        });
    }
}
