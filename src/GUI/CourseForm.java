package GUI;

import HibernateProject.main;
import POJOs.Course;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

import static HibernateProject.main.l_Course;

public class CourseForm extends JFrame {
    private JTable tableData;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton searchButton;
    private JButton backToMainMenuButton;
    private JPanel CoursePanel;


    public CourseForm(){

        //JTABLE AREA, the whole block to make sure the index is fine
        UpdateDataToTable();


        add(CoursePanel);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500,500);


        backToMainMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                (new Login_Form()).showByMode(main.currentMode);
                dispose();
            }
        });

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInputs();
            }
        });
    }

    void UpdateDataToTable() {

        //FIRST COLUMN
        String column[] = {"MaCourse", "MaMonHoc", "GiaoVienLiThuyet", "TenPhongHoc", "NgayHoc", "CaHoc", "SlotToiDa"};
        String data[][] = new String[l_Course.size()][7];
        //NEXT

        for (int i = 0; i< l_Course.size(); i++) {
            data[i][0] = l_Course.get(i).getMaCourse();
            data[i][1] = l_Course.get(i).getMaMonHoc();
            data[i][2] = l_Course.get(i).getGiaoVienLiThuyet();
            data[i][3] = l_Course.get(i).getTenPhongHoc();
            data[i][4] = Integer.toString(l_Course.get(i).getNgayHoc());
            data[i][5] = Integer.toString(l_Course.get(i).getCaHoc());
            data[i][6] = Integer.toString(l_Course.get(i).getSoSlotToiDa());
        }

        DefaultTableModel table1 = new DefaultTableModel(data, column);
        tableData.setModel(table1);
    }

    String[] getInputs(){
        String res[] = new String[7];

        JFrame miniFrame = new JFrame();
        miniFrame.setSize(200,500);

        JPanel miniPane = new JPanel();


        miniPane.add(new JLabel("Input all infomation below"));

        miniPane.add(new JLabel("Ma Course"));

        JTextField mc = new JTextField();
        mc.setBounds(0,50, 100,20);
        miniPane.add(mc);
        JTextField mmh = new JTextField("Ma Mon Hoc");
        mmh.setBounds(0,100, 100,20);
        miniPane.add(mmh);

        JButton btn = new JButton("Submit");
        btn.setBounds(0,150,100,20);
        miniPane.add(btn);

        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                res[0] = mc.getText();
                res[1] = mmh.getText();
                System.out.println(res[0]);
                miniFrame.dispose();
            }
        });

        miniFrame.add(miniPane);
        miniFrame.setVisible(true);
        return res;

    }
}

