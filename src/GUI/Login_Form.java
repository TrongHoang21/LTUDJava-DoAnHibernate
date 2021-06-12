package GUI;

import DAO.GiaoVuAccountDAO;
import DAO.SinhVienAccountDAO;
import HibernateProject.main;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Login_Form {
    private JButton loginButton;
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private final JFrame frame;

    public Login_Form()
    {
        frame = new JFrame();

        textField1.setSize(100,50);
        passwordField1.setSize(100,50);
        loginButton.setEnabled(false);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.add(panel1);
        frame.setVisible(true);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int res = CheckLogin();
                showByMode(1);
            }
        });

        //LOAD DATA HIBERNATE IN ANOTHER THREAD FOR BETTER PERFORMANCE
        Runnable preloadData = new Runnable() {
            @Override
            public void run() {
                main.l_GiaoVu = GiaoVuAccountDAO.showListGiaoVu();
                main.l_SinhVien = SinhVienAccountDAO.showListSinhVien();
                loginButton.setEnabled(true);
            }
        };

        new Thread(preloadData).start();

    }



    public int CheckLogin(){

        if(textField1 == null || passwordField1 == null)
            return 0;

        for(int i=0; i<main.l_GiaoVu.size(); i++){
            String name = main.l_GiaoVu.get(i).getUserName();
            String pass = main.l_GiaoVu.get(i).getPassWord();
            if(name.equals(textField1.getText()) && pass.equals(new String(passwordField1.getPassword()))){
                main.currentUser = name;
                main.currentMode = 1;
                return 1;
            }
        }

        for(int i = 0; i<main.l_SinhVien.size(); i++){
            String name = main.l_SinhVien.get(i).getUserName();
            String pass = main.l_SinhVien.get(i).getPassWord();
            if(name.equals(textField1.getText()) && pass.equals(new String(passwordField1.getPassword()))){
                main.currentUser = name;
                main.currentMode = 2;
                return 2;
            }
        }

        return 0;
    }

    public void showByMode(int mode){
        if (mode == 1)
        {
            //giao vu screen
            MainMenu m = new MainMenu(1);
            m.setVisible(true);
            frame.dispose();
        }
        else if(mode == 2){
            //sinh vien screen
            MainMenu m = new MainMenu(2);
            m.setVisible(true);
            frame.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(frame,"Wrong username or password");
        }
    }
}
